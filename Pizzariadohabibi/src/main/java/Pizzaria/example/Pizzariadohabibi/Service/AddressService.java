package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.Controller.AddressController;
import Pizzaria.example.Pizzariadohabibi.DTO.AddressDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional(rollbackFor = Exception.class)
    public Address cadastrar(String nameperson, AddressDto addressDto) {
        // Create an Address entity from the DTO
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setNumber(addressDto.getNumber());

        // Save the address
        return addressRepository.save(address);
    }
}
