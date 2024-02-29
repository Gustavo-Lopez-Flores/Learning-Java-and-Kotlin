package org.example;

import java.io.*;
import java.net.*;
import java.sql.*;

public class ShardB {
    public static double consultaSaldo(Statement statement, String idConta) throws SQLException {
        String query = "SELECT saldo_corrente FROM cliente WHERE id_conta = '" + idConta + "'";
        ResultSet resultSet = statement.executeQuery(query);

        double saldo = 0.0;
        if (resultSet.next()) {
            saldo = resultSet.getDouble("saldo_corrente");
        }

        return saldo;
    }

    public static void main(String[] args) {
        Connection connection = null;
        int port = 12346; // Porta específica para Shard A ou Shard B

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "minhasenha");
            Statement statement = connection.createStatement();

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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}