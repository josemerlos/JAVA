package com.example.first_spring_app.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller - classes que recebem requisicoes http. Nao precisa retornar resposta direta como json, pode tbm retornar uma pagina web html
//no caso sera uma api que ira lidar com as requisicoes e ira retornar respostas http com um response body

//existem apis STATEFULL - mantem o estado de cada cliente no servidor
//             STATELESS - a cada nova requisicao recebo todas as informacoes que eu preciso para fazer a funcionalidade que o cliente pediu

@RestController
@RequestMapping("/hello-world") // Declarando um endpoint - esse controller escuta a todas as requisicoes que chegarem nesse endpoint
public class HelloWorldController {

        public String helloWorld(){
            return "Hello World!";
         }

}
