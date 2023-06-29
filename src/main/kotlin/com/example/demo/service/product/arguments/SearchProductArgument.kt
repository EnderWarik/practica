package com.example.demo.service.product.arguments

public class SearchProductArgument (
    var productTitle: String? = null,
    var categoryTitle: String? = null
)
{
    data class Builder(
        var productTitle: String? = null,
        var categoryTitle: String? = null
    )
    {

        fun productTitle(productTitle: String?) = apply { this.productTitle = productTitle }
        fun categoryTitle(categoryTitle: String?) = apply { this.categoryTitle = categoryTitle }
        fun build() = SearchProductArgument(productTitle, categoryTitle)
    }
}