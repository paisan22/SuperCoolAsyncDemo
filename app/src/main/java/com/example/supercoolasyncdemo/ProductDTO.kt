package com.example.supercoolasyncdemo

data class ProductDTO(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String? = null,
    val category: String? = null,
    val image: String? = null,
    val rating: Rating? = null
)

data class Rating(
    val rate: Double,
    val count: Int,
)
