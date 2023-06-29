package com.example.demo.service.product

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service
import com.example.demo.service.product.arguments.CreateProductArgument
import com.example.demo.service.product.arguments.SearchProductArgument
import com.example.demo.service.product.arguments.UpdateProductArgument
import lombok.RequiredArgsConstructor
import java.lang.RuntimeException
import java.util.*


@Service
@RequiredArgsConstructor
class ProductService(
    private val repository: ProductRepository
): ProductServiceInterface
{
    override fun list(argument: SearchProductArgument): List<Product> {
        return repository.findAll()
            .filter { product ->
                if(argument.productTitle != null && argument.categoryTitle != null)
                    product.title.equals(argument.productTitle)
                        .and(product.title.equals(argument.productTitle))
                else product.title.equals(argument.productTitle)
                        .or(product.title.equals(argument.productTitle))
            }

    }

    override fun create(argument: CreateProductArgument): Product {

        return repository.save( Product.Builder()
            .title(argument.title)
            .price(argument.price)
            .category(argument.category)
            .build())
    }


    override fun getExisting(id: UUID): Product {
        return repository.findById(id).orElseThrow { RuntimeException("Категория не найдена") }
    }

    override fun update(id: UUID, argument: UpdateProductArgument): Product {
       val product = getExisting(id)
        product.price = argument.price
        product.title = argument.title
        product.category = argument.category
        return repository.save( product)
    }

    override fun delete(id: UUID?) {
        val product = id?.let { getExisting(it) };

        if(product != null){
            return repository.delete(product)
        }
        else
        {
            throw RuntimeException()
        }

    }

}