package com.example.demo.service.argument

import com.example.demo.model.Product

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