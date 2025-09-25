package org.example.resturlshortener.repositories;

import org.example.resturlshortener.entities.UrlShort;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UrlShortRepository extends CrudRepository<UrlShort, UUID> {

    UrlShort findByShortenedUrl(String shortUrl);
}