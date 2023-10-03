package excecoes;

import excecoes.minhasexcecoes.ExcecaoContemVogal;

public class Main {
    public static void main(String[] args){
        try{
            // System.out.println(quociente(0, 3));
            // metodoUm();
            contemVogal("ABC");
        }catch(ArithmeticException e){
            System.out.println("Entrou no catch de ArithmeticException");
            System.out.println(e);
        }catch(ExcecaoContemVogal e){
            System.out.println("Entrou no catch de ExcecaoContemVogal");
            System.out.println(e);
        }catch (Exception e){
            System.out.println("Entrou no catch de Exception");
            System.out.println(e);
        }finally {
            System.out.println("fim...");
        }
    }
    public static int quociente(int divisor, int dividendo){
        return dividendo / divisor;
    }
    public static void metodoUm() throws Exception {
        try{
            metodoDois();
        }catch(Exception e){
            throw new Exception();
        }
    }
    public static void metodoDois() throws Exception{
        throw new Exception();
    }
    public static void contemVogal(String texto) throws Exception{
        if(texto.matches(".*[aeiouAEIOU].*")){
            throw new ExcecaoContemVogal("O texto " + texto + " contem vogal");
        }
    }
}
