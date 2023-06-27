package com.example.demo.action.argument

import lombok.Builder
import lombok.Value
import java.util.*

@Value
@Builder
class CreateCategoryActionArgument(
    var title: String? = null
)
{
    data class Builder(
        var title: String? = null,
    )
    {
        fun title(title: String?)= apply { this.title = title }
        fun build() = CreateCategoryActionArgument(title)
    }

}