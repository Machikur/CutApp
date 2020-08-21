package com.urlcuter.cuter.controller;

import com.urlcuter.cuter.serlvetresponse.SerlvetResponse;
import com.urlcuter.cuter.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/cut")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private SerlvetResponse serlvetResponse;

    @RequestMapping(method = RequestMethod.POST, value = "link")
    public String saveLink(@RequestBody String url) {
        return  "http://localhost:8080/cut/" + linkService.saveLink(url).getShortVersion();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{shorted}")
    public void getShort(@PathVariable String shorted) throws IOException {
        serlvetResponse.sendRedirect(linkService.getUrlByShortVersion(shorted));
    }

}
