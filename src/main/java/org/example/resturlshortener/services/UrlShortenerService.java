package org.example.resturlshortener.services;

import org.example.resturlshortener.entities.UrlShort;
import org.example.resturlshortener.repositories.UrlShortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    @Autowired
    UrlShortRepository urlShortRepository;

    public String shortUrl(String inputUrl) {
        UrlShort urlShort = new UrlShort();

        urlShort.setOriginalUrl(inputUrl);

        // placeholder value
        // TODO: implement actual shortening of the URL
        urlShort.setShortenedUrl("shortenedUrl placeholder");

        return urlShortRepository.save(urlShort).getOriginalUrl();
    }
}
