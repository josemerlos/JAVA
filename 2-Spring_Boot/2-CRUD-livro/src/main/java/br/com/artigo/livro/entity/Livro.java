package br.com.artigo.livro.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


//Caso você não tenha o Lombok, basta criar os getters, o toString e o Construtor com todos os atributos da classe.

@Getter //gera os getters da nossa classe.
@ToString // gera o toString com os atributos da classe.
@AllArgsConstructor // gera o construtor com todos os argumentos.     O objetivo de um metodo construtor é construir objetos da classe. O construtor é um méodo especial que tem o mesmo nome da classe e garante a alocação de memória necessária para cada objeto da classe. Um construtor não retorna valor algum, nem mesmo do tipo void. Toda classe deve ter um construtor.
public class Livro {
    private Long isbn;

    private String titulo;

    private Integer edicao;

    private String autor;

    private Categoria categoria;

    private Modelo modelo;











}
