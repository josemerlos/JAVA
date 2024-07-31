public class App {
    public static void main(String[] args) throws Exception {


        byte idade = 123;
		short ano = 2021;
		int cep = 21070333; // se começar com zero, talvez tenha que ser outro tipo
		long cpf = 98765432109L; // se começar com zero, talvez tenha que ser outro tipo
		float pi = 3.14F;
		double salario = 1275.33;
        String meuNome = "Jose Merlos";




        //cuidado ao fazer isso com variaveis de precisao maior para menor. Java e fortemente tipado
        short numeroCurto = 1;
        int numeroNormal = numeroCurto;
       // short numeroCurto2 = numeroNormal;  //cuidado ao fazer isso com variaveis de precisao maior para menor. Java e fortemente tipado
       short numeroCurto2 = (short) numeroNormal; // poderia fazer assim - cast para tipo especifico







        		/*
		 * esta linha é considerada como declaração de variável iniciamos a existência
		 * variavel numero com valor 5 regra: tipo + nome + valor
		 */
		int numero = 5;

		/*
		 * na linha abaixo iremos alterar o valor do varíavel para 10 observe que o tipo
		 * não é mais necessário, pois a variável já foi declarada anteriormente
		 */
		numero = 10;

		System.out.print(numero);
		
		/*
		 * ao usar a palavra reservada final, você determina que jamais
		 * esta variavel poderá obter outro valor;
		 * logo a linha 25 vai apresentar um erro de compilação
		 * isso é considerado uma CONSTANTE na linguagem Java
		 */
		final double VALOR_DE_PI = 3.14;
		
		//VALOR_DE_PI=3.15; //Esta linha vai apresentar erro de compilação!













        System.out.println("Hello, World!");
    }
}
