package br.com.teste.cliente.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.cliente.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   
    //Cliente getByName(String name)


}
