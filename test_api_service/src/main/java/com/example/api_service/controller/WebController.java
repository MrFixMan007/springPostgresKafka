package com.example.api_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class WebController {

    @GetMapping
    public String index(){
        return "ok";
    }

    @GetMapping("/hy")
    public String indexHy(){
        return "hy";
    }

}