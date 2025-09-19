package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.category.CreateCategoryRequest;
import com.example.libraryNew.dto.request.category.UpdateCategoryRequest;
import com.example.libraryNew.dto.response.category.CreatedCategoryResponse;
import com.example.libraryNew.dto.response.category.DeletedCategoryResponse;
import com.example.libraryNew.dto.response.category.GetByIdCategoryResponse;
import com.example.libraryNew.dto.response.category.GetListCategoryResponse;
import com.example.libraryNew.dto.response.category.UpdatedCategoryResponse;
import com.example.libraryNew.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-19T16:56:34+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<GetListCategoryResponse> toGetListCategoryResponse(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<GetListCategoryResponse> list = new ArrayList<GetListCategoryResponse>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( categoryToGetListCategoryResponse( category ) );
        }

        return list;
    }

    @Override
    public GetByIdCategoryResponse toGetByIdCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        GetByIdCategoryResponse getByIdCategoryResponse = new GetByIdCategoryResponse();

        getByIdCategoryResponse.setName( category.getName() );
        getByIdCategoryResponse.setId( category.getId() );

        return getByIdCategoryResponse;
    }

    @Override
    public Category toCategory(CreateCategoryRequest createCategoryRequest) {
        if ( createCategoryRequest == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( createCategoryRequest.getName() );

        return category;
    }

    @Override
    public CreatedCategoryResponse toCreatedCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CreatedCategoryResponse createdCategoryResponse = new CreatedCategoryResponse();

        createdCategoryResponse.setId( category.getId() );
        createdCategoryResponse.setName( category.getName() );

        return createdCategoryResponse;
    }

    @Override
    public Category toCategory(UpdateCategoryRequest updateCategoryRequest) {
        if ( updateCategoryRequest == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( updateCategoryRequest.getId() );
        category.setName( updateCategoryRequest.getName() );

        return category;
    }

    @Override
    public DeletedCategoryResponse toDeletedCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        DeletedCategoryResponse deletedCategoryResponse = new DeletedCategoryResponse();

        deletedCategoryResponse.setId( category.getId() );
        deletedCategoryResponse.setName( category.getName() );

        return deletedCategoryResponse;
    }

    @Override
    public UpdatedCategoryResponse toUpdatedCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        UpdatedCategoryResponse updatedCategoryResponse = new UpdatedCategoryResponse();

        updatedCategoryResponse.setId( category.getId() );
        updatedCategoryResponse.setName( category.getName() );

        return updatedCategoryResponse;
    }

    protected GetListCategoryResponse categoryToGetListCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        GetListCategoryResponse getListCategoryResponse = new GetListCategoryResponse();

        getListCategoryResponse.setId( category.getId() );
        getListCategoryResponse.setName( category.getName() );

        return getListCategoryResponse;
    }
}
