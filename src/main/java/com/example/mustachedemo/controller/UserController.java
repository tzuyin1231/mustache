package com.example.mustachedemo.controller;

import com.example.mustachedemo.Service.UserService;
import com.example.mustachedemo.model.entities.UserEntitites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAllUserView(Model model) {
        List<UserEntitites> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "home";
    }
}
