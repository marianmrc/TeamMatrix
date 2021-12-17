package com.matrix.controller;

import com.matrix.exception.NonUniqueCnpException;
import com.matrix.exception.NonUniqueEmailException;
import com.matrix.model.User;
import com.matrix.security.PasswordEncoder;
import com.matrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/platforma")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute User user,
                        BindingResult result,
                        Model model) {
        return "login";
    }

    @PostMapping(value = "/loginProcess")
    public String loginProcess(@ModelAttribute User user,
                               BindingResult result,
                               Model model) {
        if (userService.login(user.getEmail(), user.getPassword())) {
            return "vaccination";
        }
        return "login";
    }

    @RequestMapping({"/"})
    public String getIndex(Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByEmail(principal.getName()));
        return "vaccination";
    }

    @GetMapping("/user")
    public String getUserByEmail(Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByEmail(principal.getName()));
        return "user";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        try {
            userService.createUser(user);
            return "login";
        } catch (NonUniqueEmailException nonUniqueEmailException) {
            model.addAttribute("emailAlreadyExists", true);
        } catch (NonUniqueCnpException nonUniqueCnpException) {
            model.addAttribute("cnpAlreadyExists", true);
        }
        return "register";
    }
}
