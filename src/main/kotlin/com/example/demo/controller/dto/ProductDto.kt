package com.example.demo.controller.dto

import java.util.UUID


class ProductDto(
    val id: UUID?,
    val title: String?,
    val price: Long?) {

    data class Builder(
        var id: UUID?=null,
        var title: String? = null,
        var price: Long?= null) {

        fun id(id: UUID?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun build() = ProductDto(id, title, price)
    }
}