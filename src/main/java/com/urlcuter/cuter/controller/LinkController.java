package com.urlcuter.cuter.controller;

import com.urlcuter.cuter.linkexception.WrongShortVersionExeption;
import com.urlcuter.cuter.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/cut")
public class LinkController {

    private final LinkService linkService;

    private final HttpServletResponse httpServletResponse;

    @Autowired
    public LinkController(final HttpServletResponse httpServletResponse, final LinkService linkService) {
        this.httpServletResponse = httpServletResponse;
        this.linkService = linkService;

    }

    @PostMapping(value = "link")
    public String saveLink(@RequestBody String url) {
        return "http://localhost:8080/cut/" + linkService.saveLink(url).getShortVersion();
    }

    @GetMapping(value = "{shorted}")
    public void getShort(@PathVariable String shorted) throws WrongShortVersionExeption {
        try {
            httpServletResponse.sendRedirect(linkService.getUrlByShortVersion(shorted));
        } catch (IOException s) {
            throw new WrongShortVersionExeption("Wrong Url");
        }
    }


}
