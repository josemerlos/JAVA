package br.com.artigo.livro.controller.dto;

import br.com.artigo.livro.entity.Categoria;
import br.com.artigo.livro.entity.Livro;
import br.com.artigo.livro.entity.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LivroFormDTO {

    private Long isbn;
    private String titulo;
    private Integer edicao;
    private String autor;
    private String categoria;
    private String modelo;

    public Livro converter() {
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro.setAutor(autor);
        livro.setCategoria(Categoria.valueOf(categoria));
        livro.setEdicao(edicao);
        livro.setModelo(Modelo.valueOf(modelo));
        livro.setTitulo(titulo);
        return livro;
    }
}
