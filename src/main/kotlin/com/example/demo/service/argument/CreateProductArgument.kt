package com.example.demo.service.argument

import com.example.demo.model.Product

public class CreateProductArgument(
    var title: String?,
    var price: Long?,
    var products: List<Product>? = null
)
{
    data class Builder(
        var title: String? = null,
        var price: Long? = null,
        var products: List<Product>? = null
    )
    {

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun products(products: List<Product>??) = apply { this.products = products }
        fun build() = CreateProductArgument(title, price,products)
    }
}