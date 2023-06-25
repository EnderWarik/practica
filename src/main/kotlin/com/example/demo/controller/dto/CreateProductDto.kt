package com.example.demo.controller.dto


class CreateProductDto(
    val title: String?,
    val price: Long?) {

    data class Builder(
        var title: String? = null,
        var price: Long?= null) {

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun build() = CreateProductDto(title, price)
    }
}