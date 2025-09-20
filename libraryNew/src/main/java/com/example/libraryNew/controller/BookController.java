package com.example.libraryNew.controller;

import com.example.libraryNew.dto.request.book.CreateBookRequest;
import com.example.libraryNew.dto.request.book.UpdateBookRequest;
import com.example.libraryNew.dto.response.book.*;
import com.example.libraryNew.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/title")
    public List<GetListBookResponse> getAllBook(@RequestBody String title){
        return bookService.getAllBook(title);
    }

    @PostMapping
    public CreatedBookResponse addBook(CreateBookRequest createBookRequest){
        return bookService.addBook(createBookRequest);
    }

    @PutMapping("/update")
    public UpdatedBookResponse updateBook(UpdateBookRequest updateBookRequest){
        return bookService.updateBook(updateBookRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedBookResponse deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }

    @GetMapping("/{categoryName}")
    public List<SearchBookResponse> searchCategory(@PathVariable String categoryName){
        return bookService.searchCategory(categoryName);
    }
}
