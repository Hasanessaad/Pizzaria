package Pizzaria.example.Pizzariadohabibi.DTO;

import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ClientDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private List<Address> addresses;

    @Getter
    @Setter
    private List<Order> orders;
}
