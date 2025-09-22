package com.example.libraryNew.entity;

import com.example.libraryNew.enums.MemberLevel;
import com.example.libraryNew.enums.MemberStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String email;
    private String password;
    private int tel;
    @Enumerated(EnumType.STRING)
    private MemberLevel memberLevel;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Borrow> borrow;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Rezervation> rezervation;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<User> user;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Notification> notification;

    @OneToMany(mappedBy = "member")
    private List<Punish> punish;

    public List<Punish> getPunish() {
        return punish;
    }

    public void setPunish(List<Punish> punish) {
        this.punish = punish;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }

    public List<Rezervation> getRezervation() {
        return rezervation;
    }

    public void setRezervation(List<Rezervation> rezervation) {
        this.rezervation = rezervation;
    }

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

    public MemberLevel getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(MemberLevel memberLevel) {
        this.memberLevel = memberLevel;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }
}
