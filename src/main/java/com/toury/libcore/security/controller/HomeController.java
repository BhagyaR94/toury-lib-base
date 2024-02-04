package com.toury.libcore.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @PostMapping("/sample")
    public String getSample() {
        return "Sample here";
    }
}
