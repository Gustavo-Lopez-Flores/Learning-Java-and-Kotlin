package noeencadeamento;

public class NoComGenerics<T> {
    private T conteudo;
    private NoComGenerics<T> proximoNo;

    public NoComGenerics(T conteudo){
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo(){
        return conteudo;
    }    

    public void setConteudo(T conteudo){
        this.conteudo = conteudo;
    }


    public NoComGenerics<T> getProximoNo(){
        return proximoNo;
    }

    public void setProximoNo(NoComGenerics<T> proximoNo){
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString(){
        return conteudo.toString();
    }
}

/* GENERICS
 * 
 * Lista<String> minhaLista = new Lista<>();
 * 
 * public class Lista<T>{
 *      private T t;
 * }
 * 
 * Contexto Generics:
 * - Evita Casting Excessivo
 * - Evita Código Redundante
 * - Encontrar erros em tempo de compilação pois na Lista de exemplo acima
 *   especificamos que só aceita Strings com o recurso de Generics
 * 
 * Wildcards (Coringas) : -> Antes de explicar como funciona o Generics é preciso saber
 * - Unknown Wildcards (Unbounded) -> Ilimitado
 * - Unbounded Wildcard (Upper Bounded / Lower Bounded)
 * 
 * Unknown Wildcards:
 * 
 * public void imprimeLista(List<?> lista){
 *      for(Object obj : lista){
 *          System.out.println(obj);
 *      }
 * }
 * 
 * List<Aluno> minhaLista = new List<Aluno>(); // declarando uma lista do tipo aluno
 * imprimeLista(minhaLista); // imprime desde que tenha o toString implementado senão veremos apenas a referencia
 * 
 * Unbounded Wildcard - Upper Bounded:
 * 
 * // "Um Coringa limitado por Cima"
 * // Só é possível passar listas de pessoas e descendentes(herdeiros de pessoas)
 * // Ex: Aluno extends Pessoa, ele irá aceitar
 * 
 * public void imprimeLista(List<? extends Pessoa> listaPessoas){
 *      for(Pessoa p : listaPessoas){
 *          System.out.println(p);
 *      }
 * }
 * 
 * List<Aluno> minhaLista = new List<Aluno>(); // declarando uma lista do tipo aluno
 * imprimeLista(minhaLista); // imprime desde que tenha o toString implementado senão veremos apenas a referencia
 *  
 * Unbounded Wildcard - Lower Bounded:
 * 
 * // "Um Coringa limitado por Baixo"
 * // Qualquer lista de herdeiro de Pessoa o método ele não vai aceitar
 * // Ex: Pessoa extends Cidadao, classe que pessoa herda é aceita
 * 
 * public void imprimeLista(List<? super Pessoa> listaPessoas){
 *      for(Pessoa p : listaPessoas){
 *          System.out.println(p);
 *      }
 * }
 * 
 * List<Aluno> minhaLista = new List<Aluno>(); // declarando uma lista do tipo aluno
 * imprimeLista(minhaLista); // imprime desde que tenha o toString implementado senão veremos apenas a referencia
 * 
 * Convenção de Caracteres de Wildcards:
 * 
 * K - para "Key", exemplo Map<K,V>
 * V - para "Value", exemplo Map<K,V>
 * E - para "Element", exemplo List<E>
 * T - para "Type", exemplo Collections#addAll
 * ? - quando genérico
 * 
 */