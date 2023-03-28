package com.sena.manda2.providers

import android.util.Log
import com.google.gson.JsonObject
import com.sena.manda2.api.ApiRoutes
import com.sena.manda2.api.CurrencyApiRoutes
import com.sena.manda2.models.Address
import com.sena.manda2.models.Category
import com.sena.manda2.models.ResponseHttp
import com.sena.manda2.models.User
import com.sena.manda2.routes.AddressRoutes
import com.sena.manda2.routes.CategoriesRoutes
import com.sena.manda2.routes.CurrencyRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File

class CurrencyProvider() {

    private var currencyRoutes: CurrencyRoutes? = null

    init {
        val api = CurrencyApiRoutes()
        currencyRoutes = api.getCurrencyRoutes()
    }

    fun getCurrencyValue(): Call<JsonObject>? {
        return currencyRoutes?.getCurrencyValue()
    }


}