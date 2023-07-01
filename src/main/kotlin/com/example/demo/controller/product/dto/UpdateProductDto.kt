package com.example.demo.controller.product.dto

import java.util.*


class UpdateProductDto(
    val title: String?,
    val price: Long?,
    val categoryId: UUID?,
    var cardId: UUID? = null
) {

    data class Builder(
        var title: String? = null,
        var price: Long?= null,
        var categoryId: UUID? = null,
        var cardId: UUID? = null){

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun categoryId(categoryId: UUID?) = apply { this.categoryId = categoryId }
        fun cardId(cardId: UUID?) = apply { this.cardId = cardId }
        fun build() = CreateProductDto(title, price, categoryId,cardId)
    }
}