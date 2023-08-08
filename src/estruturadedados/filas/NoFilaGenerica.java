package estruturadedados.filas;

public class NoFilaGenerica<T> { // colocamos o Wildcard
    private T object; // Não temos mais um objeto, estamos amarrando ou seja o tipo genérico
    private NoFilaGenerica<T> refNoFila;

    public NoFilaGenerica(){
    }

    public NoFilaGenerica(T object){
        this.refNoFila = null;
        this.object = object;
    }

    public T getObject(){
        return object;
    }

    public void setObject(T object){
        this.object = object;
    }

    public NoFilaGenerica getRefNoFila(){
        return refNoFila;
    }

    public void setRefNoFila(NoFilaGenerica refNoFila){
        this.refNoFila = refNoFila;
    }

    @Override
    public String toString(){
        return "No{" +
        "object=" + object +
        '}';
    }
}
