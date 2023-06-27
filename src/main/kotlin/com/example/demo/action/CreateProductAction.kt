package com.example.demo.action

import com.example.demo.model.Product
import com.example.demo.service.ProductService
import com.example.demo.service.argument.CreateProductArgument
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class CreateProductAction {
    private val productService: ProductService? = null
    fun execute(argument: CreateProductActionArgument): Product? {

        //todo Implement CategoryService. Use categoryService.getExisting(argument.getCategoryId());
        val (id, title, price, category) = productService!!.create(
            CreateProductArgument.Builder()
                .price(argument.price)
                .title(argument.title)
                //                                                        .category() //todo insert category
                .build()
        )
        return null //todo do create
    }
}