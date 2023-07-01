package com.example.demo.controller.card.mapper

import com.example.demo.controller.card.dto.CardDto
import com.example.demo.controller.card.dto.CreateCardDto
import com.example.demo.controller.card.dto.UpdateCardDto
import com.example.demo.controller.category.dto.CategoryDto
import com.example.demo.controller.category.dto.CreateCategoryDto
import com.example.demo.controller.category.dto.UpdateCategoryDto
import com.example.demo.model.Card
import com.example.demo.model.Category
import com.example.demo.service.card.arguments.CreateCardArgument
import com.example.demo.service.card.arguments.UpdateCardArgument
import com.example.demo.service.category.arguments.CreateCategoryArgument
import com.example.demo.service.category.arguments.UpdateCategoryArgument
import org.springframework.stereotype.Component

@Component
class CardMapper {


    fun cardDto(card: Card) : CardDto
    {
        return CardDto.Builder()
            .id(card.id)
            .products(card.products)
            .build()
    }

    fun createCardArgument(dto: CreateCardDto) : CreateCardArgument
    {
       return  CreateCardArgument.Builder()
           .products(dto.products)
           .build()
    }

    fun updateCardArgument(dto: UpdateCardDto) : UpdateCardArgument
    {
        return  UpdateCardArgument
            .Builder()
            .products(dto.products)
            .build()
    }
}