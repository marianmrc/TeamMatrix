package com.matrix.controller;

import com.matrix.exception.NonUniqueCnpException;
import com.matrix.exception.NonUniqueEmailException;
import com.matrix.model.Centre;
import com.matrix.model.User;
import com.matrix.model.Vaccination;
import com.matrix.service.CentreService;
import com.matrix.service.UserService;
import com.matrix.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/platforma")
public class UserController {
    private final UserService userService;
    private final CentreService centreService;
    private final VaccinationService vaccinationService;
    private String userEmail;
    private Centre centreSelected;

    @Autowired
    public UserController(UserService userService,
                          CentreService centreService,
                          VaccinationService vaccinationService) {
        this.userService = userService;
        this.centreService = centreService;
        this.vaccinationService = vaccinationService;
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute User user,
                        BindingResult result,
                        Model model) {
        return "login";
    }

    @PostMapping(value = "/centres")
    public String loginProcess(@ModelAttribute User user,
                               BindingResult result,
                               Model model) {
        if (userService.login(user.getEmail(), user.getPassword())) {
            userEmail = user.getEmail();
            List<Centre> centres = centreService.getCentres();
            model.addAttribute("user", user);
            model.addAttribute("centres", centres);
            return "centre";
        }
        return "login";
    }

    @PostMapping(value = "/centres/date")
    public String date(@ModelAttribute User user,
                       @ModelAttribute Centre centre,
                       BindingResult result,
                       Model model) {
        model.addAttribute("user", user);
        model.addAttribute("centre", centre);
        centreSelected = centre;
        return "date";
    }

    @PostMapping(value = "/centres/date/program")
    public String programming(@ModelAttribute User user,
                              @ModelAttribute Vaccination vaccination,
                              @ModelAttribute Centre centre,
                              BindingResult result,
                              Model model) {
        model.addAttribute("user", user);
        model.addAttribute("centre", centre);
        model.addAttribute("vaccination", vaccination);

        return "done";
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
