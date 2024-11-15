package br.com.artigo.livro.controller;


import br.com.artigo.livro.entity.Categoria;
import br.com.artigo.livro.entity.Livro;
import br.com.artigo.livro.entity.Modelo;
import br.com.artigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller    //@Controller para o Spring encontrar a classe e fazer o gerenciamento para que ela receba requisições e envie a resposta ao usuário.
public class LivroController {

    @Autowired//No Spring, para marcar os pontos de injeção dentro da sua classe, você utiliza a anotação @Autowired.
    //Com esta anotação deixamos to do o trabalho de instanciar um objeto com o Spring. O framework puxa a responsabilidade e de alguma forma (interna) devolve a instância do nosso repositório.
    //Não é apenas dar um “new”, até porque nosso LivroRepository é uma interface, não temos uma classe que implementa. Não temos lógica de negócio de banco
    private LivroRepository livroRepository;



    @ResponseBody //Como não queremos retornar uma página para o navegador, precisamos utilizar a anotação @ResponseBody. Ela é responsável por informa nosso @Controller que o objeto retornado é serializado automaticamente em JSON e passado de volta para o objeto HttpResponse.
    @RequestMapping("/livros") //Para dizer qual é o endereço que o Spring vai chamar o nosso méto do listar, utilizamos a anotação @RequestMapping. Ela informa o Spring que o endereço /livros for chamado, o nosso métod o listar deve ser executado.
    public List<Livro> listar(){

        List<Livro> livros = livroRepository.findAll();
        return livros;


    }


    @ResponseBody
    @Transactional //é usada para definir os requisitos da transação
    @RequestMapping(path = "/livros", method = RequestMethod.POST)
    public void salvar(@RequestBody Livro livro) { // recebe um livro como parametro para inserir na base de dados -- o request body para que forneca um objeto de dominio, permitindo a desserializacao automatica do objeto de entrada  em um objeto java, No caso, vamos receber um objeto JSON que reflete nossa entidade e desserializar para a entidade Livro (parâmetro de entrada do  métod
        livroRepository.save(livro); //chamamos o méto do save() que recebe nossa entidade (livro) como parâmetro e trata toda a lógica de negócio para persistir no banco.

    }



    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Livro livro) {
        livroRepository.save(livro);
    }


    @ResponseBody
    @Transactional
    @RequestMapping(path = "/livros/{isbn}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Long isbn){ //Na ação de deletar, a boa prática é passar a variável que representa nosso registro como parte da URL e não como um parâmetro da requisição. Portanto, utilizaremos a anotação PathVariabler

        livroRepository.deleteById(isbn);

    }




}
