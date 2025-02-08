
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


//Arayuz tasarım kodları
public class ClientGUI {
    
    private static JFrame frame;
    private static JPanel panel;
    
    private static JLabel baslik_yazisi;
    private static JLabel mesajlar_yazisi;
    private static JLabel gelen_mesajlar_yazisi;
    private static JLabel sol_server_resmi;
    private  static JLabel sag_server_resmi;
      
    private static JTextField mesaj_alani;
    
    private static JTextArea gelen_mesajlar_alani;
   
    private static JScrollPane scroll_mesaj_alani;
    private static JScrollPane scroll_gelen_mesajlar_alani;
    
    private static JButton gonder_butonu;
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
            panel.add(getMesajlar_yazisi());
            panel.add(getGelen_mesajlar_yazisi());
            panel.add(getSol_server_resmi());
            panel.add(getSag_server_resmi());
            panel.add(getMesaj_alani());
            panel.add(getScroll_mesaj_alani());
            panel.add(getGelen_mesajlar_alani());
            panel.add(getScroll_gelen_mesajlar_alani());
            panel.add(getGonder_butonu());
            panel.add(getCik_butonu());  
        }
        return panel;
    }

    public static JLabel getBaslik_yazisi() {
        
        if(baslik_yazisi == null){
            baslik_yazisi = new JLabel();
            baslik_yazisi.setText("Client Server");
            baslik_yazisi.setBounds(230, 10, 250, 70);
            baslik_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        }
        return baslik_yazisi;
    }

    public static JLabel getMesajlar_yazisi() {
        if(mesajlar_yazisi == null){
            mesajlar_yazisi = new JLabel();
            mesajlar_yazisi.setText("Mesaj Giriniz :");
            mesajlar_yazisi.setBounds(12, 190, 117, 20);
            mesajlar_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            
        }
        return mesajlar_yazisi;
    }

    public static JLabel getGelen_mesajlar_yazisi() {
        
        if(gelen_mesajlar_yazisi == null){
            gelen_mesajlar_yazisi = new JLabel();
            gelen_mesajlar_yazisi.setText("Gelen Mesajlar :");
            gelen_mesajlar_yazisi.setBounds(390, 190, 125, 20);
            gelen_mesajlar_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
            
        }
        return gelen_mesajlar_yazisi;
    }

    public static JLabel getSol_server_resmi() {
        
        if (sol_server_resmi == null) {
            sol_server_resmi = new JLabel();
            sol_server_resmi.setBounds(15, 10, 130, 130);
            Image foto = new ImageIcon(ClientGUI.class.getResource("/Images/client_boyutlu1.png")).getImage();
            sol_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sol_server_resmi;
    }

    public static JLabel getSag_server_resmi() {
        if (sag_server_resmi == null) {
            sag_server_resmi = new JLabel();
            sag_server_resmi.setBounds(520, 33, 130, 130);
            Image foto = new ImageIcon(ClientGUI.class.getResource("/Images/client_boyutlu2.png")).getImage();
            sag_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sag_server_resmi;
    }

    public static JTextField getMesaj_alani() {
        if(mesaj_alani == null){
            mesaj_alani = new JTextField();
            mesaj_alani.setBounds(10, 225, 350, 200);
        }
        return mesaj_alani;
    }
    public static JScrollPane getScroll_mesaj_alani() {
        if(scroll_mesaj_alani == null){
            
            scroll_mesaj_alani = new JScrollPane(getMesaj_alani());
            scroll_mesaj_alani.setBounds(getMesaj_alani().getBounds());
        }
        return scroll_mesaj_alani;
    }

    public static JTextArea getGelen_mesajlar_alani() {
        if(gelen_mesajlar_alani == null){
            gelen_mesajlar_alani = new JTextArea();
            gelen_mesajlar_alani.setEditable(false);
            gelen_mesajlar_alani.setBounds(390, 225, 300, 200);   
        }
        return gelen_mesajlar_alani;
    }

    

    public static JScrollPane getScroll_gelen_mesajlar_alani() {
        
         if(scroll_gelen_mesajlar_alani == null){
            
            scroll_gelen_mesajlar_alani = new JScrollPane(getGelen_mesajlar_alani());
            scroll_gelen_mesajlar_alani.setBounds(getGelen_mesajlar_alani().getBounds());
        }
        return scroll_gelen_mesajlar_alani;
    }

    public static JButton getGonder_butonu() {
        
        if(gonder_butonu == null){
            gonder_butonu = new JButton("Gönder");
            gonder_butonu.setBounds(270, 435, 90, 30);
            
            //Mesaj gönderme kodu
            gonder_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                   
                    //Mesaj alanındaki mesajı alıp server'a gönderiyoruz
                    String mesaj = mesaj_alani.getText();
                    
                    if(mesaj.equals("")){
                     JOptionPane.showMessageDialog(null, "Bos mesaj gonderemezsiniz!");

                    }
                    else {
                        Main.getOut().println(mesaj);

                        //Serverdan gelen mesajı alıyoruz
                        String gelen_mesaj = Main.getInput().nextLine();

                        //Serverdan gelen mesajı "Gelen Mesajlar" Alanına yazıyoruz
                        gelen_mesajlar_alani.setText(gelen_mesajlar_alani.getText() + gelen_mesaj + "\n");

                    }
                    
                }
            });
        }
        
        return gonder_butonu;
    }

    public static JButton getCik_butonu() {
        if(cik_butonu == null){
            cik_butonu = new JButton("Uygulamadan Çık");
            cik_butonu.setBounds(558, 435, 133 , 28);
            
            //Uygulamayı kaptma kodu
            cik_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return cik_butonu;
    }

    
}
