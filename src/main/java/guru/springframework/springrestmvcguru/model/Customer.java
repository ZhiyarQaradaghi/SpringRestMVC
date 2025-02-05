package guru.springframework.springrestmvcguru.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Customer {
    private UUID id;
    private String customerName;
    private String version;
    private LocalDateTime createdDateTime;
    private LocalDateTime lastModifiedDateTime;
}
