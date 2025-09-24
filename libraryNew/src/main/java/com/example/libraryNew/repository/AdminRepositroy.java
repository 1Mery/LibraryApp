package com.example.libraryNew.repository;

import com.example.libraryNew.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepositroy extends JpaRepository<Admin,Integer> {

    Optional<Admin> findByEmail(String email);

}
