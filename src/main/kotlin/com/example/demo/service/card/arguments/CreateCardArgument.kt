package com.example.demo.service.card.arguments

import com.example.demo.model.Card
import com.example.demo.model.Category
import com.example.demo.model.Product
import java.util.*

public class CreateCardArgument (
    var products: List<Product>?
)
{
    data class Builder(
        var products: List<Product>? = null) {


        fun products(products: List<Product>?) = apply { this.products = products }

        fun build() = CreateCardArgument(products)
    }
}