package com.example.libraryNew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="kullanıcılar")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private int password;
    @Column(name="role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "members_id",nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "admin_id",nullable = false)
    private Admin admins;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<User> users;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Member getMembers() {
        return member;
    }

    public void setMembers(Member member) {
        this.member = member;
    }

    public Admin getAdmins() {
        return admins;
    }

    public void setAdmins(Admin admin) {
        this.admins = admin;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
