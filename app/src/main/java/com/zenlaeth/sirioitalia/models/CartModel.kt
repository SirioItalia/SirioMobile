package com.zenlaeth.sirioitalia.models

data class CartModel(
    val quantity: Int,
    val cartPK: CartPK,
    val item: Item,
    val user: User
)

data class CartPK(
    val itemId: Int,
    val userId: Int
)

data class Item(
    val category: String,
    val color: Color,
    val description: String,
    val furnitureId: String,
    val id: Int,
    val label: String,
    val price: Double,
)

data class User(
    val firstName: String,
    val id: Int,
    val lastName: String
)

data class Color(
    val hexadecimalCode: String,
    val id: Int,
    val label: String
)

data class NewCart(
    var quantity: Int,
    var item: NewCartItem,
    var user: NewCartUser,
)

data class NewCartItem(
    var id: Int,
)

data class NewCartUser(
    var id: Int,
)