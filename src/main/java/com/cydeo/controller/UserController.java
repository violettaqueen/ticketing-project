package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());

        model.addAttribute("roles", roleService.findAll());

        model.addAttribute("users", userService.findAll());

        return "/user/create"; // html file name
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user) {
        //we go to create.html and check what we need: user, role object, users
        //before show all the users, I need to save it. How? where the object? @ModelAttribute
        //empty box means new object
        userService.save(user);

        return "redirect:/user/create"; // advantage: no need to retype previous model.attribute
    }
    @GetMapping("/update{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }

}
