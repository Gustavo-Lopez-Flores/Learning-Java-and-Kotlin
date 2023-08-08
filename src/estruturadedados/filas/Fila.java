package estruturadedados.filas;

public class Fila {
    private NoFila refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;   
    }

    /* 
    public void enqueue(NoFila novoNo){
        novoNo.setRefNoFila(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }
    */

    // Enqueue refatorado para embutir o nó
    public void enqueue(Object obj){
        // O que fazíamos no Main vamos fazer aqui
        NoFila novoNo = new NoFila(obj); // vamos embutir o nó na classe Fila
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
    public Object first(){
        if(!isEmpty()){
            NoFila primeiroNo = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNoFila() != null){
                    primeiroNo = primeiroNo.getRefNoFila();
                }else{
                    break;
                }
            }
            return primeiroNo.getObject();
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
    public Object dequeue(){
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
            return primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString(){
        String stringRetorno = "";
        NoFila noAuxiliar = refNoEntradaFila;

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
