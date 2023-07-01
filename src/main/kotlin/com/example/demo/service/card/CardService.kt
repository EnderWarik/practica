package com.example.demo.service.card

import com.example.demo.model.Card
import com.example.demo.model.Product
import com.example.demo.repository.CardRepository
import com.example.demo.repository.ProductRepository
import com.example.demo.service.card.arguments.CreateCardArgument
import com.example.demo.service.card.arguments.UpdateCardArgument
import org.springframework.stereotype.Service
import com.example.demo.service.product.arguments.CreateProductArgument
import com.example.demo.service.product.arguments.SearchProductArgument
import com.example.demo.service.product.arguments.UpdateProductArgument
import lombok.RequiredArgsConstructor
import java.lang.RuntimeException
import java.util.*


@Service
@RequiredArgsConstructor
class CardService(
    private val repository: CardRepository
): CardServiceInterface
{
    override fun list(): List<Card> {
        return repository.findAll()
    }

    override fun create(argument: CreateCardArgument): Card {
        return repository.save(Card.Builder()
            .products(argument.products)
            .build())
    }


    override fun getExisting(id: UUID): Card {
        return repository.findById(id).orElseThrow { RuntimeException("Категория не найдена") }
    }

    override fun update(id: UUID, argument: UpdateCardArgument): Card {
       val card = getExisting(id)
        card.products = argument.products
        return repository.save( card)
    }

    override fun delete(id: UUID) {
        val card = getExisting(id)
        return repository.delete(card)
    }

}