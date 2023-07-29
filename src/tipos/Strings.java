package tipos;

public class Strings{
    public static void main(String[] args){
        String nome = "Gustavo";
        String sobrenome = "Flores";
        Double real = 2.1234;

        /* Concatenando */ 
        String nomeCompleto = nome + sobrenome;
        System.out.println("Nome Completo: " + nomeCompleto);   

        /* Fomatando String */
        String mensagem = String.format("Nome: %s - Sobrenome: %s", nome, sobrenome);   
        System.out.println(mensagem);   
        System.out.println(String.format("%.2f", real));

        /* Outra forma de instanciar/declarar String */
        String texto = new String(" Ola Mundo ");

        /* Obter caracter em determinada posicao na String */
        System.out.println("charAt: " + nome.charAt(4));   

        /* Obter comprimento da String */
        System.out.println("length: " + nome.length());   

        /* Manter espaços vazios nos cantos */
        System.out.println("{" + texto + "}");   

        /* Retirar espaços vazios no cantos */
        System.out.println("{" + texto.trim() + "}");   

        /* Converter String em Minúsculo */
        System.out.println("toLowerCase: " + nome.toLowerCase());   

        /* Converter String em Maiúsculo */
        System.out.println("toUpperCase: " + nome.toUpperCase());   

        /* Buscar caracter, retorno booleano */
        System.out.println("contains: " + nome.contains("G"));   

        /* Trocar um caracter por outro dentro da String*/
        System.out.println("replace: " + nome.replace("u","U"));   

        /* Fazer comparação entre tipos.Strings */
        System.out.println("equals: " + nome.equals("GUstavo"));   

        /* Fazer comparação entre tipos.Strings sem se importar com Maíusculo ou Minúsculo */
        System.out.println("equalsIgnoreCase: " + nome.equalsIgnoreCase("gustavo"));   
    
        /* Criar Substrings */
        System.out.println("substring: " + texto.substring(5,10));   

        StringBuilder builder = new StringBuilder(nome);
        System.out.println(builder);
        
        /* Concatenas tipos.Strings */
        System.out.println(builder.append(sobrenome));
        
        /* Inverter a String */
        System.out.println(builder.reverse());

        /* Inserir caracteres na String */
        System.out.println(builder.insert(0,"#").insert(builder.length(),"!"));

        /* Converte em vetor de Char */
        System.out.println("A B C D E F G" .toCharArray());        
        
        /* Retira letra */
        System.out.println("Aula de Java".split("a"));        
        
        /* Concatena */
        System.out.println("Aula " .concat("de Java"));        
        
        /* Substitui / Cifra */
        System.out.println("1234 asda qw" .replaceAll("[0-9]","#"));        
        
        /*  Atribuicoes String */
        String meuNome = "Gustavo";
        String meuSobrenome = "Lopez";
        String comprida = "Ola mundo como esta";
        meuNome = meuSobrenome;
        System.out.println(meuNome);
        meuNome = comprida;
        System.out.println(meuNome);
    }
}
