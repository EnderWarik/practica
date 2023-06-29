package com.example.demo.controller.product.dto

import java.util.*


class UpdateProductDto(
    val title: String?,
    val price: Long?,
    val categoryId: UUID?
) {

    data class Builder(
        var title: String? = null,
        var price: Long?= null,
        var categoryId: UUID? = null){

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun categoryId(categoryId: UUID?) = apply { this.categoryId = categoryId }
        fun build() = CreateProductDto(title, price, categoryId)
    }
}