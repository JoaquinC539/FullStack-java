package com.user.user.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false )
    private Long id;
    @Column (nullable = false)
    private LocalDate date;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String birth;

    public User(){}
    public User(Long id){
        this.id=id;
    }
    public User(Long id,String name){
        this.id=id;
        this.name=name;
    }
    public User(String name,String birth){
        this.name=name;
        this.birth=birth;
    }
    public User(Long id,String name,String birth){
        this.id=id;
        this.name=name;
        this.birth=birth;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBirth(){
        return this.birth;
    }
    public void setBirth(String birth){
        this.birth=birth;
    }

    @Override
    public String toString(){
        return "User{" +
        "name='" + name + '\'' +
        ", birth='" + birth + '\'' +
        ", id='" + id + '\'' +
        ", created='" + date + '\'' +
        '}';
    }
}
