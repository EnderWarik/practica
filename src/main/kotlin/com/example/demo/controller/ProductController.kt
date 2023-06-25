package com.example.demo.controller

import com.example.demo.controller.dto.ProductDto
import com.example.demo.model.Product
import com.example.demo.service.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors


@Controller
@RequiredArgsConstructor
@RequestMapping("product")
class ProductController(
    private val productService: ProductService,

) {
    @GetMapping("list")
    fun list(): List<ProductDto?> {
        return productService.list().stream()
            .map { product ->
                product?.let {
                    ProductDto.Builder()
                        .id(it.id)
                        .title(it.title)
                        .price(it.price)
                        .build()
                }
            }
            .collect(Collectors.toList())
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateProductDto): ProductDto? {
        val product: Product = productService.create(
            CreateProductArgument.builder()
                .price(dto.getPrice())
                .title(dto.getTitle())
                .build()
        )
        return ProductDto.Builder()
            .id(product.getId())
            .title(product.getTitle())
            .price(product.getPrice())
            .build()
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: Long?, @RequestBody dto: UpdateProductDto?): ProductDto? {
        return null
    }
}