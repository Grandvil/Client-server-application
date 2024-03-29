import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Server started");
            out.println("Write your name");
            final String name = in.readLine();
            System.out.println(name);
            out.println("Are you child? (yes/no)");
            final String isChild = in.readLine();
            System.out.println(isChild);
            if (isChild.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (isChild.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            } else {
                out.println("Wrong answer!");
            }
        }
    }
}
