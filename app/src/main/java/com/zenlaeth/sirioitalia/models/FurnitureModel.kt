package com.zenlaeth.sirioitalia.api

data class FurnitureModel(
    var category: Category,
    var description: String,
    var dimension: Dimension,
    var id: Int,
    var price: Int,
    var items: Any,
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