package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public String addAnswer(@PathVariable int numOne, @PathVariable int numTwo) {
        return "Your answer is: " + (numOne + numTwo);
    }

    @GetMapping("/subtract/{numOne}/from/{numTwo}")
    @ResponseBody
    public String subtractAnswer(@PathVariable int numOne, @PathVariable int numTwo) {
        return "Your answer is: " + (numTwo - numOne);
    }

    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public String multiplyAnswer(@PathVariable int numOne, @PathVariable int numTwo) {
        return "Your answer is: " + (numOne * numTwo);
    }

    @GetMapping("/divide/{numOne}/by/{numTwo}")
    @ResponseBody
    public String divideAnswer(@PathVariable int numOne, @PathVariable int numTwo) {
        return "Your answer is: " + (numOne / numTwo);
    }
}
