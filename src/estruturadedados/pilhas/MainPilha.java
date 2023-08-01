package estruturadedados.pilhas;

public class MainPilha {
    public static void main(String[] args){
        Pilha minhaPilha = new Pilha();  
        NoPilha no1 = new NoPilha(1);
        NoPilha no2 = new NoPilha(2);
        NoPilha no3 = new NoPilha(3);

        minhaPilha.push(no1); // aceita apenas No de Inteiro
        minhaPilha.push(no2); // aceita apenas No de Inteiro
        minhaPilha.push(no3); // aceita apenas No de Inteiro

        System.out.println(minhaPilha);
    }
}

/* LIFO - Last in First out
 * O último elemento que entra é o primeiro a sair
 * 
 * Exemplo:
 * null <- no1 <- no2 <- no3 <- (ref. topo)
 * OU
 * null <- [(int) (ref.no)] <- [(int) (ref.no)] <- [(int) (ref.no)] <- (ref. topo)
 * 
 * Métodos de Manipulação de Pilha
 * - Top (pegar topo)
 *      Exemplo:
 *      No meuNo = pilha.top();
 *      No meuNo = [(int) (ref.no)] // container ilustrativo
 *      int numero = meuNo.getInt();
 *      int numero = [(int)] // container ilustrativo
 * 
 * - Pop (retira do topo)
 *      Exemplo:
 *      No meuNo = pilha.pop();
 *      No meuNo = [(int) (ref.no)] // container ilustrativo
 *      int numero = meuNo.getInt();
 *      int numero = [(int)] // container ilustrativo
 * 
 * - Push (insere no topo)
 *      Exemplo:
 *      No meuNo = new No();
 *      meuNo.setInt(1);
 *      meuNo -> novoTopo // ilustrativo
 * 
 * - isEmpty
 * public boolean isEmpty(){
 *      if(refNo == null){
 *          return true;
 *      }
 *      return false;
 * }
 * 
 */