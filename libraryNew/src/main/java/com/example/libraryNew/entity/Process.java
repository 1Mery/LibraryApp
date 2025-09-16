package com.example.libraryNew.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "İşlemler")
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String processType;
    private Date processDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
