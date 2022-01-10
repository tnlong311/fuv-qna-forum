package com.qnaforum.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WebAppController {
    @GetMapping("/welcome")
    public String helloWorld() {
        return "you don't need to be logged in";
    }

    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "this is not restricted section";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }
}
