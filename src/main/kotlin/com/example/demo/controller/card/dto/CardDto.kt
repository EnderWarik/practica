package com.example.demo.controller.card.dto
import com.example.demo.model.Product
import lombok.*
import java.util.*
import javax.persistence.*


@Entity
@AllArgsConstructor
@NoArgsConstructor
data class CardDto(
    @Id  @GeneratedValue var id: UUID?,
    @OneToMany var products:List<Product>?
)
{

    data class Builder(
        var id: UUID?=null,
        var products: List<Product>? = null) {

        fun id(id: UUID?)= apply { this.id = id }

        fun products(products: List<Product>?) = apply { this.products = products }

        fun build() = CardDto(id, products)
    }




}