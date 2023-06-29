package com.example.demo.controller.mapper

import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.controller.dto.CreateProductDto
import com.example.demo.controller.dto.ProductDto
import com.example.demo.controller.dto.SearchProductDto
import com.example.demo.controller.dto.UpdateProductDto
import com.example.demo.model.Product
import com.example.demo.service.argument.SearchProductArgument
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
            .build()
    }

    fun updateProductActionArgument(dto: UpdateProductDto?) : UpdateProductActionArgument
    {
        return UpdateProductActionArgument
            .Builder()
            .title(dto?.title)
            .price(dto?.price)
            .categoryId(dto?.categoryId)
            .build()
    }
}