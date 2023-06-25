package com.example.demo.service

import com.example.demo.model.Product




interface ProductServiceInterface {
    fun list(): List<Product?>

    fun create(argument: CreateProductArgument): Product

    fun getExisting(id: Long): Product?

    fun update(id: Long, argument: UpdateProductArgument): Product
}