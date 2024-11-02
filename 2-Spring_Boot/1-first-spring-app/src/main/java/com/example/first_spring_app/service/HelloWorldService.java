package com.example.first_spring_app.service;
import org.springframework.stereotype.Service;

//services - geralmente existem as regras de negocio da nossa aplicacao. Controllers recebem as requisicoes e processam as regras no service



@Service
public class HelloWorldService {

    public String helloWorld(String name){
        return "Hello World!" + name;
    }


}
