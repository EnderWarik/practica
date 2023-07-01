package com.example.demo.controller.product.mapper

import com.example.demo.action.product.argument.CreateProductActionArgument
import com.example.demo.action.product.argument.UpdateProductActionArgument
import com.example.demo.controller.product.dto.CreateProductDto
import com.example.demo.controller.product.dto.ProductDto
import com.example.demo.controller.product.dto.SearchProductDto
import com.example.demo.controller.product.dto.UpdateProductDto
import com.example.demo.model.Product
import com.example.demo.service.product.arguments.SearchProductArgument
import org.springframework.stereotype.Component

@Component
class ProductMapper {

    fun productArgument(dto: SearchProductDto?) : SearchProductArgument
    {
        return  SearchProductArgument.Builder()
            .productTitle(dto?.productTitle)
            .categoryTitle(dto?.categoryTitle)
            .build()
    }

    fun productDto(product: Product) : ProductDto
    {
        return ProductDto.Builder()
            .id(product.id)
            .title(product.title)
            .price(product.price)
            .category(product.category)
            .build()
    }

    fun createProductActionArgument(dto: CreateProductDto) : CreateProductActionArgument
    {
       return CreateProductActionArgument
            .Builder()
            .title(dto.title)
            .price(dto.price)
            .categoryId(dto.categoryId)
            .cardId(dto.cardId)
            .build()
    }

    fun updateProductActionArgument(dto: UpdateProductDto?) : UpdateProductActionArgument
    {
        return UpdateProductActionArgument
            .Builder()
            .title(dto?.title)
            .price(dto?.price)
            .categoryId(dto?.categoryId)
            .cardId(dto?.cardId)
            .build()
    }
}