package com.example.supercoolasyncdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductService {
    companion object {
        private val BASE_URL = "https://fakestoreapi.com/"
    }

    suspend fun getProducts(): List<ProductDTO>? {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service =  retrofit.create(ApiService::class.java)

        return service.getProducts().execute().body()
    }
}