package Pizzaria.example.Pizzariadohabibi.Controller;


import Pizzaria.example.Pizzariadohabibi.DTO.FlavorDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Flavor;
import Pizzaria.example.Pizzariadohabibi.Service.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flavor")
public class FlavorController {
    @Autowired
    private FlavorService service;

    @GetMapping("/findall")

    public List<Flavor> Findall() {
        return service.Findall();
    }

    @GetMapping("/nome")
    private Flavor findByNome (@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @PostMapping

    public ResponseEntity<Flavor> create (@RequestBody
                                          FlavorDto flavorDto) {

        return service.create(flavorDto);
    };

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody FlavorDto flavorDto, @RequestParam Long id){
        return service.update(id, flavorDto);
    }

    @DeleteMapping
    private ResponseEntity<Object> Delete(@RequestParam long id){

        return service.delete(id);
    }

}
