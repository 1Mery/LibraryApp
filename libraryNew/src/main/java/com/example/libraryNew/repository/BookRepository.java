package com.example.libraryNew.repository;

import com.example.libraryNew.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findTop1ByTitleIgnoreCase (String title);
    Optional<Book> findByIsbn(Long isbn);
    List<Book> findByCategory_Name(String categoryName);
    boolean existsByCategory_Name(String categoryName);


}
