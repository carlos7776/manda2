package com.sena.manda2.providers

import android.util.Log
import com.sena.manda2.api.ApiRoutes
import com.sena.manda2.models.*
import com.sena.manda2.routes.AddressRoutes
import com.sena.manda2.routes.CategoriesRoutes
import com.sena.manda2.routes.OrdersRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class OrdersProvider(val token: String) {

    private var ordersRoutes: OrdersRoutes? = null

    init {
        val api = ApiRoutes()
        ordersRoutes = api.getOrdersRoutes(token)
    }

    fun getOrdersByStatus(status: String): Call<ArrayList<Order>>? {
        return ordersRoutes?.getOrdersByStatus(status, token)
    }

    fun getOrdersByClientAndStatus(idClient: String, status: String): Call<ArrayList<Order>>? {
        return ordersRoutes?.getOrdersByClientAndStatus(idClient, status, token)
    }

    fun getOrdersByDeliveryAndStatus(idDelivery: String, status: String): Call<ArrayList<Order>>? {
        return ordersRoutes?.getOrdersByDeliveryAndStatus(idDelivery, status, token)
    }

    fun create(order: Order): Call<ResponseHttp>? {
        return ordersRoutes?.create(order, token)
    }

    fun updateToDispatched(order: Order): Call<ResponseHttp>? {
        return ordersRoutes?.updateToDispatched(order, token)
    }

    fun updateToOnTheWay(order: Order): Call<ResponseHttp>? {
        return ordersRoutes?.updateToOnTheWay(order, token)
    }

    fun updateToDelivered(order: Order): Call<ResponseHttp>? {
        return ordersRoutes?.updateToDelivered(order, token)
    }

    fun updateLatLng(order: Order): Call<ResponseHttp>? {
        return ordersRoutes?.updateLatLng(order, token)
    }

}