package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage() {
        return "home"; //home.html (file)
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact/form"; //returning to a file called form in my contact folder
    }

    @GetMapping("/hello/{name}")
    @ResponseBody //returns string
    public String hello(@PathVariable String name) {
        return "<h1>Hello " + name + " from Spring!!!!</h1>";
    }

    private String formatGreeting(String name) {
        return "<h1>Hello " + name + " from Spring!!!!</h1>";
    }

    @RequestMapping(path = "/bye/{name}", method = RequestMethod.GET)
    @ResponseBody //returns string
    public String bye(@PathVariable String name) {
        return "<h1>Goodbye " + name + "! from Spring</h1";
    }

    @GetMapping("/date")
    public String showDefault(Model model) {
        model.addAttribute("date", "Feb 7th");
        return "contact/default";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<String> names = new ArrayList<>();

        names.add("Kevin");
        names.add("Billy");
        names.add("Jimmy");
        names.add("Steve");
        names.add("Ben");

        model.addAttribute("names", names);
        return "contact/default";
    }
}
