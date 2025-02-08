
package aatcpclient1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class AATCPClient1 {

   
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost",1234);
        
        Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        Scanner input = new Scanner(socket.getInputStream());
        
        while (true) {            
            
            System.out.println("Mesaj giriniz: ");
            String mesaj = scan.nextLine();
            
            out.println(mesaj);
            
            String gelenMesaj = input.nextLine();
            System.out.println("Server > "+gelenMesaj);
            
            
        }
        
        
        
        
    }
    
}
