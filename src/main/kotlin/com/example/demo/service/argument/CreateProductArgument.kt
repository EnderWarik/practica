package com.example.demo.service.argument

public class CreateProductArgument(
    var title: String?,
    var price: Long?
){
    data class Builder(

        var title: String? = null,
        var price: Long? = null) {

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun build() = CreateProductArgument(title, price)
    }
}