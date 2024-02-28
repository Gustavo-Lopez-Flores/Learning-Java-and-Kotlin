package org.example;

import java.io.*;
import java.net.*;

public class ShardA {
    public static void main(String[] args) {
        int port = 12346; // Porta específica para Shard A ou Shard B

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Shard aguardando conexões...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida com Transaction Coordinator.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receber solicitação do Transaction Coordinator
                String request = in.readLine();
                System.out.println("Solicitação do Transaction Coordinator: " + request);

                // Processar solicitação, consultar banco de dados e responder ao Transaction Coordinator

                // Responder ao Transaction Coordinator se foi possível realizar a operação
                out.println("OK");

                // Guardar o histórico no banco de transações

                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}