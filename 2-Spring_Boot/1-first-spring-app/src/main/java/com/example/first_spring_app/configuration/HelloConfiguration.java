package com.example.first_spring_app.configuration;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//classes de configuracao indica para o spring que preciso usar essa classe como base para configuracoes. Dessa forma defino metodos publicos para realizar injecao de dependencias externas, se nao o Autowired nao ira entender no projeto



@Configuration
public class HelloConfiguration {

    //@Bean // anotacao que indica para o spring que deve gerenciar o metodo como um bean na minha aplicacao. Criar instancias de classe que nao podem ser gerenciadas pelo spring - Mapeia os metodos para o projeto
    //public SDKAWS sdkAWS() {
    //    return new SDKAWS();
   // }
}