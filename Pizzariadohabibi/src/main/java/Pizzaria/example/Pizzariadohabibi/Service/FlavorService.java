package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.FlavorDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Flavor;
import Pizzaria.example.Pizzariadohabibi.Repository.FlavorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlavorService {
    @Autowired
    private FlavorRepository repository;


    public List<Flavor> Findall() { return repository.findAll();}

    public Flavor findByNome(String name) { return repository.findByNome(name);}

    public ResponseEntity<Object> update (Long id, FlavorDto flavorDto){
        Optional<Flavor> flavor_update = repository.findById(id);
        if ( flavor_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Flavor flavor = flavor_update.get();
            BeanUtils.copyProperties(flavorDto,flavor);
            return ResponseEntity.ok(flavor_update);

        }

    }

    public ResponseEntity<Flavor> create(FlavorDto flavorDto){

        try {
            Flavor flavor = new Flavor();
            BeanUtils.copyProperties(flavorDto, flavor);

            repository.save(flavor);

            return ResponseEntity.ok(flavor);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Flavor> sabor_optional = repository.findById(id) ;
        if ( sabor_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Flavor flavor = sabor_optional.get();
            repository.delete(flavor);
            return ResponseEntity.ok("Sabore deletado com sucesso");


        }

    }


}
