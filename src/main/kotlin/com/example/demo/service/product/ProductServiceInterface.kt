package com.example.demo.service.product

import com.example.demo.model.Product
import com.example.demo.service.product.arguments.CreateProductArgument
import com.example.demo.service.product.arguments.SearchProductArgument
import com.example.demo.service.product.arguments.UpdateProductArgument
import java.util.*


interface ProductServiceInterface {
    fun list(argument: SearchProductArgument): List<Product?>

    fun create(argument: CreateProductArgument): Product

    fun getExisting(id: UUID): Product

    fun update(id: UUID, argument: UpdateProductArgument): Product

     fun delete(id: UUID?)
}