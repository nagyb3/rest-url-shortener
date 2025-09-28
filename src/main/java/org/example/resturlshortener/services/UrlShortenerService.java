package org.example.resturlshortener.services;

import org.example.resturlshortener.entities.UrlShort;
import org.example.resturlshortener.exceptions.OriginalUrlNotFoundException;
import org.example.resturlshortener.repositories.UrlShortRepository;
import org.example.resturlshortener.utils.CalculateShortenedUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlShortenerService {

    @Autowired
    UrlShortRepository urlShortRepository;

    CalculateShortenedUrl calculateShortenedUrl = new CalculateShortenedUrl();

    public String shortUrl(String inputUrl) {
        UrlShort urlShort = new UrlShort();

        urlShort.setOriginalUrl(inputUrl);

        return calculateShortenedUrl.getShortenedUrl(urlShortRepository.save(urlShort));
    }

    @Cacheable(cacheNames = "originalUrl", key = "#id")
    public String retrieveOriginalUrl(String id) throws OriginalUrlNotFoundException {
        Optional<UrlShort> result = urlShortRepository.findById(UUID.fromString(id));

        if (result.isPresent()) {
            return result.get().getOriginalUrl();
        } else {
            throw new OriginalUrlNotFoundException();
        }
    }
}
