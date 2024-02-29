package org.example;

import java.io.*;
import java.net.*;
import java.sql.*;

public class TransactionCoordinator {
    public static void main(String[] args) {
        int port = 12345;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "minhasenha");
            Statement statement = connection.createStatement();
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

                // Extrair dados da solicitação do cliente
                String[] requestData = request.split("\\|");
                System.out.println("Nome do Cliente: " + requestData[2]);

                // Processa dados da conta

                //  Encaminhar para o shard correspondente (A ou B)


                // Enviar resposta ao Cliente
                out.println("OK");

                // Emitir mensagem "Transação concluída com sucesso" para o Cliente
                out.println("Transação concluída com sucesso");

                in.close();
                out.close();
                socket.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}