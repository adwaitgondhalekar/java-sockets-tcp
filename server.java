import java.io.*;
import java.net.*;

public class server {

    public static void main(String args[]) throws IOException
    {
        ServerSocket server_socket = null;
        DataOutputStream out = null;
        DataInputStream input = null;
        Socket socket = null;

        try
        {

            server_socket = new ServerSocket(5000);
            System.out.println("Ther server is running at port 5000...");
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        
        socket = server_socket.accept();
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        String client_input = "";

        while(!client_input.equals("over"))
        {   
            client_input = input.readUTF();
            System.out.println("Message from client side "+ client_input);
            out.writeUTF("Hello" + client_input);
            out.flush();
            

        }  
        
        socket.close();
        server_socket.close();
        System.out.println("Closed server socket");


    }

}
