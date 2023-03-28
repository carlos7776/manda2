package com.sena.manda2.routes


import com.google.gson.JsonObject
import com.sena.manda2.models.Address
import com.sena.manda2.models.Category
import com.sena.manda2.models.ResponseHttp
import com.sena.manda2.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface CurrencyRoutes {

    @GET("convert?q=USD_COP&compact=ultra&apiKey=49307d27b3df453fc8f0")
    fun getCurrencyValue(): Call<JsonObject>


}