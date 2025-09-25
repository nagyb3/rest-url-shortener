package org.example.resturlshortener.controllers;

import org.example.resturlshortener.dto.UrlShortenerPostDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("url-shortener")
public class UrlShortenerController {

    @PostMapping("")
    HashMap<String, String> getHello(@RequestBody UrlShortenerPostDto body) {

        HashMap<String, String> result = new HashMap<>();

        result.put("hello", "api");
        return result;
    }
}
