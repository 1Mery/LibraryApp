package com.example.libraryNew.rules;

import com.example.libraryNew.core.exception.type.BusinessException;
import com.example.libraryNew.repository.AdminRepositroy;

public class AdminBusinessRule {

    private final AdminRepositroy adminRepositroy;

    public AdminBusinessRule(AdminRepositroy adminRepositroy) {
        this.adminRepositroy = adminRepositroy;
    }

    public void adminShouldExistWithGivenId(int id){
        adminRepositroy.findById(id);
        if(adminRepositroy.findById(id).isPresent()){
            throw new BusinessException("Admin with" + id + "not found");
        }
    }

    public void adminShouldExistWithGivenEmail(String email){
        adminRepositroy.findByEmail(email);
        if(adminRepositroy.findByEmail(email).isPresent()){
            throw new BusinessException("Admin with" + email + "not found");
        }
    }


}
