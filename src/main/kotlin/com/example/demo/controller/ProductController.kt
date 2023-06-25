package com.example.demo.controller

import com.example.demo.controller.dto.CreateProductDto
import com.example.demo.controller.dto.ProductDto
import com.example.demo.controller.dto.UpdateProductDto
import com.example.demo.model.Product
import com.example.demo.service.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateProductArgument

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
class ProductController(
    private val productService: ProductService,

) {
    @GetMapping("list")
    fun list(): List<ProductDto> {
        return productService.list().stream()
            .map { product ->
                ProductDto.Builder()
                    .id(product.id)
                    .title(product.title)
                    .price(product.price)
                    .build()
            }
            .collect(Collectors.toList())
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateProductDto): ProductDto? {
        val product: Product = productService.create(
            CreateProductArgument.Builder()
                .price(dto.price)
                .title(dto.title)
                .build()
        )
        return ProductDto.Builder()
            .id(product.id)
            .title(product.title)
            .price(product.price)
            .build()
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: Long?, @RequestBody dto: UpdateProductDto?): ProductDto? {
        val updatedProduct = productService.update(
            id,
            UpdateProductArgument.Builder()
                .title(dto?.title)
                .price(dto?.price)
                .build()
        )

        return ProductDto.Builder()
            .id(updatedProduct.id)
            .title(updatedProduct.title)
            .price(updatedProduct.price)
            .build()
    }
}