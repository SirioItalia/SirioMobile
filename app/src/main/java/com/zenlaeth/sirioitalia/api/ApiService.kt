package com.zenlaeth.sirioitalia.api

import com.zenlaeth.sirioitalia.models.NewUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/furnitures")
    fun getFurnitures() :Call<MutableList<FurnitureModel>>

    // User
    @POST("/users/register")
    fun createUser(@Body request: NewUser) :Call<MutableList<NewUser>>

//    fun createUser(
//        @Field("firstName") firstName:String,
//        @Field("lastName") lastName:String,
//        @Field("email") email:String,
//        @Field("passwordHash") passwordHash:String,
//        @Field("streetName") streetName:String,
//        @Field("streetType") streetType:String,
//        @Field("streetNumber") streetNumber:String,
//        @Field("zipCode") zipCode:String,
//        @Field("city") city:String,
//        @Field("birthDate") birthDate: Date,
//        @Field("phoneNumber") phoneNumber:Int,
//    ) :Call<MutableList<UserModel>>
}