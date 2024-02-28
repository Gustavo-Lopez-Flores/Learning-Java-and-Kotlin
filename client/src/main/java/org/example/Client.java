package org.example;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    public static void pergunta(){
        System.out.println("Quer fazer uma requisição? S/N");
    }
    public static void main(String[] args) {

        String host = "localhost";
        int port = 12345;


        try {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Pattern data AAAA-MM-DD
            Pattern patternData = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})$");

            // Pattern id da conta DDDDD-DD
            Pattern patternId = Pattern.compile("^(\\d{5})-(\\d{2})$");

            // Pattern valor
            Pattern patternValor = Pattern.compile("^(\\d)+\\.(\\d{2})$");

            // Loop para enviar várias solicitações
            while (true) {
                pergunta();
                String breakCondition = br.readLine();

                if(breakCondition.equalsIgnoreCase("N")) break;

                System.out.println("INFORME");

                // Data
                String data;
                while(true){
                    System.out.println("- Data, no formato (AAAA-MM-DD):");
                    data = br.readLine();

                    Matcher matcher = patternData.matcher(data);
                    if(matcher.find()) break;
                }

                // Conta Cliente - Nome e IdConta
                String nomeCliente;
                String idContaCliente;
                while(true) {
                    System.out.println("Nome do Cliente:");
                    nomeCliente = br.readLine();
                    System.out.println("Id da Conta:");
                    idContaCliente = br.readLine();

                    Matcher matcher = patternData.matcher(data);
                    if (matcher.find()) break;
                }

                // Tipo de Operação
                String tipo; // "C" ou "D"
                while(true){
                    System.out.println("- Tipo de Operação, C - Crédito / D - Débitos");
                    tipo = br.readLine();

                    if(tipo.equalsIgnoreCase("C") || tipo.equalsIgnoreCase("D")) break;
                }

                // Valor
                String valor;
                Double valorOperacao;
                while(true){
                    System.out.println("- Valor de Operação, no formato 0.00\n");
                    valor = br.readLine();

                    Matcher matcher = patternValor.matcher(valor);
                    if(matcher.find()) break;
                }
                valorOperacao = Double.parseDouble(valor);

                // Formatar e enviar solicitação ao Transaction Coordinator
                String request = String.format("OpClient|%s|%s,%s|%s|%.2f", data, nomeCliente, idContaCliente, tipo, valor);
                out.println(request);

                // Receber resposta do Transaction Coordinator
                String response = in.readLine();
                System.out.println("Resposta do Transaction Coordinator: " + response);

                // Aguardar um curto intervalo antes de enviar a próxima solicitação (opcional)
                Thread.sleep(1000);
            }

            // Fechar conexão
             in.close();
             out.close();
             socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
