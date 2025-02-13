package guru.springframework.springrestmvcguru.model;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Product {
    private UUID id;
    private String name;
    private String description;
}
