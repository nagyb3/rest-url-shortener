package org.example.resturlshortener.utils;

import org.example.resturlshortener.entities.UrlShort;

public class CalculateShortenedUrl {
    private String apiBaseUrl = System.getenv().getOrDefault("API_BASE_URL", "http://localhost:8080");

    public String getShortenedUrl(UrlShort urlShort) {
        return apiBaseUrl + "/" + urlShort.getId();
    }
}
