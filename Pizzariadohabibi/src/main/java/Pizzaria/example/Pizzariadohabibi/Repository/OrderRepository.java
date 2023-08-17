package Pizzaria.example.Pizzariadohabibi.Repository;

import Pizzaria.example.Pizzariadohabibi.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.LongFunction;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
