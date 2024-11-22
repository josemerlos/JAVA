package com.example.first_spring_app.controller;
import com.example.first_spring_app.domain.User;
import com.example.first_spring_app.service.HelloWorldService;
import org.springframework.web.bind.annotation.*;


// controller - classes que recebem requisicoes http. Nao precisa retornar resposta direta como json, pode tbm retornar uma pagina web html
//no caso sera uma api que ira lidar com as requisicoes e ira retornar respostas http com um response body

//existem apis STATEFULL - mantem o estado de cada cliente no servidor
//             STATELESS - a cada nova requisicao recebo todas as informacoes que eu preciso para fazer a funcionalidade que o cliente pediu

@RestController // rest controller que escuta todas as requisicoes do /helloworld
@RequestMapping("/hello-world") // Declarando um endpoint - esse controller escuta a todas as requisicoes que chegarem nesse endpoint
public class HelloWorldController {

        // nao estamos instanciando na mao nesse caso o service(new HelloWorld...)... so estou recebendo por parametro no contrutor, o spring que fez a injecao de dependencia
    //poderia colocar a nootacao @Autowired indicando que quero fazer inkecao de dependencia
        private HelloWorldService helloWorldService;


        public HelloWorldController(HelloWorldService helloWorldService) { // construindo construtor para instanciar minha classe service - Instanciando meu service
            this.helloWorldService = helloWorldService; // que recebi por parametro
        }

    //metodo http abaixo pode responder no post, get, delete, pout, patch, options, head....
        @GetMapping //anotacao para o metodo. classe abaixo respondera ao metodo http het - Posso passar mais parametro de path
        public String helloWorld(){
            return helloWorldService.helloWorld(" Kipper");
         }


         @PostMapping ("/{id}")   // normal receber informacoes pelo body de um json na requisicao - adicionar novos dados
         public String helloWorldPost ( @PathVariable String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body){ // injetando no parametro tudo que vier no request body
               return "Hello World " + body.getName() + " " + id + " "  +filter;
         }


}
