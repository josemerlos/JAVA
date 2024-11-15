package br.com.artigo.livro.repository;


import br.com.artigo.livro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     //A anotação indica que a classe contém lógica de acesso a dados e instrui o Spring a converter as exceções específicas do banco para a hierarquia DataAccessException do Spring.
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
