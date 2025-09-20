package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.book.CreateBookRequest;
import com.example.libraryNew.dto.request.book.UpdateBookRequest;
import com.example.libraryNew.dto.response.book.*;
import com.example.libraryNew.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    List<GetListBookResponse> toGetListBookResponse(List<Book> bookList);

    Book toBook(CreateBookRequest createBookRequest);

    CreatedBookResponse toCreatedBookResponse(Book book);

    Book toBook(UpdateBookRequest updateBookRequest);

    DeletedBookResponse toDeletedBookResponse(Book book);

    UpdatedBookResponse toUpdatedBookResponse(Book book);

    List<SearchBookResponse> toSearchBookResponse(List<Book> book);

}
