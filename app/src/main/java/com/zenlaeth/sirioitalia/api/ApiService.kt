package com.zenlaeth.sirioitalia.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/furnitures")
    fun getFurnitures() :Call<MutableList<FurnitureModel>>
}