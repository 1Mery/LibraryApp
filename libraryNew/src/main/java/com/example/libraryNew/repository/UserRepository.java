package com.example.libraryNew.repository;

import com.example.libraryNew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
