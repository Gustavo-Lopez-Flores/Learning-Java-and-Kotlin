package estruturadedados.listas.encadeadas;

public class MainListaEncadeada {
    public static void main(String[] args){
        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();
        
        minhaListaEncadeada.add("teste1");
        minhaListaEncadeada.add("teste2");
        minhaListaEncadeada.add("teste3");
        minhaListaEncadeada.add("teste4");
        minhaListaEncadeada.add("teste5");

        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));
        System.out.println(minhaListaEncadeada.get(4));

        System.out.println(minhaListaEncadeada);

        System.out.println(minhaListaEncadeada.remove(3));

        System.out.println(minhaListaEncadeada);
    }
}
/* Lista Encadeada
 * Pode adicionar e remover os elementos no índice de sua preferência
 * 
 * Estrutura:
 * (ref. nó) -> [(object()) (ref.no)] -> [(object()) (ref.no)] -> [(object()) (ref.no)] -> null
 * 
 * Métodos:
 * - Add
 * - Remove   
 * - Is Empty
 * - Get (conteúdo)
 * - GetNo (nó)
 * - Size
 * - Valida índice
 */