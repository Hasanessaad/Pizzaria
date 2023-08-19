package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.AddressDto;
import Pizzaria.example.Pizzariadohabibi.DTO.ClientDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Address;
import Pizzaria.example.Pizzariadohabibi.Entity.Client;
import Pizzaria.example.Pizzariadohabibi.Repository.AddressRepository;
import Pizzaria.example.Pizzariadohabibi.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Client create(ClientDto clientDto) {
        // Create an Address entity from the DTO
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setCpf(clientDto.getCpf());
        client.setAddresses(client.getAddresses());
        client.setOrders(client.getOrders());

        // Save the address
        return clientRepository.save(client);
    }

    public ClientDto updateClient(final ClientDto clientDto, final Long clientId){

        final Client clients = this.clientRepository.findById(clientId).orElse(null);
        clients.setName(clientDto.getName());
        clients.setPhone(clientDto.getPhone());
        clients.setCpf(clientDto.getCpf());
        clients.setAddresses(clients.getAddresses());
        clients.setOrders(clients.getOrders());

        this.clientRepository.save(clients);
        return clientDto;
    }
    public Address AddressForClient(Long clientId, AddressDto addressDto) {

        Address address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setNumber(addressDto.getNumber());

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        address.setClient(client);
        return addressRepository.save(address);
    }

    public ResponseEntity<Object> delete (Long id){
        Optional<Client> cliente_optional = clientRepository.findById(id) ;
        if ( cliente_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Client cliente = cliente_optional.get();
            clientRepository.delete(cliente);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        }
    }
}
