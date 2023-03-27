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
import com.google.gson.Gson
import com.sena.manda2.R
import com.sena.manda2.activities.client.address.list.ClientAddressListActivity
import com.sena.manda2.activities.client.home.ClientHomeActivity
import com.sena.manda2.activities.client.orders.detail.ClientOrdersDetailActivity
import com.sena.manda2.activities.client.products.list.ClientProductsListActivity
import com.sena.manda2.activities.delivery.home.DeliveryHomeActivity
import com.sena.manda2.activities.restaurant.home.RestaurantHomeActivity
import com.sena.manda2.activities.restaurant.orders.detail.RestaurantOrdersDetailActivity
import com.sena.manda2.models.Address
import com.sena.manda2.models.Category
import com.sena.manda2.models.Order
import com.sena.manda2.models.Rol
import com.sena.manda2.utils.SharedPref

class OrdersRestaurantAdapter(val context: Activity, val orders: ArrayList<Order>): RecyclerView.Adapter<OrdersRestaurantAdapter.OrdersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_orders_restaurant, parent, false)
        return OrdersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {

        val order = orders[position] // CADA UNA DE LAS ORDENES

        holder.textViewOrderId.text = "Orden #${order.id}"
        holder.textViewDate.text = "${order.timestamp}"
        holder.textViewAddress.text = "${order.address?.address}"
        holder.textViewClient.text = "${order.client?.name} ${order?.client?.lastname}"

        holder.itemView.setOnClickListener { goToOrderDetail(order) }
    }

    private fun goToOrderDetail(order: Order) {
        val i = Intent(context, RestaurantOrdersDetailActivity::class.java)
        i.putExtra("order", order.toJson())
        context.startActivity(i)
    }

    class OrdersViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewOrderId: TextView
        val textViewDate: TextView
        val textViewAddress: TextView
        val textViewClient: TextView

        init {
            textViewOrderId = view.findViewById(R.id.textview_order_id)
            textViewDate = view.findViewById(R.id.textview_date)
            textViewAddress = view.findViewById(R.id.textview_address)
            textViewClient = view.findViewById(R.id.textview_client)
        }

    }

}