package com.example.demo.controller.dto

import com.example.demo.model.Category
import java.util.UUID


class CategoryDto(
    val id: UUID?,
    val title: String?,
   ) {

    data class Builder(
        var id: UUID?=null,
        var title: String? = null
       ) {

        fun id(id: UUID?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun build() = CategoryDto(id, title)
    }
}