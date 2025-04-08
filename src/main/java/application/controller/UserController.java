package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String index(ModelMap model) {
        List<User> users = userService.index();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping(value = "/index")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/index";
    }

    @GetMapping(value = "/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @GetMapping(value = "/edit")
    public String editUser(@RequestParam(name = "id") int id, ModelMap model) {
        User userToEdit = userService.getUserById(id);
        model.addAttribute("userToEdit", userToEdit);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String updateUser(@ModelAttribute("userToEdit") User user) {
        userService.updateUser(user);
        return "redirect:/index";
    }
}
