package com.knight.bean;

import org.springframework.context.annotation.Bean;
import lombok.Data;

@Data
public class User {
    private String userId;
    private String name;
    private int age;
    private String email;
//    public User(){}
//    public User(String userId, String name, int age){
//        userId = userId;
//        name = name;
//        age = age;
//    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
