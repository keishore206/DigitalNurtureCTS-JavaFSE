import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            String clientMsg, serverMsg;
            while (true) {
                clientMsg = in.readLine();
                System.out.println("Client: " + clientMsg);
                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                System.out.print("Server: ");
                serverMsg = sc.nextLine();
                out.println(serverMsg);
                if (serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            socket.close();
            serverSocket.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}