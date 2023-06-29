package com.example.demo.controller

import com.example.demo.controller.dto.*
import com.example.demo.controller.mapper.CategoryMapper
import com.example.demo.service.argument.CreateCategoryArgument
import com.example.demo.service.argument.UpdateCategoryArgument
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
    val categoryMapper: CategoryMapper
) {
    @GetMapping("list")
    fun list(): List<CategoryDto> {
        return categoryService.list()
            .map { category ->
                categoryMapper.categoryDto(category)
            }
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateCategoryDto): CategoryDto? {
        val category =  categoryService.create( categoryMapper.createCategoryArgument(dto))
        return  categoryMapper.categoryDto(category)
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: UUID, @RequestBody dto: UpdateCategoryDto?): CategoryDto? {
        val updateProduct = categoryService.update(id,categoryMapper.updateCategoryArgument(dto))
        return categoryMapper.categoryDto(updateProduct)
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: UUID?): HttpStatus {
        categoryService.delete(id)
        return HttpStatus.OK
    }
}