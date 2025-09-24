package com.example.libraryNew.dto.response.admin;

import com.example.libraryNew.enums.AdminRole;

public class GetByIdListAdminResponse {

    private int id;
    private String name;
    private String email;
    private AdminRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminRole getRole() {
        return role;
    }

    public void setRole(AdminRole role) {
        this.role = role;
    }
}
