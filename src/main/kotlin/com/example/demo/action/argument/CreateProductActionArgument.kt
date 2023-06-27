package com.example.demo.action.argument

import lombok.Builder
import lombok.Value
import java.util.*

@Value
@Builder
class CreateProductActionArgument
    (   var title: String? = null,
        var price: Long? = null,
        var categoryId: UUID? = null
)
{

    data class Builder(

        var title: String? = null,
        var price: Long? = null,
        var categoryId: UUID? = null)
    {

        fun title(title: String?)= apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun categoryId(categoryId: UUID?) = apply { this.categoryId = categoryId }

        fun build() = CreateProductActionArgument(title, price, categoryId)
    }

}