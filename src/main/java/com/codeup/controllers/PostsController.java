package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class PostsController {
    @GetMapping("/posts")
    @ResponseBody //returns string
    public String index(@PathVariable String index) {
        return "<h1>Page index is: " + index + "</h1>";
    }
}
