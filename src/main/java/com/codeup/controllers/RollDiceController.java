package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by kevinjones on 2/8/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String showDiceLinks() {
        return "roll-dice/index";
    }

    @GetMapping("/roll-dice/{n}")
    public String compareGuess(@PathVariable int n, Model model) {
        int rollDice = (int) (Math.random() * 6 + 1); //Generate random number between 1-6
        model.addAttribute("n", n);
        model.addAttribute("rollDice", rollDice);
        return "roll-dice/roll-dice-result";
    }
}
