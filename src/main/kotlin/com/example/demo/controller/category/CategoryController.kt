package com.example.demo.controller.category

import com.example.demo.controller.category.dto.CategoryDto
import com.example.demo.controller.category.dto.CreateCategoryDto
import com.example.demo.controller.category.dto.UpdateCategoryDto
import com.example.demo.controller.category.mapper.CategoryMapper
import com.example.demo.controller.dto.*
import com.example.demo.service.category.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


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