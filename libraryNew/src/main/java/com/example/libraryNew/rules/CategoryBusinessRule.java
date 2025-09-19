package com.example.libraryNew.rules;

import com.example.libraryNew.core.exceptions.type.BusinessException;
import com.example.libraryNew.entity.Category;
import com.example.libraryNew.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRule {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRule(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category categoryShouldExistWithGivenId(int id){
        return categoryRepository
                .findById(id)
                .orElseThrow(()-> new BusinessException("Category with"+ id +"not found"));
    }

    public void categoryShouldNotExistWithSameName(String name){
        Category category= categoryRepository.findTop1ByNameIgnoreCase(name).orElseThrow(null);
        if (category!=null){
            throw new BusinessException("Category with name"+ name+ "already exists");
        }
    }
}
