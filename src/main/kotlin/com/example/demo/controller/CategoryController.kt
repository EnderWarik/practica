package com.example.demo.controller

import com.example.demo.action.CreateCategoryAction
import com.example.demo.action.CreateProductAction
import com.example.demo.action.UpdateCategoryAction
import com.example.demo.action.UpdateProductAction
import com.example.demo.action.argument.CreateCategoryActionArgument
import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.action.argument.UpdateCategoryActionArgument
import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.controller.dto.CategoryDto
import com.example.demo.controller.dto.CreateProductDto
import com.example.demo.controller.dto.ProductDto
import com.example.demo.controller.dto.UpdateProductDto
import com.example.demo.service.implementation.ProductService
import com.example.demo.service.argument.UpdateProductArgument
import com.example.demo.service.implementation.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors


@RestController
@RequiredArgsConstructor
@RequestMapping("category")
class CategoryController(
    private val categoryService: CategoryService,
    private val createCategoryAction: CreateCategoryAction,
    private val updateCategoryAction: UpdateCategoryAction,
) {
    @GetMapping("list")
    fun list(): List<CategoryDto> {
        return categoryService.list().stream()
            .map { category ->
                CategoryDto.Builder()
                    .id(category.id)
                    .title(category.title)
                    .build()
            }
            .collect(Collectors.toList())
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateProductDto): CategoryDto? {
        val category = createCategoryAction.execute(
            CreateCategoryActionArgument
            .Builder()
            .title(dto.title)
            .build())

        return CategoryDto.Builder()
            .id(category.id)
            .title(category.title)
            .build()
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: UUID?, @RequestBody dto: UpdateProductDto?): CategoryDto? {
        val updateProduct = updateCategoryAction.execute(id,
            UpdateCategoryActionArgument
            .Builder()
            .title(dto?.title)
            .build())

        return CategoryDto.Builder()
            .id(updateProduct.id)
            .title(updateProduct.title)
            .build()
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: UUID?): HttpStatus {
        categoryService.delete(id)
        return HttpStatus.OK
    }
}