package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class HelloWorldController {

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
}
