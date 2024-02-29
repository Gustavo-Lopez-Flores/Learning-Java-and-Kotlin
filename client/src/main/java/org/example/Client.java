package org.example;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    // Pattern data 2024-02-25
    static final Pattern patternData = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})$");

    // Pattern id da conta 12345-67
    static final Pattern patternId = Pattern.compile("^(\\d{5})-(\\d{2})$");

    // Pattern valor 1.23
    static final Pattern patternValor = Pattern.compile("^(\\d)+\\.(\\d{2})$");

    public static String opClient(BufferedReader br) throws IOException{
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
            System.out.println("- Nome do Cliente:");
            nomeCliente = br.readLine();
            System.out.println("- Id da Conta:");
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
        while(true){
            System.out.println("- Valor de Operação, no formato 0.00");
            valor = br.readLine();

            Matcher matcher = patternValor.matcher(valor);
            if(matcher.find()) break;
        }

        return String.format("OpClient|%s|%s|%s|%s|%s", data, nomeCliente, idContaCliente, tipo, valor);
    }
    public static void main(String[] args) {

        String host = "localhost"; // ip onde o Transaction Coordinator está sendo executado
        int port = 12345; // porta onde o Transaction Coordinator está ouvindo


        try {
            // Loop para enviar várias solicitações
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Formatar e enviar solicitação ao Transaction Coordinator
            String request = opClient(br);
            out.println(request);

            // Receber resposta do Transaction Coordinator
            String response = in.readLine();
            System.out.println("Resposta do Transaction Coordinator: " + response);

            // Fechar conexão do Cliente
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
