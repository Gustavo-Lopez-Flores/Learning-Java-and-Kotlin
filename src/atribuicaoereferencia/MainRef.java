package estruturadedados.atribuicaoereferencia;

public class MainRef {
    public static void main(String[] args) {
        // Atribuições em Java são por cópia de valor SEMPRE

        // Em tipos primitivos copia-se o valor em memoria
        int a = 1;
        int b = a;
        System.out.println("A:" + a + " B:" + b);
        a = 2;
        System.out.println("A:" + a + " B:" + b);

        // Com objetos copiamos o valor da referencia em memoria, sem duplicar o objeto
        MeuObj objA = new MeuObj(1);        
        MeuObj objB = objA;
        System.out.println("A:" + objA + " B:" + objB);
        objA.setNum(2);
        System.out.println("A:" + objA + " B:" + objB);
    }
}
