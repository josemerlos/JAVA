package br.com.teste.cliente.Service;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.teste.cliente.Entity.Cliente;
import br.com.teste.cliente.Repository.ClienteRepository;





@Service
public class ClienteService {

   
    private ClienteRepository clientRepository;
    private  JdbcTemplate jdbcTemplate;

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




     @GetMapping("/jdbc")
    public List<Cliente> getClienteJdbcTemplate() {
        String sql = "SELECT id,name,email FROM cliente";
        RowMapper<Cliente> rowMapper = (rs, rowNum) -> new Cliente(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }




    public class ClienteNotFoundException extends RuntimeException {
        public ClienteNotFoundException(String message) {
            super(message);
        }
    }
    
}
