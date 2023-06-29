package com.example.demo.service.implementation

import com.example.demo.model.Category
import com.example.demo.repository.CategoryRepository
import com.example.demo.service.argument.CreateCategoryArgument
import com.example.demo.service.argument.UpdateCategoryArgument
import com.example.demo.service.serviceInterfaces.CategoryServiceInterface
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class CategoryService(
    private val repository: CategoryRepository
): CategoryServiceInterface
{
    override fun list(): List<Category> {
        return repository.findAll();
    }

    override fun create(argument: CreateCategoryArgument): Category {
        return repository.save( Category.Builder()
            .title(argument.title)
            .build())
    }


    override fun getExisting(id: UUID): Category {
        return repository.findById(id).orElseThrow { RuntimeException("Категория не найдена") }
    }

    override fun update(id: UUID, argument: UpdateCategoryArgument): Category {
        val category = getExisting(id)

        println(id)
        category.title = argument.title
        return repository.save( category)



    }

    override fun delete(id: UUID?) {
        val category = id?.let { getExisting(it) };

        if(category != null){
            return repository.delete(category)
        }
        else
        {
            throw RuntimeException()
        }

    }

}