package com.example.demo.service.category.arguments

public class CreateCategoryArgument (
    var title: String?
)
{
    data class Builder(
        var title: String? = null,

    )
    {
        fun title(title: String?) = apply { this.title = title }

        fun build() = CreateCategoryArgument(title)
    }
}