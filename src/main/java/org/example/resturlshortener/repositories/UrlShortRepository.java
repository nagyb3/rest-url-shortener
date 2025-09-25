package org.example.resturlshortener.repositories;

import org.example.resturlshortener.entities.UrlShort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UrlShortRepository extends CrudRepository<UrlShort, UUID> {

    List<UrlShort> findByShortenedUrl();

    UrlShort save(UrlShort urlShort);
}