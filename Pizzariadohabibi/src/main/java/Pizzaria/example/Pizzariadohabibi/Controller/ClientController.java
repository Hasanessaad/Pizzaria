package Pizzaria.example.Pizzariadohabibi.Controller;

import Pizzaria.example.Pizzariadohabibi.DTO.AddressDto;
import Pizzaria.example.Pizzariadohabibi.DTO.ClientDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Entity.Client;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import Pizzaria.example.Pizzariadohabibi.Repository.ClientRepository;
import Pizzaria.example.Pizzariadohabibi.Service.AddressService;
import Pizzaria.example.Pizzariadohabibi.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<?> clients = clientRepository.findAll();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Client> create(@RequestBody ClientDto clientDto) {
        Client client = clientService.create(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PutMapping("/edit/{clientId}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto, @PathVariable final Long clientId) {
        ClientDto updatedClient = clientService.updateClient(clientDto, clientId);
        return ResponseEntity.ok(updatedClient);
    }

    @PostMapping("/addingaddress")
    public ResponseEntity<Address> AddressForClient(@PathVariable Long clientId, @RequestBody AddressDto addressDto) {
        Address address = clientService.AddressForClient(clientId , addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Object> Delete(@RequestParam long id){

        return clientService.delete(id);
    }

}
