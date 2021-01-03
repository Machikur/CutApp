package com.urlcuter.cuter.controller;

import com.urlcuter.cuter.linkexception.WrongShortVersionExeption;
import com.urlcuter.cuter.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/")
public class LinkController {

    private final LinkService linkService;
    private final HttpServletResponse httpServletResponse;

    @Autowired
    public LinkController(final HttpServletResponse httpServletResponse, final LinkService linkService) {
        this.httpServletResponse = httpServletResponse;
        this.linkService = linkService;

    }
    @GetMapping(value = "{shorted}")
    public void getShort(@PathVariable String shorted) throws WrongShortVersionExeption, IOException, URISyntaxException {
        httpServletResponse.sendRedirect(linkService.getUrlByShortVersion(shorted));
    }


}
