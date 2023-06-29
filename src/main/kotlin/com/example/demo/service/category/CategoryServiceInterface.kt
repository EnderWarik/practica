package com.example.demo.service.category

import com.example.demo.model.Category
import com.example.demo.service.category.arguments.CreateCategoryArgument
import com.example.demo.service.category.arguments.UpdateCategoryArgument
import java.util.*


interface CategoryServiceInterface  {
    fun list(): List<Category?>

    fun create(argument: CreateCategoryArgument): Category

     fun getExisting(id: UUID): Category

     fun update(id: UUID, argument: UpdateCategoryArgument) : Category

    fun delete(id: UUID?)
}