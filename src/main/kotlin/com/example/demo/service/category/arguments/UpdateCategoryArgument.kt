package com.example.demo.service.category.arguments

public class UpdateCategoryArgument (
    var title: String?
)
{
    data class Builder(
        var title: String? = null,

    )
    {
        fun title(title: String?) = apply { this.title = title }
        fun build() = UpdateCategoryArgument(title)
    }
}