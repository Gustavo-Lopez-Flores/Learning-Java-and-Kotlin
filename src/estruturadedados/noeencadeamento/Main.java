package estruturadedados.noeencadeamento;

public class Main {
    public static void main(String[] args) {
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


    }
}