package edu.merlos.anatomia_classes;
public class MinhaClasse { //classes as primeiras letras em maiusculo
    
    public static void main(String[] args) { // void quer dizer que so ira executar, nao ira me retornar nada
            //System.out.print ("Vida Longa!");

            String primeiroNome = "Jose";
            String segundoNome  = "Merlos";

            String nomeCompleto = nomeCompleto(primeiroNome, segundoNome); // utilizando metodo criado abaixo fora da main

            System.out.print (nomeCompleto);



                int idade = 23;
                double altura = 1.62;
             


    } 



    public static String nomeCompleto (String primeiroNome, String segundoNome){ // mais uma classe alem da main - espera um retorno
        return "Resultado do Método: " + primeiroNome.concat(" ").concat(segundoNome);


    }


}
