import java.io.*;
import java.net.*;

public class client
{   
    

    public static void main(String args[]) throws IOException
    {
        // to take input from user 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Socket client_socket = null;

        // to take input / read value from socket
        DataInputStream input = null;

        // to output a value to the socket
        DataOutputStream out = null;
        
        try
        {
            // establishing connection with server
            client_socket = new Socket("127.0.0.1", 5000);
            
            System.out.println("Connected to the server");
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        String line = "";

        // initializing input stream object to read from socket
        input = new DataInputStream(client_socket.getInputStream());

        // initializing output stream object to write to socket
        out = new DataOutputStream(client_socket.getOutputStream());

        while(!line.equals("over"))
        {
            System.out.println("Enter message for server");
            line = br.readLine();

            // writing to the socket
            out.writeUTF(line);

            // clearing contents of output stream object
            out.flush();

            // reading from the socket , the message received from server
            System.out.println("Server Response is " + input.readUTF());

        }
        
        client_socket.close();
        System.out.println("Close client socket");

    }
}