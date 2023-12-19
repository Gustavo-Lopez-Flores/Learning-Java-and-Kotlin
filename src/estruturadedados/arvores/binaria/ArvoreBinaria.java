package estruturadedados.arvores.binaria;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNo<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }

        return atual;
    }

    public void exibirEmOrdem(){
        System.out.println("Exibindo Em Ordem");
        exibirEmOrdem(this.raiz);
    }

    public void exibirPosOrdem(){
        System.out.println("Exibindo Pos Ordem");
        exibirPosOrdem(this.raiz);
    }

    public void exibirPreOrdem(){
        System.out.println("Exibindo Pre Ordem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual) {
        if(atual != null){
            System.out.println(atual.getConteudo() + ", ");
            exibirEmOrdem(atual.getNoEsq());
            exibirEmOrdem(atual.getNoDir());
        }
    }

    private void exibirPosOrdem(BinNo<T> atual) {
        if(atual != null){
            exibirEmOrdem(atual.getNoEsq());
            exibirEmOrdem(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

    private void exibirEmOrdem(BinNo<T> atual) {
        if(atual != null){
            exibirEmOrdem(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirEmOrdem(atual.getNoDir());
        }
    }
}
