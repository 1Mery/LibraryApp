package com.example.libraryNew.controller;

import com.example.libraryNew.dto.request.category.CreateCategoryRequest;
import com.example.libraryNew.dto.request.category.UpdateCategoryRequest;
import com.example.libraryNew.dto.response.category.*;
import com.example.libraryNew.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<GetListCategoryResponse> getList(){
        return categoryService.getList();
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping
    public CreatedCategoryResponse add(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        return categoryService.add(createCategoryRequest);
    }

    @PutMapping("/update")
    public UpdatedCategoryResponse updateCategory(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        return categoryService.updateCategory(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedCategoryResponse deletedCategory(@PathVariable int id){
        return categoryService.deletedCategory(id);
    }
}
