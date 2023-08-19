package Pizzaria.example.Pizzariadohabibi.Controller;

import Pizzaria.example.Pizzariadohabibi.DTO.ItemDto;
import Pizzaria.example.Pizzariadohabibi.Entity.
import Pizzaria.example.Pizzariadohabibi.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/findall")

    public List<Item> Findall() {
        return service.Findall();
    }

    @GetMapping("/codigo")
    private Item FindByCOdigo (@RequestParam String codigo) {
        return service.FindByCodigo(codigo);
    }

    @PostMapping

    public ResponseEntity<Item> create (@RequestBody
                                        ItemDto itemDto) {

        return service.create(itemDto);
    };

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody ItemDto itemDto, @RequestParam Long id){
        return service.update(id, itemDto);
    }

    @DeleteMapping
    private ResponseEntity<Object> Delete(@RequestParam long id){

        return service.delete(id);
    }

}
