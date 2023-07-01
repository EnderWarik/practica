package com.example.demo.action.product

import com.example.demo.action.product.argument.CreateProductActionArgument
import com.example.demo.model.Product
import com.example.demo.service.card.CardService
import com.example.demo.service.product.ProductService
import com.example.demo.service.product.arguments.CreateProductArgument
import com.example.demo.service.category.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
 class CreateProductAction(
    val productService: ProductService,
    val categoryService: CategoryService,
    val cardService: CardService
 ) {

    fun execute(argument: CreateProductActionArgument): Product {
        val card = argument.categoryId?.let { cardService.getExisting(it) }
        val category = argument.categoryId?.let { categoryService.getExisting(it) }
        return productService.create(
            CreateProductArgument.Builder()
                .price(argument.price)
                .title(argument.title)
                .category(category)
                .card(card)
                .build()
        )
    }
}