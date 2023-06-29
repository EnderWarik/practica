package com.example.demo.controller.dto

import com.example.demo.model.Category
import java.util.UUID


class CreateCategoryDto(
    val title: String?
) {

    data class Builder(
        var title: String? = null
    ) {

        fun title(title: String?) = apply { this.title = title }
        fun build() = CreateCategoryDto(title)
    }
}