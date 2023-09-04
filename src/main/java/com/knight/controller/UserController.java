package com.knight.controller;

import com.knight.aop.CustomeException;
import com.knight.aop.ModelView;
import com.knight.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @ModelView
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        System.out.println("request is coming");
//        return new User(userId,"zhansan", 10);
        if (userId.equals("throw")){
            try {
                int num = 4/0;

                return null;
            }catch (Exception e){
                throw new CustomeException();
            }
        }else {
            User user = new User();
            user.setUserId(userId);
            return user;
        }
    }

}
