package estruturadedados.filas;

public class MainFila {
    public static void main(String[] args){
        Fila minhaPrimeiraFila = new Fila();
        Fila minhaSegundaFila = new Fila();
        Fila minhaTerceiraFila = new Fila();
        Fila minhaQuartaFila = new Fila();
        Fila minhaQuintaFila = new Fila();

        // Sem refatoração para embutir o nó o método enqueue não estava 
        // recebendo uma string mas sim um nó contendo uma string
        
        minhaPrimeiraFila.enqueue(new NoFila("primeiro"));
        minhaPrimeiraFila.enqueue(new NoFila("segundo"));
        minhaPrimeiraFila.enqueue(new NoFila("terceiro"));
        minhaPrimeiraFila.enqueue(new NoFila("quarto"));
        System.out.println(minhaPrimeiraFila);

        /*
        System.out.println(minhaPrimeiraFila.dequeue()); // remove primeiro da fila
        System.out.println(minhaPrimeiraFila);
        minhaPrimeiraFila.enqueue(new NoFila("ultimo")); // adiciona no fim da fila
        System.out.println(minhaPrimeiraFila);
        System.out.println(minhaPrimeiraFila.first()); // mostra novo primeiro da fila
        System.out.println(minhaPrimeiraFila);
        */

        // Com a refatoração para embutir nó não passamos mais nós, passamos objetos, assim podemos: 
        // um nó dentro do nó -> se deixarmos como estava: minhaFila.enqueue(new NoFila("primeiro")) 
        
        // Colocar String na classe Fila
        minhaSegundaFila.enqueue("primeiro");
        minhaSegundaFila.enqueue("segundo");
        minhaSegundaFila.enqueue("terceiro");
        minhaSegundaFila.enqueue("quarto");
        System.out.println(minhaSegundaFila);

        // Colocar Inteiro na classe Fila
        minhaTerceiraFila.enqueue(1);
        minhaTerceiraFila.enqueue(2);
        minhaTerceiraFila.enqueue(3);
        minhaTerceiraFila.enqueue(4);
        System.out.println(minhaTerceiraFila);

        // Colocar Boolean na classe Fila
        minhaQuartaFila.enqueue(true);
        minhaQuartaFila.enqueue(false);
        minhaQuartaFila.enqueue(true);
        minhaQuartaFila.enqueue(false);
        System.out.println(minhaQuartaFila);

        // Podemos até misturar
        minhaQuintaFila.enqueue(1);
        minhaQuintaFila.enqueue("segundo");
        minhaQuintaFila.enqueue(true);
        System.out.println(minhaQuintaFila);

        // Misturar objetos não é uma boa prática, portanto faz-se necessário refatorá-la
        // Assim que declararmos a classe fila vamos amarrá-la a um só tipo usando Generics

        FilaGenerica<String> minhaFilaString = new FilaGenerica<>();
        minhaFilaString.enqueue("primeiro");
        minhaFilaString.enqueue("segundo");
        minhaFilaString.enqueue("terceiro");
        minhaFilaString.enqueue("quarto");
        System.out.println(minhaFilaString);
    }    
}
/* FIFO - First In First Out
 * O primeiro elemento que entra é o primeiro a sair
 * 
 * Exemplo:
 * (ref. nó) -> no3 -> no2 -> no1 -> null
 * OU
 * (ref. nó) -> [(object()) (ref.no)] -> [(object()) (ref.no)] -> [(object()) (ref.no)] -> null
 * 
 * Métodos de Manipulação de Fila
 * - Enqueue (Enfileirar)
 *   Adiciona no final
 *    
 * - Dequeue (Desenfileirar)
 *   Remove no início
 *      
 * - Is Empty
 *      
 */