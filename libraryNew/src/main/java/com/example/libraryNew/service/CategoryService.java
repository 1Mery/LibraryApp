package com.example.libraryNew.service;

import com.example.libraryNew.dto.request.category.CreateCategoryRequest;
import com.example.libraryNew.dto.request.category.UpdateCategoryRequest;
import com.example.libraryNew.dto.response.category.*;
import com.example.libraryNew.entity.Category;
import com.example.libraryNew.mapper.CategoryMapper;
import com.example.libraryNew.repository.CategoryRepository;
import com.example.libraryNew.rules.CategoryBusinessRule;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRule categoryBusinessRule;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryBusinessRule categoryBusinessRule, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRule = categoryBusinessRule;
        this.categoryMapper= categoryMapper;
    }

    //tüm kategorileri alabilir hem de isimle filtreleme
    public List<GetListCategoryResponse> getList(String name){
        List<Category> categories;
        if(name == null || name.isEmpty()){
            categories = categoryRepository.findAll();
        } else {
            categories = categoryRepository.findByName(name);
        }
        return categoryMapper.toGetListCategoryResponse(categories);
    }

    public GetByIdCategoryResponse getById(int id){
        Category category = categoryBusinessRule.categoryShouldExistWithGivenId(id);

        return categoryMapper.toGetByIdCategoryResponse(category);
    }
    public CreatedCategoryResponse add(@Valid CreateCategoryRequest createCategoryRequest){
        categoryBusinessRule.categoryShouldNotExistWithSameName(createCategoryRequest.getName());

        Category category= categoryMapper.toCategory(createCategoryRequest);
        category = categoryRepository.save(category);

        return categoryMapper.toCreatedCategoryResponse(category);

    }

    public UpdatedCategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest){
        categoryBusinessRule.categoryShouldNotExistWithSameName(updateCategoryRequest.getName());

        Category category= categoryMapper.toCategory(updateCategoryRequest);
        category= categoryRepository.save(category);

        return categoryMapper.toUpdatedCategoryResponse(category);

    }

    public DeletedCategoryResponse deletedCategory(int id){
        Category category= categoryBusinessRule.categoryShouldExistWithGivenId(id);
        categoryRepository.delete(category);

        return categoryMapper.toDeletedCategoryResponse(category);


    }
}
