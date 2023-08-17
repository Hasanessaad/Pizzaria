package Pizzaria.example.Pizzariadohabibi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Item" , schema = "public")
public class Item {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "size")
    private int size;

    @Getter
    @Setter
    @Column(name = "price")
    private Float price;

    @Getter
    @Setter
    @Column(name = "size")
    private int quantity;

    @Getter
    @Setter
    @Column(name = "extra")
    private String extra;

    @Getter
    @Setter
    @Column(name = "remove")
    private String remove;

    @OneToOne
    @JoinColumn(name = "flavor_id") // Establishing the OneToOne relationship with Flavor
    private Flavor flavor;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
