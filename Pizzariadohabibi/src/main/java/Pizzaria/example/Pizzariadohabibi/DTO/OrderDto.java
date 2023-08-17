package Pizzaria.example.Pizzariadohabibi.DTO;

import Pizzaria.example.Pizzariadohabibi.Entity.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private LocalDateTime timestamp;

    @Getter
    @Setter
    private Float payment;

    @Getter
    @Setter
    private boolean active;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<Item> items;
}
