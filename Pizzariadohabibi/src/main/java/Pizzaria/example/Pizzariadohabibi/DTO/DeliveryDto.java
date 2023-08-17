package Pizzaria.example.Pizzariadohabibi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class DeliveryDto {
    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float value;

    // I still need to connect to the order 1 Order = 1 delivery
}
