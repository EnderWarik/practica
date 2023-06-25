package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repository: ProductRepository
): ProductServiceInterface
{
    override fun list(): List<Product> {
        return repository.findAll();
    }

    override fun create(argument: CreateProductArgument?): Product{
        return repository.save(Product.Builder()
            .title(argument.getTitle())
            .price(argument.getPrice())
            .build());
    }

    override fun getExisting(id: Long): Product {
        return repository.findById(id) ?: throw RuntimeException()
    }

    override fun update(id: Long?, argument: UpdateProductArgument?): Product {

    }
}