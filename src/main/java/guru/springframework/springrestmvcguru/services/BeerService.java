package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Beer;

import java.util.List;
import java.util.UUID;


public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);
}
