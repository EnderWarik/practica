package com.example.demo.action

import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.action.argument.UpdateCategoryActionArgument
import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.model.Category
import com.example.demo.model.Product
import com.example.demo.service.implementation.ProductService
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateCategoryArgument
import com.example.demo.service.argument.UpdateProductArgument
import com.example.demo.service.implementation.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import java.util.*

@Component
@RequiredArgsConstructor
 class UpdateCategoryAction(val categoryService: CategoryService) {
    fun execute(id: UUID?,argument: UpdateCategoryActionArgument): Category {

        return categoryService.update(
            id,
            UpdateCategoryArgument
                .Builder()
                .title(argument.title)
                .build()
        )
    }
}