package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String printUsers(Model model) {
        return "index";
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("age") int age, Model model) {
        User user = new User(name, email, age);
        userService.addUser(user);
        return "redirect:/index";
    }
}
