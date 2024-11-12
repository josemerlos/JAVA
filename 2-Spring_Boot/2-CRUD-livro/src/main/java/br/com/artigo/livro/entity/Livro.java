package br.com.artigo.livro.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


//Caso você não tenha o Lombok, basta criar os getters, o toString e o Construtor com todos os atributos da classe.
@Entity
@Getter //gera os getters da nossa classe.
@ToString // gera o toString com os atributos da classe.
@NoArgsConstructor
@AllArgsConstructor // gera o construtor com todos os argumentos.     O objetivo de um metodo construtor é construir objetos da classe. O construtor é um méodo especial que tem o mesmo nome da classe e garante a alocação de memória necessária para cada objeto da classe. Um construtor não retorna valor algum, nem mesmo do tipo void. Toda classe deve ter um construtor.
public class Livro {



    @Id
    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

   // @NoArgsConstructor — anotação do Lombok para gerar um construtor default (construtor vazio — requerido pelo hibernate). Caso não tenha o Lombok, crie um construtor default.

    //@Entity— é utilizada para informar que uma classe também é uma entidade. A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos. (import javax.persistence.Entity)

   // @Id — é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados. (import javax.persistence.Id)

  //  @Enumerated(EnumType.STRING) — suporte a conversão de valores de enum para a base de dados e da base de dados para enum. Com EnumType.STRING definimos que o hibernate cadastrará o valor string do enum. (import javax.persistence.Enumerated)

//O Hibernate é uma ferramenta de mapeamento objeto-relacional (ou ORM) para Java. Basicamente como ttodo o ORM, o Hibernate transforma os dados da estrutura lógica de um banco de dados em objetos relacionais. Com a utilização do Hibernate, não há necessidade de escrever SQL “puro”, pois ele utiliza seu próprio código, chamado de HQL (Hibernate Query Language).


}
