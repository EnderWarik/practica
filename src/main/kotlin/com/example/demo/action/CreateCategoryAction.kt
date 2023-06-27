package com.example.demo.action

import com.example.demo.action.argument.CreateCategoryActionArgument
import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.model.Category
import com.example.demo.model.Product
import com.example.demo.service.argument.CreateCategoryArgument
import com.example.demo.service.implementation.ProductService
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.implementation.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
 class CreateCategoryAction( val categoryService: CategoryService) {
    fun execute(argument: CreateCategoryActionArgument): Category {
        return categoryService.create(
            CreateCategoryArgument.Builder()
                .title(argument.title)
                .build()
        )
    }
}