package org.example.resturlshortener.controllers;

import org.example.resturlshortener.dto.UrlShortenerPostDto;
import org.example.resturlshortener.exceptions.OriginalUrlNotFoundException;
import org.example.resturlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    ResponseEntity<String> retrieveOriginalUrl(@PathVariable String id) {
        try {
            String originalUrl = urlShortenerService.retrieveOriginalUrl(id);
            return ResponseEntity.status(302).header("Location", String.valueOf(URI.create(originalUrl))).build();
        } catch (OriginalUrlNotFoundException e) {
            return ResponseEntity.status(400).body("url not found");
        }
    }
}
