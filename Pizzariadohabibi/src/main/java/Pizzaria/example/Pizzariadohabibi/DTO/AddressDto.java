package Pizzaria.example.Pizzariadohabibi.DTO;

import Pizzaria.example.Pizzariadohabibi.Entity.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class AddressDto {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String number;

    @Getter
    @Setter
    private Client client;
}
