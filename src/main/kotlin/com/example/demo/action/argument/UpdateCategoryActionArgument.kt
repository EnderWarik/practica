package com.example.demo.action.argument

import lombok.Builder
import lombok.Value
import java.util.*

@Value
@Builder
class UpdateCategoryActionArgument
    (   var title: String? = null
    )
{

    data class Builder(
        var title: String? = null,
      )
    {
        fun title(title: String?)= apply { this.title = title }
        fun build() = UpdateCategoryActionArgument(title)
    }

}