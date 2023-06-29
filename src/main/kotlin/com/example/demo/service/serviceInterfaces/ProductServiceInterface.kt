package com.example.demo.service.serviceInterfaces

import com.example.demo.model.Product
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.SearchProductArgument
import com.example.demo.service.argument.UpdateProductArgument
import java.util.*


interface ProductServiceInterface {
    fun list(argument: SearchProductArgument): List<Product?>

    fun create(argument: CreateProductArgument): Product

    fun getExisting(id: UUID): Product

    fun update(id: UUID, argument: UpdateProductArgument): Product

     fun delete(id: UUID?)
}