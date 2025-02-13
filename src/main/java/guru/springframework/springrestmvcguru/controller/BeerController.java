package guru.springframework.springrestmvcguru.controller;

import guru.springframework.springrestmvcguru.model.Beer;
import guru.springframework.springrestmvcguru.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor // create the constructor with the BeerService beerService required ARG
@RestController// return back JSON body instead of @Controller html
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";


    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId) {

        beerService.deleteById(beerId);


        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {
        beerService.updateBeerById(beerId, beer);


        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString()); // adds the location of this beer property to the header

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @RequestMapping(value = BEER_PATH_ID, method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.info("Getting beer by id - in controller -1234 asdf");

        return  beerService.getBeerById(beerId);
    }
}
