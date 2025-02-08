
package aatcpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AATCPServer {

  
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(1234);
        Socket client = server.accept();
        
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        Scanner input = new Scanner(client.getInputStream());
        
        
        while(true){
            
            String gelenMesaj = input.nextLine();
            System.out.println(client.getInetAddress().getHostAddress()+":"+client.getPort()+">"+gelenMesaj);
            
            
            String gidenMesaj = gelenMesaj.toUpperCase();
            
            out.println(gidenMesaj);
            
            
        }
        
    }
    
}
