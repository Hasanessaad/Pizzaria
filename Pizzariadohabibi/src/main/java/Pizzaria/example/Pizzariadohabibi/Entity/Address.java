package Pizzaria.example.Pizzariadohabibi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Address", schema = "public")
public class Address {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    @Getter
    @Setter
    @Column(name = "street")
    private String street;

    @Getter
    @Setter
    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
