package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.category.CreateCategoryRequest;
import com.example.libraryNew.dto.request.category.UpdateCategoryRequest;
import com.example.libraryNew.dto.response.category.*;
import com.example.libraryNew.entity.Category;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    List<GetListCategoryResponse> toGetListCategoryResponse(List<Category> categoryList);

    GetByIdCategoryResponse toGetByIdCategoryResponse(Category category);

    Category toCategory(CreateCategoryRequest createCategoryRequest);

    CreatedCategoryResponse toCreatedCategoryResponse( Category category);

    //@Mapping(target = "id",ignore = true) bu id deki elemanı görmezden gelir
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);

    DeletedCategoryResponse toDeletedCategoryResponse(Category category);

    UpdatedCategoryResponse toUpdatedCategoryResponse(Category category);

}
