package estruturadedados.listas.encadeadas;

public class NoListaEncadeada<T> {
    private T conteudo;
    private NoListaEncadeada proximoNoListaEncadeada;

    // construtor vazio
    public NoListaEncadeada(){
        this.proximoNoListaEncadeada = null;
    }

    // construtor passando só o conteúdo
    public NoListaEncadeada(T conteudo){
        this.proximoNoListaEncadeada = null;
        this.conteudo = conteudo;
    }

    // construtor passando os dois parâmetros da classe nó
    public NoListaEncadeada(T conteudo, NoListaEncadeada prNoListaEncadeada){
        this.conteudo = conteudo;
        this.proximoNoListaEncadeada = proximoNoListaEncadeada;
    }

    // getters e setters
    public T getConteudo(){
        return conteudo;
    }

    public void setConteudo(T conteudo){
        this.conteudo = conteudo;
    }

    public NoListaEncadeada getProximoNoListaEncadeada(){
        return proximoNoListaEncadeada;
    }

    public void setProximoNoListaEncadeada(NoListaEncadeada proximoNoListaEncadeada){
        this.proximoNoListaEncadeada = proximoNoListaEncadeada;
    }

    // vai ter só o conteúdo
    @Override
    public String toString(){
        return conteudo.toString();
    }

    // toString personalizado
    public String toStringEncadeado(){
        String str = "No{" +
                     "conteudo=" + conteudo +
                     '}';

        if(proximoNoListaEncadeada != null){
            str += "->" + proximoNoListaEncadeada.toString();
        }else{
            str += "->null";
        }

        return str;
    }
}
