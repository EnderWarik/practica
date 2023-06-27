package com.example.demo.controller.dto

import com.example.demo.model.Category
import java.util.UUID


class ProductDto(
    val id: UUID?,
    val title: String?,
    val price: Long?,
    var category: Category?) {

    data class Builder(
        var id: UUID?=null,
        var title: String? = null,
        var price: Long?= null,
        var category: Category? = null) {

        fun id(id: UUID?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun category(category: Category?) = apply { this.category = category }
        fun build() = ProductDto(id, title, price, category)
    }
}