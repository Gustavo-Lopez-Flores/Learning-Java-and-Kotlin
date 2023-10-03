package excecoes;

public class Main {
    public static void main(String[] args){
        try{
            System.out.println(quociente(0, 3));
        }catch(ArithmeticException e){
            System.out.println("Entrou no catch...");
            System.out.println(e);
        }
    }
    public static int quociente(int divisor, int dividendo){
        return dividendo / divisor;
    }
}
