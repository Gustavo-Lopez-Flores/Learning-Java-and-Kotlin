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
                String tipoTransacao = requestData[4];
                String dataTransacao = requestData[1];
                double valorTransacao = Double.parseDouble(requestData[5]);

                // Consulta para ver se o cliente já existe
                if(!consultaConta(statement, idConta)){
                    criarConta(statement, nome, idConta);
                }

                // Encaminha para o Shard requisitado
                if(tipoTransacao.equalsIgnoreCase("C")){
                    // Enviar solicitação para o Shard A
                    encaminharParaShardA(socket, idConta, tipoTransacao, dataTransacao, valorTransacao);
                } else if (tipoTransacao.equalsIgnoreCase("D")) {
                    // Enviar solicitação para o Shard B
                    encaminharParaShardB(socket, idConta, tipoTransacao, dataTransacao, valorTransacao);
                }

                // Emitir mensagem "Transação concluída com sucesso" para o Cliente
                out.println("Operação finalizada");

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

    private static void encaminharParaShardA(Socket socket, String idConta, String tipoTransacao, String dataTransacao, double valorTransacao) {
        try {
            Socket shardSocket = new Socket("localhost", 12347); // Endereço e porta do Shard A
            PrintWriter out = new PrintWriter(shardSocket.getOutputStream(), true);

            // Enviar dados para o Shard A
            out.println(idConta);
            out.println(tipoTransacao);
            out.println(dataTransacao);
            out.println(valorTransacao);

            // Receber resposta do Shard A
            BufferedReader in = new BufferedReader(new InputStreamReader(shardSocket.getInputStream()));
            String response = in.readLine();
            System.out.println("Resposta do Shard A: " + response);

            // Encaminhar resposta para o Cliente
            PrintWriter clientOut = new PrintWriter(socket.getOutputStream(), true);
            clientOut.println(response);

            in.close();
            out.close();
            shardSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encaminharParaShardB(Socket socket, String idConta, String tipoTransacao, String dataTransacao, double valorTransacao) {
        try {
            Socket shardSocket = new Socket("localhost", 12346); // Endereço e porta do Shard B
            PrintWriter out = new PrintWriter(shardSocket.getOutputStream(), true);

            // Enviar dados para o Shard B
            out.println(idConta);
            out.println(tipoTransacao);
            out.println(dataTransacao);
            out.println(valorTransacao);

            // Receber resposta do Shard B
            BufferedReader in = new BufferedReader(new InputStreamReader(shardSocket.getInputStream()));
            String response = in.readLine();
            System.out.println("Resposta do Shard B: " + response);

            // Encaminhar resposta para o Cliente
            PrintWriter clientOut = new PrintWriter(socket.getOutputStream(), true);
            clientOut.println(response);

            in.close();
            out.close();
            shardSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}