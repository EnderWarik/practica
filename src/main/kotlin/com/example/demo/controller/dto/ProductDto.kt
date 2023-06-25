package com.example.demo.controller.dto


class ProductDto(
    val id: Long?,
    val title: String?,
    val price: Long?) {

    data class Builder(
        var id: Long?=null,
        var title: String? = null,
        var price: Long?= null) {

        fun id(id: Long)= apply { this.id = id }
        fun title(title: String) = apply { this.title = title }
        fun price(price: Long) = apply { this.price = price }
        fun build() = ProductDto(id, title, price)
    }
}