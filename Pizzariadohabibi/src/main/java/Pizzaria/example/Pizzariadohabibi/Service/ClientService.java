package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.ClientDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Client;
import Pizzaria.example.Pizzariadohabibi.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

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

    public ClientDto updateClient(Long clientId, ClientDto clientDto) {
        Client clientToUpdate = getClientEntityById(clientId);
        updateEntityFromDto(clientDto, clientToUpdate);
        Client updatedClient = clientRepository.save(clientToUpdate);
        return convertEntityToDto(updatedClient);
    }

    private Client getClientEntityById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    private void updateEntityFromDto(ClientDto clientDto, Client client) {
        // Implement update logic here
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setCpf(clientDto.getCpf());
        client.setAddresses(clientDto.getAddresses());
        client.setOrders(clientDto.getOrders());
    }

    private ClientDto convertEntityToDto(Client client) {
        // Implement conversion logic here
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setPhone(client.getPhone());
        clientDto.setCpf(client.getCpf());
        clientDto.setAddresses(client.getAddresses());
        clientDto.setOrders(client.getOrders());
        return clientDto;
    }

}
