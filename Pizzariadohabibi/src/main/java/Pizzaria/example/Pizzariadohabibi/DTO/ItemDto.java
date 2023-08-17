package Pizzaria.example.Pizzariadohabibi.DTO;

import Pizzaria.example.Pizzariadohabibi.Entity.Flavor;
import Pizzaria.example.Pizzariadohabibi.Entity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class ItemDto {
    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private int size;

    @Getter
    @Setter
    private Float price;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private String extra;

    @Getter
    @Setter
    private String remove;

    @Getter
    @Setter
    private Flavor flavor;

    @Getter
    @Setter
    private Order order;
}
