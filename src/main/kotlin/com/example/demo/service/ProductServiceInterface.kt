package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateProductArgument
import java.util.*


interface ProductServiceInterface {
    fun list(): List<Product?>

    fun create(argument: CreateProductArgument): Product

    fun getExisting(id: UUID): Product?

    fun update(id: UUID?, argument: UpdateProductArgument): Product
}