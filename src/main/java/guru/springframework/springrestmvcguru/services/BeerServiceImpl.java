package guru.springframework.springrestmvcguru.services;

import guru.springframework.springrestmvcguru.model.Beer;
import guru.springframework.springrestmvcguru.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j // a logging property
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.info("Get Beer Id in service was called");

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Corona")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
