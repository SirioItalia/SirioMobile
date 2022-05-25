package com.zenlaeth.sirioitalia.api

data class FurnitureModel(
    var category: Category,
    var description: String,
    var dimension: Dimension,
    var id: Int,
    var items: List<Item>,
    var label: String,
    var weight: Int
)

data class Category(
    var id: Int,
    var label: String
)

data class Dimension(
    var height: Int,
    var length: Int,
    var width: Int
)

data class Item(
    var color: Color,
    var id: Int,
    var images: List<Any>,
    var price: Int,
    var ratings: List<Any>
)

data class Color(
    var hexadecimalCode: String,
    var id: Int,
    var label: String
)