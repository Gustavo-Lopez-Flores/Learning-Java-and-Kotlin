package estruturadedados.filas;

public class FilaGenerica<T> { // no momento em que instanciarmos a classe iremos especificar que tipo de dados ela irá comportar (para enfileirar) 
    private NoFilaGenerica<T> refNoEntradaFila;

    public FilaGenerica(){
        this.refNoEntradaFila = null;   
    }

    /* 
    public void enqueue(NoFila novoNo){
        novoNo.setRefNoFila(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }
    */

    // Enqueue refatorado para embutir o nó
    public void enqueue(T obj){
        // O que faziamos no Main vamos fazer aqui
        NoFilaGenerica novoNo = new NoFilaGenerica(obj); // vamos embutir o nó na classe Fila
        novoNo.setRefNoFila(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    /*
    public NoFila first(){
        if(!isEmpty()){
            NoFila primeiroNo = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNoFila() != null){
                    primeiroNo = primeiroNo.getRefNoFila();
                }else{
                    break;
                }
            }
            return primeiroNo;
        }
        return null;
    }
    */

    // First refatorado para retornar o object ao invés de retornar o primeiro nó
    public T first(){
        if(!isEmpty()){
            NoFilaGenerica primeiroNo = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNoFila() != null){
                    primeiroNo = primeiroNo.getRefNoFila();
                }else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    /*
    public NoFila dequeue(){
        if(!isEmpty()){
            NoFila primeiroNo = refNoEntradaFila;
            NoFila noAuxiliar = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNoFila() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNoFila();
                }else{
                    noAuxiliar.setRefNoFila(null);
                    break;
                }
            }
            return primeiroNo;
        }
        return null;
    }
    */

    // Dequeue refatorado para retornar o object ao invés de retornar o primeiro nó
    public T dequeue(){
        if(!isEmpty()){
            NoFilaGenerica primeiroNo = refNoEntradaFila;
            NoFilaGenerica noAuxiliar = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNoFila() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNoFila();
                }else{
                    noAuxiliar.setRefNoFila(null);
                    break;
                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString(){
        String stringRetorno = "";
        NoFilaGenerica noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if(noAuxiliar.getRefNoFila() != null){
                    noAuxiliar = noAuxiliar.getRefNoFila();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            stringRetorno = "null";
        }

        return stringRetorno;
    }
}
