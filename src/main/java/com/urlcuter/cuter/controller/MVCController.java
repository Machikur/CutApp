package com.urlcuter.cuter.controller;

import com.urlcuter.cuter.link.LinkDto;
import com.urlcuter.cuter.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generateLink")
public class MVCController {

    private final LinkService linkService;

    @Autowired
    public MVCController(final LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping
    public String getView(Model model) {
        model.addAttribute("link", new LinkDto("Wpisz tutaj swój link",""));
        return "View";
    }

    @PostMapping
    public String getLink(@ModelAttribute LinkDto link, BindingResult errors, Model model) {
        if (errors.hasErrors()){
            System.out.println(errors);
        }
        LinkDto resultLink = linkService.findOrCreateNewLink(link.getUrl());
        model.addAttribute("link", resultLink);
        return "View";
    }

}
