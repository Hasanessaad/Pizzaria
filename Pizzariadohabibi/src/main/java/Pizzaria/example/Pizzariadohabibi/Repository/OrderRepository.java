package Pizzaria.example.Pizzariadohabibi.Repository;

import Pizzaria.example.Pizzariadohabibi.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Long, Order> {
}
