package com.example.libraryNew.repository;

import com.example.libraryNew.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
