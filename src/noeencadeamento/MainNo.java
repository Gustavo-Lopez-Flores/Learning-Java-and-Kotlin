package noeencadeamento;

public class MainNo {
    public static void main(String[] args) {
        /* NORMAL */
        No no1 = new No("Conteudo No 1");
        No no2 = new No("Conteudo No 2");

        no1.setProximoNo(no2);

        No no3 = new No("Conteudo No 3");

        no2.setProximoNo(no3);

        No no4 = new No("Conteudo No 4");

        no3.setProximoNo(no4);

        // no1 -> no2 -> no3 -> no4 -> null

        System.out.println(no1);
        System.out.println(no2);
        System.out.println(no3);
        System.out.println(no4);

        System.out.println("-------------");

        System.out.println(no1);
        System.out.println(no1.getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo().getProximoNo());

        System.out.println("-------------");

        /* COM GENERICS */ // tornar classe nó genérica para aceitar conteudo de qualquer tipo
        NoComGenerics<String> noComGenerics1 = new NoComGenerics<String>("Conteudo Generico 1");

        NoComGenerics<String> noComGenerics2 = new NoComGenerics<>("Conteudo Generico 2"); // Segundo <> não precisa mais especificar o tipo, pois o compilador já entende que esta instanciando nó de String
        noComGenerics1.setProximoNo(noComGenerics2);

        NoComGenerics<String> noComGenerics3 = new NoComGenerics<String>("Conteudo Generico 3");
        noComGenerics2.setProximoNo(noComGenerics3);

        NoComGenerics<String> noComGenerics4 = new NoComGenerics<>("Conteudo Generico 4");
        noComGenerics3.setProximoNo(noComGenerics4);

        // no1 -> no2 -> no3 -> no4 -> null

        System.out.println(noComGenerics1);
        System.out.println(noComGenerics2);
        System.out.println(noComGenerics3);
        System.out.println(noComGenerics4);

        System.out.println("-------------");

        System.out.println(noComGenerics1);
        System.out.println(noComGenerics1.getProximoNo());
        System.out.println(noComGenerics1.getProximoNo().getProximoNo());
        System.out.println(noComGenerics1.getProximoNo().getProximoNo().getProximoNo());
        System.out.println(noComGenerics1.getProximoNo().getProximoNo().getProximoNo().getProximoNo());
    }
}