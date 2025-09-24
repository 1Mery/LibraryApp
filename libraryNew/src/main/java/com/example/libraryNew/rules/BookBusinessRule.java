package com.example.libraryNew.rules;

import com.example.libraryNew.core.exception.type.BusinessException;
import com.example.libraryNew.entity.Book;
import com.example.libraryNew.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookBusinessRule {
    private final BookRepository bookRepository;

    public BookBusinessRule(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book bookShouldExistWithGivenId(int id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Book with" + id + "not found"));
    }

    public void bookShouldNotWithExistSameTitle(String title) {
        Book book = bookRepository.findTop1ByTitleIgnoreCase(title)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (book != null) {
            throw new BusinessException("Book with name" + title + "already exists");
        }
    }

    public void isbnMustBeUnique(Long isbn) {
        boolean exists = bookRepository.findByIsbn(isbn).isPresent();
        if (exists) {
            throw new BusinessException("Isbn must be unique.this isbn" + isbn + "already exist.");
        }
    }

    public void totalCopiesShouldNotNegative(int totalCopies, int availableCopies) {

        if (totalCopies < 0) {
            throw new BusinessException("Total copies can not negative");
        }

        if (availableCopies > totalCopies) {
            throw new BusinessException("Available copies can not bigger than total copies.");
        }
    }

    public void categoryNameShouldExist(String categoryName) {
        boolean exists =bookRepository.existsByCategory_Name(categoryName);
        if (!exists){
            throw new BusinessException("This category name is not available.");
        }
    }
}