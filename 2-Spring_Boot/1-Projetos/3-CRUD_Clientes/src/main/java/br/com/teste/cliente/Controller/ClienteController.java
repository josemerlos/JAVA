package br.com.teste.cliente.Controller;

import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import br.com.teste.cliente.Entity.Cliente;

//import lombok.AllArgsConstructor;
import br.com.teste.cliente.Service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClients() {
        return clienteService.getAllClients();
    }

    @PostMapping
    public Cliente createClient(@RequestBody Cliente client) {
        return clienteService.createClient(client);
    }

    @PutMapping("/{id}")
    public Cliente updateClient(@PathVariable Long id, @RequestBody Cliente updatedClient) {
        return clienteService.updateClient(id, updatedClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
    }
}


