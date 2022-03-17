package com.qy.dome.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String boot() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    // Added to test 500 page
    @RequestMapping(path = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public void error500() throws Exception {
        throw new Exception();
    }

}
