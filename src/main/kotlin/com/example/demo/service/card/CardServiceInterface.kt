package com.example.demo.service.card

import com.example.demo.model.Card
import com.example.demo.model.Product
import com.example.demo.service.card.arguments.CreateCardArgument
import com.example.demo.service.card.arguments.UpdateCardArgument
import com.example.demo.service.product.arguments.CreateProductArgument
import com.example.demo.service.product.arguments.SearchProductArgument
import com.example.demo.service.product.arguments.UpdateProductArgument
import java.util.*


interface CardServiceInterface {
    fun list(): List<Card?>

    fun create(argument: CreateCardArgument): Card

    fun getExisting(id: UUID): Card

    fun update(id: UUID, argument: UpdateCardArgument): Card

     fun delete(id: UUID)
}