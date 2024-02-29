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
            System.out.println("Shard B aguardando conexões...");

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

                // Verificar saldo suficiente na conta do cliente
                double saldo = consultaSaldo(statement, idConta);
                if (saldo >= valorTransacao) {
                    // Atualizar saldo corrente do cliente após transação de débito
                    String updateQuery = "UPDATE cliente SET saldo_corrente = " + (saldo - valorTransacao) + " WHERE id_conta = '" + idConta + "'";
                    statement.executeUpdate(updateQuery);

                    // Salvar a transação na tabela de transações
                    String insertQuery = "INSERT INTO transacao (id_conta, tipo_transacao, data_transacao, valor) VALUES ('" + idConta + "', '" + tipoTransacao + "', '" + dataTransacao + "', " + valorTransacao + ")";
                    statement.executeUpdate(insertQuery);

                    out.println("Transação realizada com sucesso");
                } else {
                    out.println("Saldo insuficiente para realizar a transação");
                }

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