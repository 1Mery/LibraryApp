package com.example.libraryNew.controller;

import com.example.libraryNew.entity.Admin;
import com.example.libraryNew.repository.AdminRepositroy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

private final AdminRepositroy adminRepositroy;

    public AdminController(AdminRepositroy adminRepositroy){
        this.adminRepositroy= adminRepositroy;
    }

    @GetMapping()
    public List<Admin> getAdmin(){
        return adminRepositroy.findAll();
    }


}
