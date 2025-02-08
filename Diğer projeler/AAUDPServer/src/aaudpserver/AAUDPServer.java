
package aaudpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class AAUDPServer {

  
    public static void main(String[] args) throws SocketException, IOException {
        
        
        DatagramSocket socket = new DatagramSocket(1234);
        
        while (true) {            
            
            //mesaj alma
            byte[] buffer = new byte[256];
            DatagramPacket inpacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(inpacket);
            
            String gelenMesaj = new String(inpacket.getData(),0,inpacket.getLength());
            
            InetAddress clientAddress = inpacket.getAddress();
            int port = inpacket.getPort();
            
            System.out.println(clientAddress+":"+port+">"+gelenMesaj);
            
            String gidenMesaj = gelenMesaj.toUpperCase();
            
            DatagramPacket outPacket = new DatagramPacket(gidenMesaj.getBytes(),gidenMesaj.length(),clientAddress,port);
            socket.send(outPacket);
            
            
            
            
        }
    
    }
    
}
