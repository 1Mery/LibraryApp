package com.example.libraryNew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Invalid password")
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "admin_id",nullable = false)
    private Admin admin;

    @ManyToMany(fetch = FetchType.EAGER) // Bir kullanıcıyı çekerken rollerinin de hemen yüklenmesini sağlar.
    @JoinTable(
            name = "user_operation_claims", // Veritabanında oluşturulacak ara tablonun adı.
            joinColumns = @JoinColumn(name = "user_id"), // Bu ara tabloda User'ı temsil eden kolon.
            inverseJoinColumns = @JoinColumn(name = "operation_claim_id") // Bu ara tabloda OperationClaim'i temsil eden kolon.
    )
    private Set<OperationClaim> operationClaims;

    public Set<OperationClaim> getOperationClaims() {
        return operationClaims;
    }

    public void setOperationClaims(Set<OperationClaim> operationClaims) {
        this.operationClaims = operationClaims;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
