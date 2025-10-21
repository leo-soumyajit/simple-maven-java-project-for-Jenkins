package com.soumyajit.JenkinswithMaven.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class ApiController {


    @GetMapping("/")
    public String home() {
        return "Greetings from Soumyajit Banerjee!";
    }

    @GetMapping({"/hello", "/hello/{name}"})
    public String hello(@PathVariable(required = false) Optional<String> name) {
        return "Hello, " + name.orElse("Super Coder") + "! Welcome to the Maven Project.";
    }
}
