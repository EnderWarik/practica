package com.example.demo.controller.card.dto

import com.example.demo.model.Card
import com.example.demo.model.Category
import com.example.demo.model.Product
import java.util.*

public class CreateCardDto (
    var products: List<Product>?
)
{
    data class Builder(
        var products: List<Product>? = null) {


        fun products(products: List<Product>?) = apply { this.products = products }

        fun build() = CreateCardDto(products)
    }
}