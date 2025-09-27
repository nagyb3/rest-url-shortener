package org.example.resturlshortener.utils;

import org.example.resturlshortener.entities.UrlShort;
import org.springframework.beans.factory.annotation.Value;

public class CalculateShortenedUrl {

    @Value("${API_BASE_URL:http://localhost:8080}")
    private String apiBaseUrl;

    public String getShortenedUrl(UrlShort urlShort) {
        return apiBaseUrl + "/" + urlShort.getId();
    }
}
