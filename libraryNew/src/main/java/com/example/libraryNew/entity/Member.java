package com.example.libraryNew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Üyeler")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String mail;
    private int tel;

    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<Borrow> borrows;

    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<Rezervation> rezervations;

    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public List<Rezervation> getRezervations() {
        return rezervations;
    }

    public void setRezervations(List<Rezervation> rezervations) {
        this.rezervations = rezervations;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
