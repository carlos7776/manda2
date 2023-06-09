package com.sena.manda2.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sena.manda2.R
import com.sena.manda2.activities.client.home.ClientHomeActivity
import com.sena.manda2.activities.client.products.list.ClientProductsListActivity
import com.sena.manda2.activities.delivery.home.DeliveryHomeActivity
import com.sena.manda2.activities.restaurant.home.RestaurantHomeActivity
import com.sena.manda2.models.Category
import com.sena.manda2.models.Rol
import com.sena.manda2.utils.SharedPref

class CategoriesAdapter(val context: Activity, val categories: ArrayList<Category>): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    val sharedPref = SharedPref(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_categories, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        val category = categories[position] // CADA UNA DE LAS CATEGORIAS

        holder.textViewCategory.text = category.name
        Glide.with(context).load(category.image).into(holder.imageViewCategory)


        holder.itemView.setOnClickListener { goToProducts(category) }
    }

    private fun goToProducts(category: Category) {
        val i = Intent(context, ClientProductsListActivity::class.java)
        i.putExtra("idCategory", category.id)
        context.startActivity(i)
    }

    class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewCategory: TextView
        val imageViewCategory: ImageView

        init {
            textViewCategory = view.findViewById(R.id.textview_category)
            imageViewCategory = view.findViewById(R.id.imageview_category)
        }

    }

}