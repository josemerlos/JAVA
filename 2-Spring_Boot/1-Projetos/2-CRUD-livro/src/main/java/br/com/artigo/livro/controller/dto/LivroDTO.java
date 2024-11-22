package br.com.artigo.livro.controller.dto;

import br.com.artigo.livro.entity.Livro;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


/*
Data Transfer Object (DTO) é um padrão de projetos bastante usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.
Para adotar este padrão, vamos criar uma classe auxiliar somente com os atributos que queremos “receber” e “devolver”.
Nosso DTO, deve conter somente atributos usando classes primitivas do Java.
Evitando assim, carregamento excessivo e falhas de segurança.


GET
O que iremos fazer é criar um LivroDTO que retorna apenas o isnb, título , edição e autor .
Nosso LivroDTO recebe nossa classe Livro no construtor e “filtra” os atributos que ele precisa.
Eliminando assim, atributos que achamos desnecessário para uma simples consulta.
Além disso, temos um método estático que recebe uma lista de Livro e transforma em uma lista de LivroDTO .

*/
@Getter
public class LivroDTO {

    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;

    public LivroDTO(Livro livro) {
        isbn = livro.getIsbn();
        titulo = livro.getTitulo();
        edicao = livro.getEdicao();
        autor = livro.getAutor();
    }

    public static List<LivroDTO> converter(List<Livro> livros) {
        return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
