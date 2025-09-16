package com.example.libraryNew.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Rezervasyonlar")
public class Rezervation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date rezervationDate;
    private String state;
    private int orderNo;

    @ManyToOne
    @JoinColumn(name = "books_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name= "members_id",nullable = false)
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRezervationDate() {
        return rezervationDate;
    }

    public void setRezervationDate(Date rezervationDate) {
        this.rezervationDate = rezervationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOrder() {
        return orderNo;
    }

    public void setOrder(int order) {
        this.orderNo = orderNo;
    }

    public Book getBooks() {
        return book;
    }

    public void setBooks(Book book) {
        this.book = book;
    }

    public Member getMembers() {
        return member;
    }

    public void setMembers(Member member) {
        this.member = member;
    }
}
