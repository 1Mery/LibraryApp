package com.example.libraryNew.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cezalar")
public class Punish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double tutar;

    @ManyToOne
    @JoinColumn(name = "borrow_id",nullable = false)
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name="member_id",nullable = false)
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
