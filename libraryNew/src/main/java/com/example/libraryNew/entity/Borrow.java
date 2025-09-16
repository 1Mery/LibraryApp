package com.example.libraryNew.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ÖdünçAlma")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date borrowDate;
    private Date finishDate;

    @ManyToOne()
    @JoinColumn(name = "books_id",nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "members_id",nullable = false)
    private Member member;

    @ManyToOne()
    @JoinColumn(name="admins_id",nullable = false)
    private Admin admin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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

    public Admin getAdmins() {
        return admin;
    }

    public void setAdmins(Admin admin) {
        this.admin = admin;
    }
}
