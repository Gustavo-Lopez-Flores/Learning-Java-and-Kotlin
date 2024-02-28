package org.example;

import java.io.*;
import java.net.*;

public class TransactionCoordinator {
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Transaction Coordinator aguardando conexões...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida com Cliente.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receber solicitação do Cliente
                String request = in.readLine();
                System.out.println("Solicitação do Cliente: " + request);

                // Processar solicitação e encaminhar para o shard correspondente (A ou B)

                // Enviar resposta ao Cliente
                out.println("OK");

                // Emitir mensagem "Transação concluída com sucesso" para o Cliente
                out.println("Transação concluída com sucesso");

                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}