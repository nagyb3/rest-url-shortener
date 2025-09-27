package org.example.resturlshortener.utils;

import org.example.resturlshortener.entities.UrlShort;

public class CalculateShortenedUrl {
    String apiBaseUrl = "http://localhost:8080";

    public String getShortenedUrl(UrlShort urlShort) {
        return apiBaseUrl + "/" + urlShort.getId();
    }
}
