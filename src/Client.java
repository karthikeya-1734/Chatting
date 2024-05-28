import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost",9999);

        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        DataInputStream din = new DataInputStream(socket.getInputStream());
        Scanner sc = new Scanner(System.in);
        new Thread(()->{
            while (true) {
                try {
                    String msg;
                    System.out.print("You: ");
                    msg = sc.next();
                    dout.writeUTF(msg);
                    dout.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }                    
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    String msg = din.readUTF();
                    System.out.println("\n Message From Server : "+msg);
                    System.out.print("You: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }                    
            }
        }).start();
        
    }
}
