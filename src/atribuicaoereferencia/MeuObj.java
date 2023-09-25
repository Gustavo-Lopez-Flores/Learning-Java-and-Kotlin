package atribuicaoereferencia;

public class MeuObj {

    Integer num;

    // Construtor
    public MeuObj(Integer num) {
        this.num = num;
    }

    // Setter
    public void setNum(Integer num){
        this.num = num;
    }

    // toString para facilitar a visualizacao (ira retornar o numero no system.out.println)
    @Override
    public String toString() {
        return this.num.toString();
    }    
}
