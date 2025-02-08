
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;


public class ThreadTCPClient {
    public static Socket socket = null;
    public static PrintWriter out = null;
    public static Scanner input = null;
    public static boolean sunucuBaglandiMi = false;
    public static String kullanici_adi;
    public static String[] isimler = {""};
    
    public static void main(String[] args) {
        GUI.getFrame();
       try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
        }

        while (!sunucuBaglandiMi) {
            System.out.println("");
        }

        while (true) {

            String gelenveri = input.nextLine();
            System.out.println("Sunucudan gelen mesaj: " + gelenveri);

            if (gelenveri.split(">")[0].equals("isimler")) {

                isimler = gelenveri.split(">");

                System.out.println("Client Tarafi");
                System.out.println("-------------------------------");
                for (String s : isimler) {
                    System.out.println(s);
                }
                System.out.println("-------------------------------");

            } else {
                GUI.getGelen_mesajlar_alani().setText(GUI.getGelen_mesajlar_alani().getText() + gelenveri + "\n");
                

            }

        }
    }
    
    
    
    
}
