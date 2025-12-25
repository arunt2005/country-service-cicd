package com.apps.controller;

import com.apps.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin
public class CountryController {

    private final List<Country> countries = List.of(
            new Country("India", "New Delhi"),
            new Country("USA", "Washington DC"),
            new Country("UK", "London"),
            new Country("France", "Paris"),
            new Country("Japan", "Tokyo"),
            new Country("Germany", "Berlin"),
            new Country("Australia", "Sydney")
    );

    @GetMapping
    public List<Country> getAllCountries() {
        return countries;
    }

    @GetMapping("/{name}")
    public Country getCountryByName(@PathVariable String name) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
