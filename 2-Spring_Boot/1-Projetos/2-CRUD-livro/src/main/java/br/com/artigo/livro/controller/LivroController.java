package br.com.artigo.livro.controller;


import br.com.artigo.livro.controller.dto.AtualizaLivroFormDTO;
import br.com.artigo.livro.controller.dto.DetalhesLivroDTO;
import br.com.artigo.livro.controller.dto.LivroDTO;
import br.com.artigo.livro.controller.dto.LivroFormDTO;
import br.com.artigo.livro.entity.Livro;
import br.com.artigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController    //para o Spring encontrar a classe e fazer o gerenciamento para que ela receba requisições e envie a resposta ao usuário.
//To do método temos que anotar com @ResponseBody para indicar  ao Spring que nosso método não vai retornar uma página no response.
//
//Pensando em facilitar e eliminar anotações recorrentes, o Spring disponibiliza a anotação @RestController . Está anotação é uma contém as anotações @Controller e @ResponseBody em sua definição. Com isso,
// ao anotarmos nossa classe com @RestController já estamos declarando para o Spring que nossa classe é um controller e que todos os seus métodos retornam um objeto. (automaticamente serializado em JSON no Java).
@RequestMapping("/livros") //Para dizer qual é o endereço que o Spring vai chamar o nossos métodos listar, utilizamos a anotação @RequestMapping.
public class LivroController {

    @Autowired//No Spring, para marcar os pontos de injeção dentro da sua classe, você utiliza a anotação @Autowired.
    //Com esta anotação deixamos to do o trabalho de instanciar um objeto com o Spring. O framework puxa a responsabilidade e de alguma forma (interna) devolve a instância do nosso repositório.
    //Não é apenas dar um “new”, até porque nosso LivroRepository é uma interface, não temos uma classe que implementa. Não temos lógica de negócio de banco
    private LivroRepository livroRepository;



    //@ResponseBody //Como não queremos retornar uma página para o navegador, precisamos utilizar a anotação @ResponseBody. Ela é responsável por informa nosso @Controller que o objeto retornado é serializado automaticamente em JSON e passado de volta para o objeto HttpResponse.
    @GetMapping
    public List<LivroDTO> listar(){

        List<Livro> livros = livroRepository.findAll();
        return LivroDTO.converter(livros);


    }


    //@ResponseBody
    @Transactional //é usada para definir os requisitos da transação
    @PostMapping
    public LivroDTO salvar(@RequestBody LivroFormDTO form) { // recebe um livro como parametro para inserir na base de dados -- o request body para que forneca um objeto de dominio, permitindo a desserializacao automatica do objeto de entrada  em um objeto java, No caso, vamos receber um objeto JSON que reflete nossa entidade e desserializar para a entidade Livro (parâmetro de entrada do  métod
        Livro livro = form.converter();
        livroRepository.save(livro);
        return new LivroDTO(livro);
       // livroRepository.save(livro); //chamamos o méto do save() que recebe nossa entidade (livro) como parâmetro e trata toda a lógica de negócio para persistir no banco. parque em que estava fazendo sem a classe DTO

    }




    //@ResponseBodyg
    @Transactional
    @PutMapping("/{isbn}")
    public DetalhesLivroDTO atualizar(@PathVariable Long isbn, @RequestBody AtualizaLivroFormDTO form) {

        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if(optLivro.isPresent()){

            Livro livro = optLivro.get();
            form.atualiza(livro);
            livroRepository.save(livro);
            return new DetalhesLivroDTO(livro);
        }

        System.out.println("Livro não encontrado");
        return null;
    }





    //@ResponseBody
    @Transactional
    @DeleteMapping("/{isbn}")
    public void deletar(@PathVariable Long isbn){ //Na ação de deletar, a boa prática é passar a variável que representa nosso registro como parte da URL e não como um parâmetro da requisição. Portanto, utilizaremos a anotação PathVariabler

        final Optional<Livro> optLivro = livroRepository.findById(isbn);

        if (optLivro.isPresent()) {
            livroRepository.deleteById(isbn);
        }


    }




}
