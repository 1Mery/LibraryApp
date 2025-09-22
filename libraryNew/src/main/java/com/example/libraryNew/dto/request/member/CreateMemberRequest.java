package com.example.libraryNew.dto.request.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class CreateMemberRequest {
    private String name;
    @Email
    private String email;
    private String password;
    @Pattern(regexp = "\\+90\\d{10}", message = "Phone number must be in +90XXXXXXXXXX format")
    private int tel;

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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
