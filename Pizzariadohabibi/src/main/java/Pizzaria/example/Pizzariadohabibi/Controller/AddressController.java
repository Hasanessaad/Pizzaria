package Pizzaria.example.Pizzariadohabibi.Controller;

import Pizzaria.example.Pizzariadohabibi.DTO.AddressDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import Pizzaria.example.Pizzariadohabibi.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try{
            List<?> addresses = addressRepository.findAll();
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/{clientId}")
    public ResponseEntity<Address> cadastrar(@PathVariable Long clientId, @RequestBody AddressDto addressDto) {
        Address address = addressService.cadastrar(clientId , addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

}
