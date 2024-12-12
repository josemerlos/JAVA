package br.com.teste.cliente;

import br.com.teste.cliente.Entity.Cliente;
import br.com.teste.cliente.Repository.ClienteRepository;
import br.com.teste.cliente.Service.ClienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
//import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ClienteApplication.class)
public class ClienteApplicationTests {

    @MockBean
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        cliente = new Cliente(null, "Teste testando", "teste@teste.com");
    }

    @Test
    public void testGetAllClients() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);
        
        List<Cliente> result = clienteService.getAllClients();
        
        assertEquals(clientes, result);
    }

    @Test
    public void testCreateClient() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        
        Cliente result = clienteService.createClient(cliente);
        
        assertEquals(cliente, result);
    }

    @Test
    public void testUpdateClient() {
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        
        Cliente updatedCliente = new Cliente(1L, "Nome atualizado", "email@example.com");
        Cliente result = clienteService.updateClient(1L, updatedCliente);
        
        assertEquals(updatedCliente.getName(), result.getName());
        assertEquals(updatedCliente.getEmail(), result.getEmail());
    }

    @Test
    public void testUpdateClientNotFound() {
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.empty());
        
        assertThrows(ClienteService.ClienteNotFoundException.class, () -> clienteService.updateClient(1L, cliente));
    }

    @Test
    public void testDeleteClient() {
        doNothing().when(clienteRepository).deleteById(anyLong());
        
        clienteService.deleteClient(1L);
        
        verify(clienteRepository, times(1)).deleteById(anyLong());
    }
}












