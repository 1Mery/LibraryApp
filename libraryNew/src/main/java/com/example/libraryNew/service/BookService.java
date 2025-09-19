package com.example.libraryNew.service;

import com.example.libraryNew.dto.response.book.BookResponse;
import com.example.libraryNew.entity.Book;
import com.example.libraryNew.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        List<Book> books= bookRepository.findAll();
        List<BookResponse> bookResponse= new ArrayList<>();
        for (Book book: books){
            BookResponse dto = new BookResponse();
            dto.setId(book.getId());
            dto.setAuthor(book.getAuthor());
            dto.setIsbn(book.getIsbn());
            dto.setTitle(book.getTitle());
        }
        return null;
    }
}
