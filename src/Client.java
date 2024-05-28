import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket socket = new Socket("localhost",1111);
        
        while (true) {
            DataInputStream din = new DataInputStream(socket.getInputStream());
            String msg = din.readUTF();
            System.out.println("Server : "+msg);
    
            
        }
        
    }

}
