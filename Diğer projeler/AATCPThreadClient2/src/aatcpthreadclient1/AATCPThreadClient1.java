/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aatcpthreadclient1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class AATCPThreadClient1 {

    
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost",1234);
        
        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        
        while(true){
            
            System.out.println("Mesaj giriniz: ");
            String mesaj = scan.nextLine();
            
            out.println(mesaj);
            
            String gelenMesaj = input.nextLine();
            System.out.println("Server > "+gelenMesaj);
        }
    }
    
}
