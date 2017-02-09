package com.codeup.controllers;

import com.codeup.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Created by kevinjones on 2/9/17.
 */
@Controller
public class AdsController {
    @GetMapping("/ads/create")
    public String showCreateAdForm(Model viewModel) {
        Ad ad = new Ad();
        viewModel.addAttribute("ad", ad);
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String saveAd(
            //@RequestParam(name = "title") String title,
            //@RequestParam(name = "description") String description
            @ModelAttribute Ad ad,
            Model viewModel
    ) {

        viewModel.addAttribute("ad", ad);
        return "ads/create";
    }
}
