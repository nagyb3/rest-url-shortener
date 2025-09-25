package org.example.resturlshortener.controllers;

import org.example.resturlshortener.dto.UrlShortenerPostDto;
import org.example.resturlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{shortUrl}")
    String retrieveOriginalUrl(@PathVariable String shortUrl) {
        return urlShortenerService.retrieveOriginalUrl(shortUrl);
    }
}
