package com.example.demo.service.serviceInterfaces

import com.example.demo.model.Category
import com.example.demo.model.Product
import com.example.demo.service.argument.CreateCategoryArgument
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateCategoryArgument
import com.example.demo.service.argument.UpdateProductArgument
import java.util.*


interface CategoryServiceInterface  {
    fun list(): List<Category?>

    fun create(argument: CreateCategoryArgument): Category

     fun getExisting(id: UUID): Category?

     fun update(id: UUID?, argument: UpdateCategoryArgument) : Category

    fun delete(id: UUID?)
}