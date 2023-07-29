package tipos;

public class Logicos {
    public static void main(String[] args) {
        
        /* Operador Ternário
         * int n = 1 > 0 ? 2: 3;
         */

        /* Operadores Relacionais
         * >  | Maior que | 5 > 2 | true
         * <  | Menor que | 1 < 3 | true
         * >= | Maior ou igual a | 5 >= 2 | true
         * <= | Menor ou igual a | 3 >= 2 | true
         * == |  Igual a | 5 == 5 | true
         * != | Diferent | 1 != 2 | true
         */

         // Objetos instanciados usados 
         // a clausula NEW estruturalmente 
         // não são iguais àqueles apenas 
         // declarados, vide exemplo abaixo:
         String nome1 = "Gustavo";
         String nome2 = "Gustavo";
         String nome3 = new String("Gustavo");
         if(nome1 == nome2){ // true
            System.out.println("nome 1 = nome2");
         }
         if(nome1 == nome3){ // false
            System.out.println("nome1 = nome3");
         }
         if(nome1.equals(nome3)){ // true
            System.out.println("nome 1 = nome3");
         }

         /* Operadores Lógicos
          * &&  |   E  | true && false | false 
          * ||  |   OU | true || false | true
          * ^   |  XOU |   true ^ true | false
          * !   |  NAO |     !false    | true
          */
    }
}
