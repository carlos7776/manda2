package com.sena.manda2.routes


import com.sena.manda2.models.Category
import com.sena.manda2.models.MercadoPagoPayment
import com.sena.manda2.models.ResponseHttp
import com.sena.manda2.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface PaymentsRoutes {

    @POST("payments/create")
    fun createPayment(
        @Body mercadoPagoPayment: MercadoPagoPayment,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>



}