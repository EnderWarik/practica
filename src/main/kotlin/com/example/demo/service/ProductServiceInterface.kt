package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateProductArgument


interface ProductServiceInterface {
    fun list(): List<Product?>

    fun create(argument: CreateProductArgument): Product

    fun getExisting(id: Long): Product?

    fun update(id: Long?, argument: UpdateProductArgument): Product
}