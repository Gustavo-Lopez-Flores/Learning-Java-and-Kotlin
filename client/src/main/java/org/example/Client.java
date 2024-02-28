package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enviar solicitação ao Transaction Coordinator
            out.println("OpClient|Data|ContaCliente|Tipo|Valor");

            // Receber resposta do Transaction Coordinator
            String response = in.readLine();
            System.out.println("Resposta do Transaction Coordinator: " + response);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
