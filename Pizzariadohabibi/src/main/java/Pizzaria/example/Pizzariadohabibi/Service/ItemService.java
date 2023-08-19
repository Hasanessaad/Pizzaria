package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.ItemDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Item;
import Pizzaria.example.Pizzariadohabibi.Repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;


    public List<Item> Findall() { return repository.findAll();}

    public Item FindByCodigo(String name) { return repository.findByCodigo(name);}

    public ResponseEntity<Object> update (Long id, ItemDto itemDto){
        Optional<Item> iteme_update = repository.findById(id);
        if ( iteme_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Item item = iteme_update.get();
            BeanUtils.copyProperties(itemDto,item);
            return ResponseEntity.ok(iteme_update);

        }

    }

    public ResponseEntity<Item> create(ItemDto itemDto){

        try {
            Item iteme = new Item();
            BeanUtils.copyProperties(itemDto, iteme);

            repository.save(iteme);

            return ResponseEntity.ok(iteme);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Item> iteme_optional = repository.findById(id) ;
        if ( iteme_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Item iteme = iteme_optional.get();
            repository.delete(iteme);
            return ResponseEntity.ok("Iteme deletado com sucesso");


        }

    }

}
