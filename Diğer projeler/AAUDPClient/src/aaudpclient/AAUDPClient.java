
package aaudpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AAUDPClient {

   
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        
        InetAddress host = InetAddress.getLocalHost();
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(3000);
        
        Scanner scan = new Scanner(System.in);
        while (true) {            
            
            System.out.println("Mesaj giriniz: ");
            String mesaj = scan.nextLine();
            
            DatagramPacket outPacket = new DatagramPacket(mesaj.getBytes(),mesaj.length(),host,1234);
            socket.send(outPacket);
            
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(inPacket);
            
            String gelenMesaj = new String(inPacket.getData(),0,inPacket.getLength());
            System.out.println(inPacket.getAddress()+":"+inPacket.getPort()+"> "+gelenMesaj);
            
            
        }
        
        

    }
    
}
