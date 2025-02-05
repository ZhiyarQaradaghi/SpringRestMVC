package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Beer;
import guru.springframework.springrestmvcguru.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.UUID;

@Slf4j
@AllArgsConstructor // create the constructor with the BeerService beerService required ARG
@RestController// return back JSON body instead of @Controller html
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    public Beer getBeerById(UUID id) {
        log.info("Getting beer by id - in controller");

        return  beerService.getBeerById(id);
    }
}
