package estruturadedados.filas;

public class MainFila {
    public static void main(String[] args){
        Fila minhaFila = new Fila();

        // No método enqueue não estamos recebendo uma string, estamos recebendo um nó contendo uma string
        minhaFila.enqueue(new NoFila("primeiro"));
        minhaFila.enqueue(new NoFila("segundo"));
        minhaFila.enqueue(new NoFila("terceiro"));
        minhaFila.enqueue(new NoFila("quarto"));

        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());//

        System.out.println(minhaFila);

        minhaFila.enqueue(new NoFila("ultimo"));

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());

        System.out.println(minhaFila);
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