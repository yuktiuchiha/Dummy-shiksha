package com.dummshiksha.UserService.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue
    @Id
    @Column(name="user_id")
    private int user_id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="city")
    private String city;

    @Column(name="mobile_no")
    private String mobile_no;

    @Column(name="base_course")
    private String base_course;

    @Column(name = "password")
    private String password;

    public User() {

    }



    public User(int user_id, String name, String email, String city, String mobile_no, String base_course, String password) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.mobile_no = mobile_no;
        this.base_course = base_course;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getBase_course() {
        return base_course;
    }

    public void setBase_course(String base_course) {
        this.base_course = base_course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
