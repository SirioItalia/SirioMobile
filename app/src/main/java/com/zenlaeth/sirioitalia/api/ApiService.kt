package com.zenlaeth.sirioitalia.api

import com.zenlaeth.sirioitalia.models.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/furnitures")
    fun getFurnitures() :Call<MutableList<FurnitureModel>>

    @GET("/categories")
    fun getCategories() :Call<MutableList<CategoryModel>>

    // user

//    @POST("/auth/login")
//    fun loginUser(@Body request: LoginUser) :Call<MutableList<LoginUser>>

//    @FormUrlEncoded
//    @POST("/auth/login")
//    fun loginUser(@Header("email") email: String, @Header("password") password: String) : Call<MutableList<LoginUser>>

    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/auth/login")
    fun loginUser(@Field("email") email: String, @Field("password") password: String) : Call<ResponseBody>

    @POST("/users/register")
    fun createUser(@Body request: NewUser) :Call<MutableList<NewUser>>

    // carts
    @GET("/carts")
    fun getCarts() :Call<MutableList<CartModel>>

    @POST("/carts")
    fun createCart(@Body request: NewCart) :Call<MutableList<NewCart>>
}