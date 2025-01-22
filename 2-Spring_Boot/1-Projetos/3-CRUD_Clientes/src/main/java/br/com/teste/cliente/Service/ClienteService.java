package br.com.teste.cliente.Service;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.teste.cliente.Entity.Cliente;
import br.com.teste.cliente.Repository.ClienteRepository;
import br.com.teste.cliente.Repository.ClienteRepositoryJDBC;





@Service
public class ClienteService {

   
    private ClienteRepository clientRepository;
    private ClienteRepositoryJDBC clientRepositoryJDBC;
    private  JdbcTemplate jdbcTemplate;

    public ClienteService(ClienteRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    /*public List<Cliente> getAllClients() {
        return clientRepository.findAllClientes();
    }*/

    public List<Cliente> getAllClients() {
        return clientRepository.findAll();
    }

    public Cliente createClient(Cliente client) {
       // System.out.println("ID do cliente: " + client.getId());
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




   
    public List<Cliente> getClienteJdbcTemplate() {
        return clientRepositoryJDBC.getClientesJdbcTemplate();
    }



    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public class ClienteNotFoundException extends RuntimeException {
        public ClienteNotFoundException(String message) {
            super(message);
        }
    }



    @RestControllerAdvice
    public class ErrorHandler {
        @ExceptionHandler(ClienteNotFoundException.class)
        public ResponseEntity<String> handleClienteNotFoundException(ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    
}
