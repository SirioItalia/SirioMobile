package com.zenlaeth.sirioitalia.models

data class NewCart(
    var quantity: Int,
    var item: Item,
    var user: User,
)

data class Item(
    var id: Int,
)

data class User(
    var id: Int,
)