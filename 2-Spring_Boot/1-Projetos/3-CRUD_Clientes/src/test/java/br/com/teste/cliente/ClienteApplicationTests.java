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





















/* 
package br.com.teste.cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.teste.cliente.Entity.Cliente;
import br.com.teste.cliente.Repository.ClienteRepository;
import br.com.teste.cliente.Service.ClienteService;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ClienteApplication.class)
class ClienteApplicationTests {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllClients_shouldReturnClientList() {
        // Arrange
        List<Cliente> mockClients = List.of(
                new Cliente(1L, "Alice", "alice@example.com"),
                new Cliente(2L, "Bob", "bob@example.com")
        );
        when(clienteRepository.findAll()).thenReturn(mockClients);

        // Act
        List<Cliente> clients = clienteService.getAllClients();

        // Assert
        assertEquals(2, clients.size());
        assertEquals("Alice", clients.get(0).getName());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void createClient_shouldSaveAndReturnClient() {
        // Arrange
        Cliente newClient = new Cliente(null, "Charlie", "charlie@example.com");
        Cliente savedClient = new Cliente(1L, "Charlie", "charlie@example.com");
        when(clienteRepository.save(newClient)).thenReturn(savedClient);

        // Act
        Cliente client = clienteService.createClient(newClient);

        // Assert
        assertNotNull(client.getId());
        assertEquals("Charlie", client.getName());
        verify(clienteRepository, times(1)).save(newClient);
    }

    @Test
    void updateClient_whenClientExists_shouldUpdateAndReturnClient() {
        // Arrange
        Cliente existingClient = new Cliente(1L, "Dave", "dave@example.com");
        Cliente updatedClient = new Cliente(null, "David", "david@example.com");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(existingClient));
        when(clienteRepository.save(existingClient)).thenReturn(existingClient);

        // Act
        Cliente client = clienteService.updateClient(1L, updatedClient);

        // Assert
        assertEquals("David", client.getName());
        assertEquals("david@example.com", client.getEmail());
        verify(clienteRepository, times(1)).findById(1L);
        verify(clienteRepository, times(1)).save(existingClient);
    }

    @Test
    void updateClient_whenClientDoesNotExist_shouldThrowException() {
        // Arrange
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(ClienteService.ClienteNotFoundException.class, () -> {
            clienteService.updateClient(1L, new Cliente(null, "David", "david@example.com"));
        });
        assertEquals("Cliente nao encontrado.", exception.getMessage());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void deleteClient_shouldDeleteClientById() {
        // Arrange
        doNothing().when(clienteRepository).deleteById(1L);

        // Act
        clienteService.deleteClient(1L);

        // Assert
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}

/*package br.com.teste.cliente;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteApplicationTests {

	@Test
	void contextLoads() {
	}

}*/
