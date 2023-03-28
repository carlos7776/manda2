package com.sena.manda2.providers

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sena.manda2.api.MercadoPagoApiRoutes
import com.sena.manda2.models.MercadoPagoCardTokenBody
import com.sena.manda2.routes.MercadoPagoRoutes
import retrofit2.Call

class MercadoPagoProvider {

    var mercadoPagoRoutes: MercadoPagoRoutes? = null

    init {
        val api = MercadoPagoApiRoutes()
        mercadoPagoRoutes = api.getMercadoPagoRoutes()
    }

    fun getInstallments(bin: String, amount: String): Call<JsonArray>? {
        return mercadoPagoRoutes?.getInstallments(bin, amount)
    }

    fun createCardToken(mercadoPagoCardTokenBody: MercadoPagoCardTokenBody): Call<JsonObject>? {
        return mercadoPagoRoutes?.createCardToken(mercadoPagoCardTokenBody)
    }

}