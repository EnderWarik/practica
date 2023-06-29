package com.example.demo.controller.mapper

import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.controller.dto.*
import com.example.demo.model.Category
import com.example.demo.model.Product
import com.example.demo.service.argument.CreateCategoryArgument
import com.example.demo.service.argument.SearchProductArgument
import com.example.demo.service.argument.UpdateCategoryArgument
import org.springframework.stereotype.Component

@Component
class CategoryMapper {


    fun categoryDto(category: Category) : CategoryDto
    {
        return CategoryDto.Builder()
            .id(category.id)
            .title(category.title)
            .build()
    }

    fun createCategoryArgument(dto: CreateCategoryDto) : CreateCategoryArgument
    {
       return  CreateCategoryArgument.Builder()
           .title(dto.title)
           .build()
    }

    fun updateCategoryArgument(dto: UpdateCategoryDto?) : UpdateCategoryArgument
    {
        return  UpdateCategoryArgument
            .Builder()
            .title(dto?.title)
            .build()
    }
}