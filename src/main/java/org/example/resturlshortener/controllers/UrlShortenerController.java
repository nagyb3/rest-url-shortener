package org.example.resturlshortener.controllers;

import org.example.resturlshortener.dto.UrlShortenerPostDto;
import org.example.resturlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("url-shortener")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("")
    String shortUrl(@RequestBody UrlShortenerPostDto body) {

        String inputUrl = body.getUrl();

        return urlShortenerService.shortUrl(inputUrl);
    }
}
