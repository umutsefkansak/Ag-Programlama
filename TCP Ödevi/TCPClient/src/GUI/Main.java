
package GUI;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

//Client kodları
public class Main {
    
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static Scanner input = null;
    
    public static void main(String[] args) {
        
        //Arayüzü çalıştırma kodu
        ClientGUI.getFrame();
        
        //Türkçe karakter sorununu çözme kodu
         try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
         } catch (UnsupportedEncodingException ex) {
        }
        
         
        try {
            
            //Server'a bağlanıyoruz
            socket =  new Socket("localhost", 1234);
            
            out = new PrintWriter(socket.getOutputStream(),true);
            input = new Scanner(socket.getInputStream());
            
            Scanner s = new Scanner(System.in);
            
            //Sürekli mesaj gönderebilme kodu
            while(true){
                
                System.out.println("Gönderilecek mesajı girin: ");
                String mesaj = s.nextLine();
                
                out.println(mesaj);
                
                String gelenveri = input.nextLine();
                System.out.println("Sunucudan gelen mesaj: "+gelenveri);
                
            }
            
        } catch (IOException ex) {
            System.out.println("Sunucuya bağlanamadı.Hata mesajı:" + ex.getMessage());
            System.exit(1);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Bağlantı kapatılamadı!" + ex.getMessage());
                System.exit(1);
            }
        }
        
    }

    public static Socket getSocket() {
        return socket;
    }

    public static PrintWriter getOut() {
        return out;
    }

    public static Scanner getInput() {
        return input;
    }
}
