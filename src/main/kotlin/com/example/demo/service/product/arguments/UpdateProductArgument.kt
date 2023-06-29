package com.example.demo.service.product.arguments

import com.example.demo.model.Category
import lombok.Builder

@Builder
class UpdateProductArgument (
    var title: String?,
    var price: Long?,
    var category: Category?
)
{
    data class Builder(
        var title: String? = null,
        var price: Long? = null,
        var category: Category? = null) {


        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun category(category: Category?) = apply { this.category = category }
        fun build() = UpdateProductArgument(title, price, category)
    }
}