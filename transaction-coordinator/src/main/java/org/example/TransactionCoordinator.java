package org.example;

import java.io.*;
import java.net.*;
import java.sql.*;

public class TransactionCoordinator {
    public static boolean consultaConta(Statement statement, String idConta) throws SQLException {
        String query = "SELECT * FROM cliente WHERE id_conta = '" + idConta + "'";
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet.next(); // Retorna true se encontrou algum cliente com o id da conta
    }

    public static void criarConta(Statement statement, String nome, String idConta) throws SQLException {
        String insertQuery = "INSERT INTO cliente (nome, id_conta, saldo_corrente) VALUES ('" + nome + "','" + idConta + "', 0)";
        statement.executeUpdate(insertQuery);
    }

    public static void main(String[] args) {
        Connection connection = null;

        int port = 12345;

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
                String nome = requestData[2];
                String idConta = requestData[3];

                // Consulta para ver se o cliente já existe
                if(!consultaConta(statement, idConta)){
                    criarConta(statement, nome, idConta);
                }

                // Encaminha para o Shard requisitado
                String opcao = requestData[4];
                if(opcao.equalsIgnoreCase("D"))

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