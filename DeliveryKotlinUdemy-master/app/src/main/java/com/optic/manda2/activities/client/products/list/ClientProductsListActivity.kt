package com.sena.manda2.activities.client.products.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sena.manda2.R
import com.sena.manda2.adapters.ProductsAdapter
import com.sena.manda2.models.Product
import com.sena.manda2.models.User
import com.sena.manda2.providers.ProductsProvider
import com.sena.manda2.utils.SharedPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientProductsListActivity : AppCompatActivity() {

    val TAG = "ClientProducts"
    var recyclerViewProducts: RecyclerView? = null
    var adapter: ProductsAdapter? = null

    var user: User? = null
    var sharedPref: SharedPref? = null

    var productsProvider: ProductsProvider? = null
    var products: ArrayList<Product> = ArrayList()

    var idCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_products_list)

        sharedPref = SharedPref(this)

        idCategory = intent.getStringExtra("idCategory")

        getUserFromSession()
        productsProvider = ProductsProvider(user?.sessionToken!!)

        recyclerViewProducts = findViewById(R.id.recyclerview_products)
        recyclerViewProducts?.layoutManager = GridLayoutManager(this, 2)

        getProducts()
    }

    private fun getUserFromSession() {

        val gson = Gson()

        if (!sharedPref?.getData("user").isNullOrBlank()) {
            // SI EL USARIO EXISTE EN SESION
            user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
        }

    }

    private fun getProducts() {
        productsProvider?.findByCategory(idCategory!!)?.enqueue(object: Callback<ArrayList<Product>> {
            override fun onResponse(
                call: Call<ArrayList<Product>>,
                response: Response<ArrayList<Product>>
            ) {

                if (response.body() != null) {
                    products = response.body()!!
                    adapter = ProductsAdapter(this@ClientProductsListActivity, products)
                    recyclerViewProducts?.adapter = adapter
                }

            }

            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                Toast.makeText(this@ClientProductsListActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Error: ${t.message}")
            }

        })
    }
}