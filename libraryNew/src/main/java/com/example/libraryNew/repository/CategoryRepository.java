package com.example.libraryNew.repository;

import com.example.libraryNew.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findTop1ByNameIgnoreCase(String name);
    List<Category> findByName(String name);
}
