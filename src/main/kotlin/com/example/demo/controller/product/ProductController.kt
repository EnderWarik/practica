package com.example.demo.controller.product

import com.example.demo.action.CreateProductAction
import com.example.demo.action.UpdateProductAction
import com.example.demo.controller.dto.CreateProductDto
import com.example.demo.controller.dto.ProductDto
import com.example.demo.controller.dto.SearchProductDto
import com.example.demo.controller.dto.UpdateProductDto
import com.example.demo.controller.mapper.ProductMapper
import com.example.demo.service.product.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
class ProductController(
    private val productService: ProductService,
    private val createProductAction: CreateProductAction,
    private val updateProductAction: UpdateProductAction,
    private val productMapper: ProductMapper
) {
    @GetMapping("list")
    fun list(@RequestParam dto: SearchProductDto?): List<ProductDto> {
        return productService.list(productMapper.productArgument(dto))
            .map { product ->
              productMapper.productDto(product)
            }
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateProductDto): ProductDto? {
        val product = createProductAction.execute(productMapper.createProductActionArgument(dto))
        return productMapper.productDto(product)
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: UUID?, @RequestBody dto: UpdateProductDto?): ProductDto? {
        val updateProduct = updateProductAction.execute(id,productMapper.updateProductActionArgument(dto))
        return productMapper.productDto(updateProduct)
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: UUID?): HttpStatus {
        productService.delete(id)
        return HttpStatus.OK
    }
}