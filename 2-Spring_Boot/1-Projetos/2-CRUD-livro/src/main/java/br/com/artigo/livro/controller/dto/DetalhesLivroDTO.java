package br.com.artigo.livro.controller.dto;

import br.com.artigo.livro.entity.Livro;
import lombok.Getter;

@Getter
public class DetalhesLivroDTO {

    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    private String categoria;
    private String modelo;


    public DetalhesLivroDTO(Livro livro) {
        isbn = livro.getIsbn();
        titulo = livro.getTitulo();
        edicao = livro.getEdicao();
        autor = livro.getAutor();
        categoria = livro.getCategoria().name();
        modelo = livro.getModelo().name();
    }
}