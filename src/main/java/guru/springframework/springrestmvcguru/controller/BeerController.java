package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Beer;
import guru.springframework.springrestmvcguru.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor // create the constructor with the BeerService beerService required ARG
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        log.info("Getting beer by id - in controller");

        return  beerService.getBeerById(id);
    }
}
