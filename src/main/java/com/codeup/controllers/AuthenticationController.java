package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kevinjones on 2/13/17.
 */
@Controller
public class AuthenticationController {
    @Autowired
    private UsersRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public AuthenticationController(UsersRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println(new BCryptPasswordEncoder().encode("codeup1"));
        return "login";
    }

    @GetMapping("/register")
    public String showForm(Model m) {
        m.addAttribute("user", new User());
        return "users/create";
    }

    // CSRF => Cross Site Request Forgery -> Random token
    // DOS => Denial Of Service

    @PostMapping("/users/create")
    public String registerUser(@ModelAttribute User user) { //create the user from the input values
        String hashedPassword = encoder.encode(user.getPassword()); //hash the users password
        user.setPassword(hashedPassword);
        repository.save(user); //save the user to the database

        return "redirect:/login"; //redirect the user to the login page
    }
}
