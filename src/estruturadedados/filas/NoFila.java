package estruturadedados.filas;

public class NoFila {
    private Object object; // Objeto da java lang que engloba todos os objetos (herdam dele)
    private NoFila refNoFila;

    public NoFila(){
    }

    public NoFila(Object object){
        this.refNoFila = null;
        this.object = object;
    }

    public Object getObject(){
        return object;
    }

    public void setObject(Object object){
        this.object = object;
    }

    public NoFila getRefNoFila(){
        return refNoFila;
    }

    public void setRefNoFila(NoFila refNoFila){
        this.refNoFila = refNoFila;
    }

    @Override
    public String toString(){
        return "No{" +
        "object=" + object +
        '}';
    }
}