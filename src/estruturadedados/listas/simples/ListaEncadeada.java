package estruturadedados.listas.simples;

public class ListaEncadeada<T> {
    NoListaEncadeada<T> referenciaEntrada;

    public ListaEncadeada(){
        this.referenciaEntrada = null;
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true: false;
    }

    public void add(T conteudo){
        NoListaEncadeada<T> novoNo = new NoListaEncadeada<>(conteudo);
        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        NoListaEncadeada<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNoListaEncadeada();
        }

        noAuxiliar.setProximoNoListaEncadeada(novoNo);
    }

    // retorna conteudo
    public T get(int index){
        return getNo(index).getConteudo();
    }

    // retorna nó, por ser um método interno da classo é melhor deixarmos como private
    private NoListaEncadeada<T> getNo(int index){
        validaIndice(index);
        
        NoListaEncadeada<T> noAuxiliar = referenciaEntrada;
        NoListaEncadeada<T> noRetorno = null;

        for(int i = 0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNoListaEncadeada();
        }

        return noRetorno;
    }

    public T remove(int index){
        NoListaEncadeada<T> noPivor = this.getNo(index);
        if(index == 0){
            referenciaEntrada = noPivor.getProximoNoListaEncadeada();
            return noPivor.getConteudo();
        }

        NoListaEncadeada<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNoListaEncadeada(noPivor.getProximoNoListaEncadeada());
        return noPivor.getConteudo();
    }

    public int size(){
        int tamanhoLista = 0;
        NoListaEncadeada<T> referenciaAux = referenciaEntrada;

        while(true){
            if(referenciaAux != null){
                tamanhoLista++;
                if(referenciaAux.getProximoNoListaEncadeada() != null){
                    referenciaAux = referenciaAux.getProximoNoListaEncadeada();
                }else{
                    break;
                }
            }else{
                break;
            }
        }

        return tamanhoLista;
    }

    public void validaIndice(int index){
        // para garantir que haja o índice na lista
        if(index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista. Esta lista só vai até o índice " + ultimoIndice + ".");
        }
    }

    @Override
    public String toString(){
        String strRetorno = "";
        NoListaEncadeada<T> noAuxiliar = referenciaEntrada;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar +"}]--->";
            noAuxiliar = noAuxiliar.getProximoNoListaEncadeada();
        }

        strRetorno += "null";
        return strRetorno; 
    }
}
