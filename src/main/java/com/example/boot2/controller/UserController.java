package com.example.boot2.controller;
import com.example.boot2.model.User;
import com.example.boot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserPage(ModelMap modelMap) {
        List<User> user= userService.fetchUserList();
        modelMap.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/admin")
    public String getAdminPage(ModelMap modelMap) {
        List<User> list= userService.fetchUserList();
        modelMap.addAttribute("list", list);
        return "admin";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        Optional<Long> optLong = Optional.ofNullable(id);
        Long value = optLong.orElse(5L);
        Optional<User> user = userService.getUserById(value);
        userService.deleteUser(user.get());
        return "redirect:/admin";
    }
}
