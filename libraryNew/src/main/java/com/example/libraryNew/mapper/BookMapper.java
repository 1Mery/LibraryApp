package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.book.CreateBookRequest;
import com.example.libraryNew.dto.request.book.UpdateBookRequest;
import com.example.libraryNew.dto.response.book.*;
import com.example.libraryNew.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    List<GetListBookResponse> toGetListBookResponse(List<Book> bookList);

    Book toBook(CreateBookRequest createBookRequest);

    @Mapping(source = "category.name", target = "categoryName")
    CreatedBookResponse toCreatedBookResponse(Book book);

    Book toBook(UpdateBookRequest updateBookRequest);

    DeletedBookResponse toDeletedBookResponse(Book book);

    @Mapping(source = "category.name", target = "categoryName")
    UpdatedBookResponse toUpdatedBookResponse(Book book);

    @Mapping(source = "category.name", target = "categoryName")
    SearchBookResponse toSearchBookResponse(Book book);

    List<SearchBookResponse> toSearchBookResponse(List<Book> book);

}
