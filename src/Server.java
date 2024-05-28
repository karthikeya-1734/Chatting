import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

        ServerSocket serversocket = new ServerSocket(1111);
        Socket socket = serversocket.accept();

        while (true) {
            System.out.println("You: ");
            String msg = sc.next();
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(msg);
            dout.flush();    
        }
    }
}