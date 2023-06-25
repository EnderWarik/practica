package com.example.demo.model

import com.example.demo.controller.dto.ProductDto
import lombok.*

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     var id: Long,
     var title: String,
     var price: Long
){
    data class Builder(
        var id: Long,
        var title: String,
        var price: Long) {

        fun id(id: Long)= apply { this.id = id }
        fun title(title: String) = apply { this.title = title }
        fun price(price: Long) = apply { this.price = price }
        fun build() = Product(id, title, price)
    }
}
