
package aatcpthreadserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class AATCPThreadServer {
    
    
    private static ServerSocket server = null;
    
    public static void main(String[] args) throws IOException {
        
        server = new ServerSocket(1234);
        
        while (true) {            
            Socket clientSocket = server.accept();
            
            ClientHandler handler = new ClientHandler(clientSocket);
            handler.start();
        }
        
        
    }
    
}

class ClientHandler extends Thread{
    
    Socket socket;
    Scanner input;
    PrintWriter out;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        
        out = new PrintWriter(socket.getOutputStream(),true);
        input = new Scanner(socket.getInputStream());
    }

    @Override
    public void run() {
        
        while(true){
            String gelenMesaj = input.nextLine();
            System.out.println(socket.getInetAddress().getHostAddress()+":"+socket.getPort()+">"+gelenMesaj);
            
            out.println(gelenMesaj.toUpperCase());
        }
        

    }
    
    
    
    
    
}
