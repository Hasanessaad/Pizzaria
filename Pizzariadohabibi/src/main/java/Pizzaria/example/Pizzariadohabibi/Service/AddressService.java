package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Transactional(rollbackFor = Exception.class)
    public List<?> findAll() { return addressRepository.findAll();}

}
