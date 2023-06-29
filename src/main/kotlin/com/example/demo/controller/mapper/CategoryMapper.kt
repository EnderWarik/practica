package com.example.demo.controller.mapper

import com.example.demo.controller.dto.*
import com.example.demo.model.Category
import com.example.demo.service.category.arguments.CreateCategoryArgument
import com.example.demo.service.category.arguments.UpdateCategoryArgument
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