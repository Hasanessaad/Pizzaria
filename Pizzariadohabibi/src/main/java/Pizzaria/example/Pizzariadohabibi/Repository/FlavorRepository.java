package Pizzaria.example.Pizzariadohabibi.Repository;

import Pizzaria.example.Pizzariadohabibi.Entity.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavorRepository extends JpaRepository<Flavor, Long> {
    Flavor findByNome(String nome);
}
