package Pizzaria.example.Pizzariadohabibi.Controller;

import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import Pizzaria.example.Pizzariadohabibi.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<?> Findall() {
        return addressService.findAll();
    }
}
