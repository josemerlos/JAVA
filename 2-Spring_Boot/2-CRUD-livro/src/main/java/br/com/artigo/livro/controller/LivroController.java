package br.com.artigo.livro.controller;


import br.com.artigo.livro.entity.Categoria;
import br.com.artigo.livro.entity.Livro;
import br.com.artigo.livro.entity.Modelo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller    //@Controller para o Spring encontrar a classe e fazer o gerenciamento para que ela receba requisições e envie a resposta ao usuário.
public class LivroController {

    @ResponseBody //Como não queremos retornar uma página para o navegador, precisamos utilizar a anotação @ResponseBody. Ela é responsável por informa nosso @Controller que o objeto retornado é serializado automaticamente em JSON e passado de volta para o objeto HttpResponse.
    @RequestMapping("/livros") //Para dizer qual é o endereço que o Spring vai chamar o nosso método listar, utilizamos a anotação @RequestMapping. Ela informa o Spring que o endereço /livros for chamado, o nosso método listar deve ser executado.
    public List<Livro> listar(){

        Livro livro = new Livro(123L, "Controller - Spring", 1, "Vitor", Categoria.INFORMATICA, Modelo.EBOOK);

        return Arrays.asList(livro, livro, livro);


    }

}
