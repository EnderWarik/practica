package com.example.demo.model

import lombok.*

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product(
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    var title: String?,
    var price: Long?) {


    data class Builder(
        var id: Long?=null,
        var title: String? = null,
        var price: Long?= null) {

        fun id(id: Long?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun build() = Product(id, title, price)
    }
}
