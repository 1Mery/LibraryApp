package com.example.libraryNew.service;

import com.example.libraryNew.dto.request.book.CreateBookRequest;
import com.example.libraryNew.dto.request.book.UpdateBookRequest;
import com.example.libraryNew.dto.response.book.*;
import com.example.libraryNew.entity.Book;
import com.example.libraryNew.mapper.BookMapper;
import com.example.libraryNew.repository.BookRepository;
import com.example.libraryNew.rules.BookBusinessRule;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookBusinessRule bookBusinessRule;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookBusinessRule bookBusinessRule, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookBusinessRule = bookBusinessRule;
        this.bookMapper = bookMapper;
    }

    public List<GetListBookResponse> getAllBook(String title) {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toGetListBookResponse(books);
    }

    public CreatedBookResponse addBook(CreateBookRequest createBookRequest) {
        bookBusinessRule.bookShouldNotWithExistSameTitle(createBookRequest.getTitle());
        bookBusinessRule.isbnMustBeUnique(createBookRequest.getIsbn());

        Book book = bookMapper.toBook(createBookRequest);
        book = bookRepository.save(book);

        return bookMapper.toCreatedBookResponse(book);
    }

    public UpdatedBookResponse updateBook(UpdateBookRequest updateBookRequest){
        bookBusinessRule.bookShouldNotWithExistSameTitle(updateBookRequest.getTitle());
        bookBusinessRule.isbnMustBeUnique(updateBookRequest.getIsbn());

        Book book= bookMapper.toBook(updateBookRequest);
        book=bookRepository.save(book);

        return bookMapper.toUpdatedBookResponse(book);
    }

    public DeletedBookResponse deleteBook(int id){
        Book book=bookBusinessRule.bookShouldExistWithGivenId(id);
        bookRepository.delete(book);

        return bookMapper.toDeletedBookResponse(book);
    }

    public List<SearchBookResponse> searchCategory(String categoryName){
        bookBusinessRule.categoryNameShouldExist(categoryName);

        List<Book> books= bookRepository.findByCategory_Name(categoryName);

        return bookMapper.toSearchBookResponse(books);
    }

}
