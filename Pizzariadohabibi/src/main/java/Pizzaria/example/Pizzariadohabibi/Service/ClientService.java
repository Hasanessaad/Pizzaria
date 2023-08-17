package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.ClientDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Client;
import Pizzaria.example.Pizzariadohabibi.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(rollbackFor = Exception.class)
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
}
