
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


//Arayüz tasarım kodları

public class ServerGUI {
    
    private static JFrame frame;
    private static JPanel panel;
    
    private static JLabel baslik_yazisi;
    private static JLabel server_durum_yazisi;
    private static JLabel mesajlar_yazisi;
    private static JLabel baglantilar_yazisi;
    private static JLabel sol_server_resmi;
    private  static JLabel sag_server_resmi;
      
    private static JTextArea gelen_mesajlar_alani;
    private static JTextArea baglantilar_alani;
   
    private static JScrollPane scroll_mesajlar_alani;
    private static JScrollPane scroll_baglantilar_alani;
    
    private static JButton kapat_butonu;
    private static JButton cik_butonu;
    
    
    public static JFrame getFrame() {
        
        if(frame == null){
            frame = new JFrame();
            frame.setBounds(370, 120, 725, 600);
            frame.setContentPane(getPanel());
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        return frame;
    }

    public static JPanel getPanel() {
        if(panel == null){
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0, 0, 725, 600);

            panel.add(getBaslik_yazisi());
            panel.add(getServer_durum_yazisi());
            panel.add(getGelen_mesajlar_alani());
            
            panel.add(getScroll_mesajlar_alani());
            
            panel.add(getKapat_butonu());
            panel.add(getMesajlar_yazisi());
            panel.add(getBaglantilar_yazisi());
            panel.add(getBaglantilar_alani());
            panel.add(getScroll_baglantilar_alani());
            panel.add(getCik_butonu());
            
            panel.add(getSol_server_resmi());
            panel.add(getSag_server_resmi());
            
            
        }
        return panel;
    }

    public static JLabel getBaslik_yazisi() {
        if(baslik_yazisi == null){
            baslik_yazisi = new JLabel();
            baslik_yazisi.setText("SERVER");
            baslik_yazisi.setBounds(280, 10, 169, 70);
            baslik_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        }
        return baslik_yazisi;
    }

    public static JLabel getServer_durum_yazisi() {
        if(server_durum_yazisi == null){
            server_durum_yazisi = new JLabel();
            server_durum_yazisi.setText("Server Durumu : Açık");
            server_durum_yazisi.setBounds(12, 127, 160, 35);
            server_durum_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        }
        return server_durum_yazisi;
    }
    
    public static JLabel getMesajlar_yazisi() {
        if(mesajlar_yazisi == null){
            mesajlar_yazisi = new JLabel();
            mesajlar_yazisi.setText("Gelen Mesajlar :");
            mesajlar_yazisi.setBounds(12, 165, 117, 20);
            mesajlar_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            
        }
        return mesajlar_yazisi;
    }
    
    public static JTextArea getGelen_mesajlar_alani() {
        
        if(gelen_mesajlar_alani == null){
            gelen_mesajlar_alani = new JTextArea();
            gelen_mesajlar_alani.setEditable(false);
            gelen_mesajlar_alani.setBounds(12, 185, 400, 280);
        }
        return gelen_mesajlar_alani;
    }

  
    public static JScrollPane getScroll_mesajlar_alani() {
        if(scroll_mesajlar_alani == null){
            
            scroll_mesajlar_alani = new JScrollPane(getGelen_mesajlar_alani());
            scroll_mesajlar_alani.setBounds(getGelen_mesajlar_alani().getBounds());
        }
        
        return scroll_mesajlar_alani;
    }
    
    
    

    public static JLabel getBaglantilar_yazisi() {
        if(baglantilar_yazisi == null){
            baglantilar_yazisi = new JLabel();
            baglantilar_yazisi.setText("Baglantilar :");
            baglantilar_yazisi.setBounds(430, 165, 100, 20);
            baglantilar_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            
        }
        return baglantilar_yazisi;
    }


    public static JTextArea getBaglantilar_alani() {
        
        if(baglantilar_alani == null){
            baglantilar_alani = new JTextArea();
            baglantilar_alani.setEditable(false);
            baglantilar_alani.setBounds(430, 185, 250, 280);        
        }
        return baglantilar_alani;
    }
    
    
    
    public static JScrollPane getScroll_baglantilar_alani() {
        
        if(scroll_baglantilar_alani == null){
            
            scroll_baglantilar_alani = new JScrollPane(getBaglantilar_alani());
            scroll_baglantilar_alani.setBounds(getBaglantilar_alani().getBounds());
        }
        return scroll_baglantilar_alani;
    }
    
    public static JButton getKapat_butonu() {

        if (kapat_butonu == null) {
            kapat_butonu = new JButton("Serveri Kapat");
            kapat_butonu.setBounds(545, 487, 137, 26);

            //Serveri kapatma kodu
            kapat_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        //Client bağlantısı kapatılır
                        Main.getClientSocket().close();
                        
                        //Server kapatılır
                        Main.getServerSocket().close();
                        
                        //Serverin durumunu gösteren metin düzenlenir.
                        server_durum_yazisi.setForeground(Color.red);
                        server_durum_yazisi.setText("Server durumu : Kapali");
                        
                        //Kullaniciya geri bildirim yapılır
                        JOptionPane.showMessageDialog(null, "Server Basariyla Kapatildi");

                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            });
        }
        return kapat_butonu;
    }

    
    public static JButton getCik_butonu() {
        if(cik_butonu == null){
            cik_butonu = new JButton("Çıkış");
            cik_butonu.setBounds(545, 518, 137, 26);
            
            //Uygulamayı kapatma kodu
            cik_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        }
        return cik_butonu;
    }

    public static JLabel getSol_server_resmi() {
        
        if (sol_server_resmi == null) {
            sol_server_resmi = new JLabel();
            sol_server_resmi.setBounds(0, 0, 129, 100);
            Image foto = new ImageIcon(ServerGUI.class.getResource("/Images/boyutlu_server2.png")).getImage();
            sol_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sol_server_resmi;
    }

    public static JLabel getSag_server_resmi() {
        if (sag_server_resmi == null) {
            sag_server_resmi = new JLabel();
            sag_server_resmi.setBounds(580, 5, 129, 100);
            Image foto = new ImageIcon(ServerGUI.class.getResource("/Images/boyutlu_server.png")).getImage();
            sag_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sag_server_resmi;
    }
    
    
}
