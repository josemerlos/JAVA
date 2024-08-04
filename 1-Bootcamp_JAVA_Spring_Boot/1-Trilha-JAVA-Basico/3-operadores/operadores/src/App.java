public class App {
    public static void main(String[] args) throws Exception {


        //O operador de atribuição é utilizado para definir o valor inicial ou sobrescrever o valor de uma variável. em Java, definimos um tipo, nome e 
        //opcionalmente atribuímos um valor à variável através do operador de atribuição. Exemplos abaixo:

            String nome = "GLEYSON";
            int idade = 22;
            double peso = 68.5;
            char sexo = 'M';
            boolean doadorOrgao = false;
           // Date dataNascimento = new Date();





            double soma = 10.5 + 15.7;
            int subtração = 113 - 25;
            int multiplicacao = 20 * 7;
            int divisao = 15 / 3;
            int modulo = 18 % 3;
            double resultado = (10 * 7) + (20/4);



            String nomeCompleto = "LINGUAGEM" + "JAVA";
		
            //qual o resultado das expressoes abaixo? O operador de adição (+), quando utilizado em variáveis do tipo texto, realizará a “concatenação de textos”.
            String concatenacao ="?"; 

      

            concatenacao = 1+1+1+"1";

            System.out.println(concatenacao);

            concatenacao = 1+"1"+1+1;

            System.out.println(concatenacao);

            concatenacao = 1+"1"+1+"1";

            System.out.println(concatenacao);

            concatenacao = "1"+1+1+1;

            System.out.println(concatenacao);

            concatenacao = "1"+(1+1+1);

            System.out.println(concatenacao);



            System.out.println(concatenacao);




               //Esses operadores, são aplicados juntamente com um outro operador aritmético. Eles realizam alguns trabalhos básicos como incrementar, decrementar, inverter valores numéricos e booleanos.
                int numero = 5;

                //Muito cuidado com ordem de precedência, dos operadores unários!
                //Imprimindo o numero negativo
                System.out.println(- numero);

                //incrementando numero em mais 1 numero, imprime 6
                numero ++;
                System.out.println(numero);

                //incrementando numero em mais 1 numero, imprime 7
                System.out.println(numero ++);// ops algo de errado não está certo

                System.out.println(numero);// agora sim, numero virou 7

                //ordem de precedencia conta aqui
                System.out.println(++ numero);

                boolean verdadeiro = true;

                System.out.println("Inverteu " + !verdadeiro);










                  // Operador Ternário
                    int a, b;
        

                    a = 5;
                    b = 6;

                    /* EXEMPLO DE CONDICIONAL UTILIZANDO UMA ESTRUTURA IF/ELSE
                    if(a==b)
                    resultado = "verdadeiro";
                    else
                    resultado = "falso";
                    */

                    //MESMA CONDICIONAL, MAS DESSA VEZ, UTILIZANDO O OPERADOR CONDICIONAL TERNÁRIO
                    String resultadoTernario = (a==b) ? "verdadeiro" : "false";

                    System.out.println(resultadoTernario);





      
    }
}
