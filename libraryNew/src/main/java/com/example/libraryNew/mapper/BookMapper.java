package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.book.BookRequest;
import com.example.libraryNew.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book createBookRequestToBook(BookRequest bookRequest);
}
