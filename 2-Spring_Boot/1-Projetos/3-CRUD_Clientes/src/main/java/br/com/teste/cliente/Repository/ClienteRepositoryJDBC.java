package br.com.teste.cliente.Repository;

import br.com.teste.cliente.Entity.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryJDBC  {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //@Override
    public List<Cliente> getClientesJdbcTemplate() {
        String sql = "SELECT id, name, email FROM cliente";
        RowMapper<Cliente> rowMapper = (n, rowNum) -> new Cliente(
            n.getLong("id"),
            n.getString("name"),
            n.getString("email")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }
}