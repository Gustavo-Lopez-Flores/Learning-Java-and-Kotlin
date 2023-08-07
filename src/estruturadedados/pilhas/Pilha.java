package estruturadedados.pilhas;

public class Pilha {
    private NoPilha refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    public void push(NoPilha novoNo){
        NoPilha refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public NoPilha pop(){
        if(!this.isEmpty()){
            NoPilha noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public NoPilha top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        if(refNoEntradaPilha == null){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String stringRetorno = "------------\n";
        stringRetorno += "     Pilha\n";
        stringRetorno += "------------\n";

        NoPilha noAuxiliar = refNoEntradaPilha;
        while(true){
            if(noAuxiliar != null){
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar.getRefNo();
            }else{
                break;
            }
        }

        stringRetorno += "============\n";
        return stringRetorno;
    }
}
