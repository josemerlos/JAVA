package br.com.teste.cliente.Entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;
    
    private String email;
}