package org.example;

import java.io.*;
import java.net.*;
import java.sql.*;

public class ShardA {
    public static void main(String[] args) {
        Connection connection = null;
        int port = 12347; // Porta específica para Shard A

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "minhasenha");
            Statement statement = connection.createStatement();

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Shard A aguardando conexões...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida com Transaction Coordinator.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receber solicitação do Transaction Coordinator
                String idConta = in.readLine();
                String tipoTransacao = in.readLine();
                String dataTransacao = in.readLine();
                double valorTransacao = Double.parseDouble(in.readLine());

                // Atualizar saldo corrente do cliente após transação de crédito
                if (tipoTransacao.equalsIgnoreCase("C")) {
                    String updateQuery = "UPDATE cliente SET saldo_corrente = saldo_corrente + " + valorTransacao + " WHERE id_conta = '" + idConta + "'";
                    statement.executeUpdate(updateQuery);
                }

                // Salvar a transação na tabela de transações
                String insertQuery = "INSERT INTO transacao (id_conta, tipo_transacao, data_transacao, valor) VALUES ('" + idConta + "', '" + tipoTransacao + "', '" + dataTransacao + "', " + valorTransacao + ")";
                statement.executeUpdate(insertQuery);

                out.println("Transação de crédito realizada com sucesso");

                in.close();
                out.close();
                socket.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}