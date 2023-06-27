package com.example.demo.repository

import com.example.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

public interface ProductRepository: JpaRepository<Product, UUID> {

}