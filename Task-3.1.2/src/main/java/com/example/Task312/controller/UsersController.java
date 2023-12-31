package com.example.Task312.controller;

import com.example.Task312.model.User;
import com.example.Task312.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getStartPage(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/users")
    public String getUserPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String getNewUserPage(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getEditUserPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
