package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Beer;

import java.util.List;
import java.util.UUID;


public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
