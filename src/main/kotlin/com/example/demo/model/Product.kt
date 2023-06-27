package com.example.demo.model
import com.example.demo.model.Category
import lombok.*
import java.util.*
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor

data class Product(
    @Id  @GeneratedValue val id: UUID?,
    var title: String?,
    var price: Long?,
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category?
)
{


    data class Builder(
        var id: UUID?=null,
        var title: String? = null,
        var price: Long?= null,
        var category: Category? = null) {

        fun id(id: UUID?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun category(category: Category?) = apply { this.category = category }
        fun build() = Product(id, title, price,category)
    }
}
