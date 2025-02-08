
package GUI;


import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Server Kodları
public class Main {
    
    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    private static PrintWriter out = null;
    private static Scanner input = null;
    
    
    public static void main(String[] args) {
        
       //Arayüzü çalıştırma kodu
       ServerGUI.getFrame();
       
       //Türkçe karakter sorununu çözme kodu
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
         } catch (UnsupportedEncodingException ex) {
        }
        
        
        try {
            
            serverSocket = new ServerSocket(1234);
            System.out.println("Server olusturuldu baglantı bekleniyor");
            clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress().getHostName() + " baglandi");
            
            //Arayuzde baglantılar kısmına baglanan client'in bilgilerini yazıyoruz
            ServerGUI.getBaglantilar_alani().setText(ServerGUI.getBaglantilar_alani().getText()+clientSocket.toString()+"\n");
            
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new Scanner(clientSocket.getInputStream());

            Scanner s = new Scanner(System.in);

            while (true) {

                String gelenveri = input.nextLine();
                String log = clientSocket.getInetAddress().getHostName()+":>"+gelenveri;
                
                //Konsola gelen mesajı gönderen client'in bilgileriyle yazdırma
                System.out.println(clientSocket.getInetAddress().getHostName() + "'dan gelen mesaj: " + gelenveri);
                
                //Arayüze gelen mesajı gönderen client'in bilgileriyle yazdırma
                ServerGUI.getGelen_mesajlar_alani().setText(ServerGUI.getGelen_mesajlar_alani().getText()+" "+log+"\n");
                
                //Client'e gönderilen mesaj (client'in gönderdiği mesajı büyük harfe çevirip gönderir)
                out.println(gelenveri.toUpperCase());

            }
            
        } catch (IOException ex) {
            System.out.println("Baglanti saglanamadi." + ex.getMessage());
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                System.out.println("Bağlantı kapatılamadı!" + ex.getMessage());
                System.exit(1);
            }
        }
       
       
       
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    public static Socket getClientSocket() {
        return clientSocket;
    }

    public static PrintWriter getOut() {
        return out;
    }

    public static Scanner getInput() {
        return input;
    }
}
