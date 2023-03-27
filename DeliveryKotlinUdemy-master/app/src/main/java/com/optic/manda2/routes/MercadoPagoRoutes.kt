package com.sena.manda2.routes

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sena.manda2.models.MercadoPagoCardTokenBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MercadoPagoRoutes {

    @GET("v1/payment_methods/installments?access_token=TEST-6028900970379574-062302-e3e5d11b7871ee742832e6351694608f-191014229")
    fun getInstallments(@Query("bin") bin: String, @Query("amount") amount: String): Call<JsonArray>

    @POST("v1/card_tokens?public_key=TEST-4d2b763d-c2b7-4ca4-8a6c-7f1651b831fe")
    fun createCardToken(@Body body: MercadoPagoCardTokenBody): Call<JsonObject>
}