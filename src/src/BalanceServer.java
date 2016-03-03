package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hagen on 01.03.2016.
 */
public class BalanceServer {
    int port;
    public BalanceServer(int port){
        this.port = port;
        try (
                ServerSocket serverSocket =
                        new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        // BalanceServer server = new BalanceServer(9999);
        List<String> s = new ArrayList<String>();
        s.add("1");
        s.add("2");
        s.add("3");
        System.out.println(s.size());
        s.remove(1);
        System.out.println(s.size());
    }
}
