import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to Server");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            String clientMsg, serverMsg;
            while (true) {
                System.out.print("Client: ");
                clientMsg = sc.nextLine();
                out.println(clientMsg);
                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                serverMsg = in.readLine();
                System.out.println("Server: " + serverMsg);
                if (serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            socket.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}