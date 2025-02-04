package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Beer;

import java.util.UUID;


public interface BeerService {
    Beer getBeerById(UUID id);
}
