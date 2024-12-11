package com.techspira.astroline.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetsController {

    // Example method to fix the issue
    @GetMapping("/planets")
    public String getPlanets() {
        return "Here are some planets";
    }
}
