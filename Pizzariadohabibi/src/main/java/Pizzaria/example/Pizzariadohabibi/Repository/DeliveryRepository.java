package Pizzaria.example.Pizzariadohabibi.Repository;

import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Long, Delivery> {
}
