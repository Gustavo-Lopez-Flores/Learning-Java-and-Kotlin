package tipos;

import java.util.Scanner;

public class TiposPrimitivos {
    public static void main(String args[]){
        // Declaração em Java

        // INT
        int numeroUm = 1; // variavel
        int numeroDois = (int) 2; // variavel - typecasting
        // Integer numeroTres = new Integer(3); // objeto - wrapper class / Declaracao Depreciada a partir do JAVA 9
        // System.out.println(numeroUm + numeroDois + numeroTres);
        System.out.println(numeroUm + numeroDois);

        // FLOAT
        float salarioUm = 1825.54f; // variavel
        float salarioDois = (float) 1825.54; // variavel - typecasting
        // Float salarioTres = new Float(1825.54); // objeto - wrapper class / Declaracao Depreciada a partir do JAVA 9
        // System.out.println(salarioUm + salarioDois + salarioTres);
        System.out.println(salarioUm + salarioDois);

        // CHAR
        char letraA = 'A'; // variavel
        char letraB = (char) 'B'; // variavel - typecasting
        // Character letraC = new Character('C'); // objeto - wrapper class / Declaracao Depreciada a partir do JAVA 9
        // System.out.println(letraA + " " + letraB + " " + letraC);
        System.out.println(letraA + " " + letraB);

        // BOOLEAN
        boolean logicoUm = true; // variavel
        boolean logicoDois = (boolean) true; // variavel - typecasting
        // Boolean logicoTres = new Boolean(true); // objeto - wrapper class / Declaracao Depreciada a partir do JAVA 9
        System.out.println(logicoUm + " " + logicoDois);

        /*  FAMÍLIA | TIPO PRIMITIVO | CLASSE INVÓLUCRO |   TAMANHO   |    EXEMPLO   |
         * ---------------------------------------------------------------------------
         *   Lógico |     boolean    |      Boolean     |    1 bit    |     true     |
         * ---------------------------------------------------------------------------
         * Literais |      char      |     Character    |    1 byte   |     'A'      |
         *          |        -       |      String      | 1 byte/cada |    "JAVA"    |
         * ---------------------------------------------------------------------------
         * Inteiros |      byte      |       Byte       |    1 byte   |     127      |    
         *          |      short     |       Short      |    2 bytes  |    32 767    |
         *          |       int      |      Integer     |    4 bytes  |   2 147 483  |
         *          |      long      |       Long       |    8 bytes  |    2 ^ 63    |
         * ---------------------------------------------------------------------------
         *   Reais  |      float     |       Float      |    4 bytes  |  3.4 e ^ +38 |  
         *          |      double    |       Double     |    8 bytes  | 1.8 e ^ +308 |  
         * ---------------------------------------------------------------------------   
        */
        
        // SAIDAS
        float nota = 9.5f;
        System.out.print("Sua nota eh " + nota + " ");
        System.out.println("Sua nota eh " + nota);
        System.out.printf("Sua nota eh %.3f \n", nota);
        System.out.format("Sua nota eh %.4f %n", nota);

        // ENTRADA
        Scanner ler = new Scanner(System.in);
        String nome = ler.nextLine();
        System.out.println(nome);
        
        // TIPAGEM
        int idade = 30;
        // gracas a Classe Involucro eh possivel fazer conversao (Wrapper Classes)
        String valor = Integer.toString(idade); 
        System.out.println(valor);

        String anos = "100";
        // gracas a Classe Involucro eh possivel fazer conversao (Wrapper Classes)
        int tempo = Integer.parseInt(anos); // valor parsiado/convertido pra Inteiro
        System.out.println(tempo);

        String altura = "1.75";
        // gracas a Classe Involucro eh possivel fazer conversao (Wrapper Classes)
        float metros = Float.parseFloat(altura); // valor parsiado/convertido pra Inteiro
        System.out.println(metros);

        ler.close();
    }
}