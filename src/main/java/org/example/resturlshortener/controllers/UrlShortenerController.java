package org.example.resturlshortener.controllers;

import org.example.resturlshortener.dto.UrlShortenerPostDto;
import org.example.resturlshortener.exceptions.OriginalUrlNotFoundException;
import org.example.resturlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("")
    String shortUrl(@RequestBody UrlShortenerPostDto body) {

        String inputUrl = body.getUrl();

        return urlShortenerService.shortUrl(inputUrl);
    }

    @GetMapping("/{id}")
    String retrieveOriginalUrl(@PathVariable String id) {
        try {
            return urlShortenerService.retrieveOriginalUrl(id);
        } catch (OriginalUrlNotFoundException e) {
            return "url not found";
        }
    }
}
