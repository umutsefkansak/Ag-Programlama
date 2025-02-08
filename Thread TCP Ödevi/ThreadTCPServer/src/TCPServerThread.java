
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TCPServerThread {

    public static HashSet<PrintWriter> printWriters = new HashSet<>();
    private static ServerSocket serverSocket = null;
    public static ArrayList<String> isimler = new ArrayList<>();
    public static ArrayList<String> mesajlar = new ArrayList<>();
    public static PrintWriter silinenObje;

    public static void main(String[] args) {
        GUI.getFrame();
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Sunucu TCP Socket oluşturuldu.Bağlantı bekleniyor..");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.toString() + " bağlandı.");

                ClientHandler handler = new ClientHandler(clientSocket); //ClientHandler sınıfına client socketi gönderilir
                handler.start();//run() metodu çağrılır
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
}

class ClientHandler extends Thread {

    private Socket clientSocket;
    PrintWriter out;
    Scanner input;

    public ClientHandler(Socket socket) {
        try {
            clientSocket = socket;
            out = new PrintWriter(clientSocket.getOutputStream(), true); //istemciye veri gönderme nesnesi
            input = new Scanner(clientSocket.getInputStream());//istemciden veri alma nesnesi 

            TCPServerThread.printWriters.add(out);
            

        } catch (IOException ex) {
            System.out.println("Bağlantı hatasi!" + ex.getMessage());
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    @Override
    public void run() {
        String gelenVeri;
        do {
            gelenVeri = input.nextLine();
            //client tarafında gönderilen her mesaja kullanıcı adı da eklenirse isim ve mesajı ayır. 
            //isim>mesaj Örnek format: Ali>Merhaba

            if (gelenVeri.split(">")[0].equals("kullaniciadi")) {
                if (TCPServerThread.isimler.indexOf(gelenVeri.split(">")[1]) == -1) {
                    TCPServerThread.isimler.add(gelenVeri.split(">")[1]);
                    
                String tum_kullanicilar="isimler>";
                for(String s:TCPServerThread.isimler){
                    tum_kullanicilar = tum_kullanicilar+s+">";
                    
                }
                for (PrintWriter out : TCPServerThread.printWriters) {
                    System.out.println(TCPServerThread.printWriters.size() + ":" + out.toString());
                    out.println(tum_kullanicilar);
                }
                }
                
                //isimleri konsola yazdirma
                System.out.println("*************");
                for (String s : TCPServerThread.isimler) {
                    System.out.println(s);
                }
                System.out.println("*************");
                
                
            }else if(gelenVeri.split(">")[0].equals("sil")){
                TCPServerThread.isimler.remove(gelenVeri.split(">")[1]);
            }
            
            else {

                String isim = gelenVeri.split(">")[0];
                String mesaj = gelenVeri.split(">")[1];
                System.out.println(isim + ": " + mesaj);
                
                GUI.getGelen_mesajlar_alani().setText(GUI.getGelen_mesajlar_alani().getText()+gelenVeri+"\n");
                for (PrintWriter out : TCPServerThread.printWriters) {
                    System.out.println(TCPServerThread.printWriters.size() + ":" + out.toString());
                    out.println(isim + "> " + mesaj.toUpperCase());
                    TCPServerThread.mesajlar.add(gelenVeri);
                }

            }

        } while (!gelenVeri.equals("exit")); //client tarafında exit mesajı gelene kadar iletişim devam eder
        if (clientSocket != null) {
            try {
                System.out.println("Baglanti kapatiliyor..");
                clientSocket.close();
            } catch (IOException ex) {
                System.out.println("Bağlantı kapatilamadi!" + ex.getMessage());
            }
        }
    }
    
    public void sil(){
        TCPServerThread.printWriters.remove(TCPServerThread.silinenObje);
    }
}
