package com.example.libraryNew.service;

import com.example.libraryNew.dto.request.admin.CreateAdminRequest;
import com.example.libraryNew.dto.request.admin.UpdateAdminRequest;
import com.example.libraryNew.dto.response.admin.*;
import com.example.libraryNew.rules.AdminBusinessRule;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminBusinessRule adminBusinessRule;

    public AdminService(AdminBusinessRule adminBusinessRule) {
        this.adminBusinessRule = adminBusinessRule;
    }

    public List<GetByIdListAdminResponse> getByIdListAdmin(){

    }

    public List<GetListAdminResponse> getListAdmin(){

    }

    public CreatedAdminResponse createAdmin(@Valid CreateAdminRequest createAdminRequest){

    }

    public UpdatedAdminResponse updateAdmin(@Valid UpdateAdminRequest updateAdminRequest){

    }

    public DeletedAdminResponse deleteAdmin(int id){

    }

    
}
