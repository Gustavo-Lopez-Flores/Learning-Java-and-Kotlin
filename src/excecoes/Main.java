package excecoes;

public class Main {
    public static void main(String[] args){
        try{
            // System.out.println(quociente(0, 3));
            metodoUm();
        }catch(ArithmeticException e){
            System.out.println("Entrou no catch...");
            System.out.println(e);
        }catch (Exception e){
            System.out.println("Entrou na excecao encadeada");
        }
    }
    public static int quociente(int divisor, int dividendo){
        return dividendo / divisor;
    }
    public static void metodoUm() throws Exception {
        try{
            metodoDois();
        }catch(Exception e){
            throw new Exception("Excecao no Primeiro Metodo", e);
        }
    }
    public static void metodoDois() throws Exception{
        throw new Exception("Excecao no Segundo Metodo");
    }
}
