package tipos;

import java.util.Scanner;

public class Aritmeticos {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        /*  Operadores Aritmeticos
         *  + Adição
         *  - Subtração
         *  * Multiplicação
         *  / Divisão
         *  % Resto da Divisão
        */

        /* Incremento
         * ++num Pré Incremento
         * num++ Pós Incremento
        */

        /* Operadores de Atribuição
         * += Somar e Atribuir
         * -= Subtrair e Atribuir
         * *= Multiplicar e Atribuir
         * /= Dividir e Atribuir
         * %= Resto e Atribuir
        */

        /* CLASSE MATH 
         * PI   |   Constante   |    Math.PI    | 3.1415 
         * pow  | Exponenciação | Math.pow(5,2) | 25
         * sqrt | Raíz Quadrada | Math.sqrt(25) | 5
         * cbrt |  Raíz Cúbica  | Math.cbrt(27) | 3
        */

        /* ARREDONDAMENTOS
         * abs   |    Valor Absoluto    |  Math.abs(-10) | 10
         * floor | Arredonda para Baixo | Math.floor(3.9)| 3
         * ceil  | Arredonda para Cima  | Math.ceil(4.2) | 5
         * round |    Aritmeticamente   | Math.round(5.6)| 6
         */

        /* Gerador de Numeros
         * Math.random() 
         * Double - Valores entre 0 e 1
         * Ex: Double ale = Math.random()
         * Int - Valores entre 5 a 10
         * Ex: int n = (int) (5 + ale * (10-5))
         * Int - Valores entre 15 a 50
         * Ex: int n = (int) (15 + ale * (50-15))
        */

        int n = ler.nextInt();
        System.out.println(n);
        ler.close();
    }
}
