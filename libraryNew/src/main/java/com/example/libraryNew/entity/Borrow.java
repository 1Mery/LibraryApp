package com.example.libraryNew.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date borrowDate;
    private Date finishDate;

    @ManyToOne()
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @ManyToOne()
    @JoinColumn(name="admin_id",nullable = false)
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
}
