package com.example.demo.controller.card

import com.example.demo.controller.card.dto.CardDto
import com.example.demo.controller.card.dto.CreateCardDto
import com.example.demo.controller.card.dto.UpdateCardDto
import com.example.demo.controller.card.mapper.CardMapper
import com.example.demo.controller.category.dto.CategoryDto
import com.example.demo.controller.category.dto.CreateCategoryDto
import com.example.demo.controller.category.dto.UpdateCategoryDto
import com.example.demo.controller.category.mapper.CategoryMapper
import com.example.demo.service.card.CardService
import com.example.demo.service.category.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequiredArgsConstructor
@RequestMapping("card")
class CardController(
    private val cardService: CardService,
    val cardMapper: CardMapper
) {
    @GetMapping("list")
    fun list(): List<CardDto> {
        return cardService.list()
            .map { category ->
                cardMapper.cardDto(category)
            }
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateCardDto): CardDto {
        val card =  cardService.create( cardMapper.createCardArgument(dto))
        return  cardMapper.cardDto(card)
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: UUID, @RequestBody dto: UpdateCardDto): CardDto? {
        val updateProduct = cardService.update(id,cardMapper.updateCardArgument(dto))
        return cardMapper.cardDto(updateProduct)
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: UUID): HttpStatus {
        cardService.delete(id)
        return HttpStatus.OK
    }
}