package com.example.demo.service.implementation

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import com.example.demo.service.serviceInterfaces.ProductServiceInterface
import org.springframework.stereotype.Service
import com.example.demo.service.argument.CreateProductArgument
import com.example.demo.service.argument.UpdateProductArgument
import lombok.RequiredArgsConstructor
import java.lang.RuntimeException
import java.util.*



@Service
@RequiredArgsConstructor
class ProductService(
    private val repository: ProductRepository
): ProductServiceInterface
{
    override fun list(): List<Product> {
        return repository.findAll();
    }

    override fun create(argument: CreateProductArgument): Product {
        return repository.save( Product.Builder()
            .title(argument.title)
            .price(argument.price)
            .category(argument.category)
            .build())
    }


    override fun getExisting(id: UUID): Product? {
        return repository.findById(id).orElse(null)
    }

    override fun update(id: UUID?, argument: UpdateProductArgument): Product {
       val product = id?.let { getExisting(it) };

        if(product != null){
            product.price = argument.price
            product.title = argument.title
            product.category = argument.category
            return repository.save( product)
        }
        else
        {
            throw RuntimeException()
        }

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