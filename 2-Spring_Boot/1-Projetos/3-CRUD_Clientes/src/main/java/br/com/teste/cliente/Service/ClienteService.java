package br.com.teste.cliente.Service;
import java.util.List;

import org.springframework.stereotype.Service;


import br.com.teste.cliente.Entity.Cliente;
import br.com.teste.cliente.Repository.ClienteRepository;





@Service
public class ClienteService {

   
    private ClienteRepository clientRepository;

    public ClienteService(ClienteRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Cliente> getAllClients() {
        return clientRepository.findAll();
    }

    public Cliente createClient(Cliente client) {
        return clientRepository.save(client);
    }

    public Cliente updateClient(Long id, Cliente updatedClient) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(updatedClient.getName());
                    client.setEmail(updatedClient.getEmail());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClienteNotFoundException("Cliente nao encontrado."));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }





    public class ClienteNotFoundException extends RuntimeException {
        public ClienteNotFoundException(String message) {
            super(message);
        }
    }
    
}
