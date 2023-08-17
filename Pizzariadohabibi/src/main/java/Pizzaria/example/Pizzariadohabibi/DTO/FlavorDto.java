package Pizzaria.example.Pizzariadohabibi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class FlavorDto {
    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
}
