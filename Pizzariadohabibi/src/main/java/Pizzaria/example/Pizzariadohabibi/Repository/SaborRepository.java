package Pizzaria.example.Pizzariadohabibi.Repository;

import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Entity.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaborRepository extends JpaRepository<Long, Flavor> {
}
