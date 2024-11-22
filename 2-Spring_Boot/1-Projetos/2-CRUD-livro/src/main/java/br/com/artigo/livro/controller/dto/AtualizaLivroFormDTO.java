package br.com.artigo.livro.controller.dto;

import br.com.artigo.livro.entity.Categoria;
import br.com.artigo.livro.entity.Livro;
import br.com.artigo.livro.entity.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtualizaLivroFormDTO {

    private String categoria;
    private String modelo;

    public void atualiza(Livro livro) {
        livro.setCategoria(Categoria.valueOf(categoria));
        livro.setModelo(Modelo.valueOf(modelo));
    }
}