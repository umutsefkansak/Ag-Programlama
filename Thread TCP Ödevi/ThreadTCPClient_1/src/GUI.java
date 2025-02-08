
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

//Arayuz tasarım kodları
public class GUI {

    private static JFrame frame;
    private static JPanel panel;

    private static JLabel baslik_yazisi;
    private static JLabel mesajlar_yazisi;
    private static JLabel gelen_mesajlar_yazisi;
    private static JLabel sol_server_resmi;
    private static JLabel sag_server_resmi;
    private static JLabel port_yazisi;
    private static JLabel kullanici_adi_yazisi;

    private static JTextField mesaj_alani;
    private static JTextField port_alani;
    private static JTextField kullanici_adi_alani;

    private static JTextArea gelen_mesajlar_alani;

    private static JScrollPane scroll_mesaj_alani;
    private static JScrollPane scroll_gelen_mesajlar_alani;

    private static JButton gonder_butonu;
    private static JButton cik_butonu;
    private static JButton baglan_butonu;
    private static JButton kaydet_butonu;

    public static JFrame getFrame() {

        if (frame == null) {
            frame = new JFrame();
            frame.setBounds(370, 120, 625, 500);
            frame.setContentPane(getPanel());
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        return frame;
    }

    public static JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0, 0, 625, 500);

            panel.add(getBaslik_yazisi());
            panel.add(getMesajlar_yazisi());
            panel.add(getGelen_mesajlar_yazisi());
            panel.add(getPort_yazisi());
            panel.add(getKullanici_adi_yazisi());

            panel.add(getSol_server_resmi());
            panel.add(getSag_server_resmi());
            panel.add(getMesaj_alani());
            panel.add(getScroll_mesaj_alani());
            panel.add(getGelen_mesajlar_alani());
            panel.add(getScroll_gelen_mesajlar_alani());
            panel.add(getPort_alani());
            panel.add(getKullanici_adi_alani());

            panel.add(getGonder_butonu());
            panel.add(getCik_butonu());
            panel.add(getBaglan_butonu());
            panel.add(getKaydet_butonu());
        }
        return panel;
    }

    public static JLabel getBaslik_yazisi() {

        if (baslik_yazisi == null) {
            baslik_yazisi = new JLabel();
            baslik_yazisi.setText("Client Server");
            baslik_yazisi.setBounds(230, 10, 250, 70);
            baslik_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
        }
        return baslik_yazisi;
    }

    public static JLabel getPort_yazisi() {
        if (port_yazisi == null) {
            port_yazisi = new JLabel();
            port_yazisi.setText("Port:");
            port_yazisi.setBounds(10, 100, 117, 20);
            port_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        }
        return port_yazisi;
    }

    public static JLabel getKullanici_adi_yazisi() {
        if (kullanici_adi_yazisi == null) {
            kullanici_adi_yazisi = new JLabel();
            kullanici_adi_yazisi.setText("Kullanici adi:");
            kullanici_adi_yazisi.setBounds(300, 100, 117, 20);
            kullanici_adi_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        }
        return kullanici_adi_yazisi;
    }

    public static JLabel getMesajlar_yazisi() {
        if (mesajlar_yazisi == null) {
            mesajlar_yazisi = new JLabel();
            mesajlar_yazisi.setText("Mesaj Giriniz :");
            mesajlar_yazisi.setBounds(12, 190, 117, 20);
            mesajlar_yazisi.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));

        }
        return mesajlar_yazisi;
    }

    public static JLabel getGelen_mesajlar_yazisi() {

        if (gelen_mesajlar_yazisi == null) {
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
            sol_server_resmi.setBounds(15, -20, 130, 130);
            Image foto = new ImageIcon(GUI.class.getResource("/Images/client_boyutlu1.png")).getImage();
            sol_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sol_server_resmi;
    }

    public static JLabel getSag_server_resmi() {
        if (sag_server_resmi == null) {
            sag_server_resmi = new JLabel();
            sag_server_resmi.setBounds(520, 33, 130, 130);
            //Image foto = new ImageIcon(GUI.class.getResource("/Images/client_boyutlu2.png")).getImage();
            //sag_server_resmi.setIcon(new ImageIcon(foto));
        }
        return sag_server_resmi;
    }

    public static JTextField getMesaj_alani() {
        if (mesaj_alani == null) {
            mesaj_alani = new JTextField();
            mesaj_alani.setBounds(10, 225, 300, 150);
        }
        return mesaj_alani;
    }

    public static JScrollPane getScroll_mesaj_alani() {
        if (scroll_mesaj_alani == null) {

            scroll_mesaj_alani = new JScrollPane(getMesaj_alani());
            scroll_mesaj_alani.setBounds(getMesaj_alani().getBounds());
        }
        return scroll_mesaj_alani;
    }

    public static JTextArea getGelen_mesajlar_alani() {
        if (gelen_mesajlar_alani == null) {
            gelen_mesajlar_alani = new JTextArea();
            gelen_mesajlar_alani.setEditable(false);
            gelen_mesajlar_alani.setBounds(325, 225, 275, 150);
        }
        return gelen_mesajlar_alani;
    }

    public static JScrollPane getScroll_gelen_mesajlar_alani() {

        if (scroll_gelen_mesajlar_alani == null) {

            scroll_gelen_mesajlar_alani = new JScrollPane(getGelen_mesajlar_alani());
            scroll_gelen_mesajlar_alani.setBounds(getGelen_mesajlar_alani().getBounds());
        }
        return scroll_gelen_mesajlar_alani;
    }

    public static JButton getGonder_butonu() {

        if (gonder_butonu == null) {
            gonder_butonu = new JButton("Gönder");
            gonder_butonu.setBounds(220, 380, 90, 30);

            //Mesaj gönderme kodu
            gonder_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String mesaj = mesaj_alani.getText();
                    mesaj = ThreadTCPClient.kullanici_adi + ">" + mesaj;
                    ThreadTCPClient.out.println(mesaj);

                }
            });
        }

        return gonder_butonu;
    }

    public static JTextField getPort_alani() {
        if (port_alani == null) {
            port_alani = new JTextField();
            port_alani.setBounds(70, 100, 75, 25);
        }

        return port_alani;
    }

    public static JTextField getKullanici_adi_alani() {
        if (kullanici_adi_alani == null) {
            kullanici_adi_alani = new JTextField();
            kullanici_adi_alani.setBounds(400, 100, 100, 25);
        }
        return kullanici_adi_alani;
    }

    public static JButton getBaglan_butonu() {
        if (baglan_butonu == null) {
            baglan_butonu = new JButton("Baglan");
            baglan_butonu.setBounds(150, 100, 90, 25);

            baglan_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ThreadTCPClient.socket = new Socket("localhost", Integer.valueOf(port_alani.getText()));

                        ThreadTCPClient.out = new PrintWriter(ThreadTCPClient.socket.getOutputStream(), true);
                        ThreadTCPClient.input = new Scanner(ThreadTCPClient.socket.getInputStream());
                        ThreadTCPClient.sunucuBaglandiMi = true;

                        mesaj_alani.setEditable(true);

                        JOptionPane.showMessageDialog(null, "Baglanti Basarili");

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Baglanti Saglanamadi Tekrar Deneyiniz!");
                    }

                }
            });
        }
        return baglan_butonu;
    }

    public static JButton getKaydet_butonu() {
        if (kaydet_butonu == null) {
            kaydet_butonu = new JButton("Kaydet");
            kaydet_butonu.setBounds(505, 100, 75, 25);

            kaydet_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ThreadTCPClient.kullanici_adi = kullanici_adi_alani.getText();
                    if (ThreadTCPClient.kullanici_adi.length() < 5) {
                        JOptionPane.showMessageDialog(null, "Kullanici adi 5 karakterden küçük olamaz!");
                    } else {
                        String gidenveri = "kullaniciadi>" + ThreadTCPClient.kullanici_adi;
                        ThreadTCPClient.out.println(gidenveri);
                        boolean isimVarMi = false;
                        for (String s : ThreadTCPClient.isimler) {
                            if (s.equals(ThreadTCPClient.kullanici_adi)) {
                                JOptionPane.showMessageDialog(null, "Bu Kullanici adi zaten mevcut baska isim giriniz!");
                                isimVarMi = true;
                                ThreadTCPClient.kullanici_adi = "";
                                kullanici_adi_alani.setText("");
                            }
                        }
                        if (isimVarMi == false) {
                            JOptionPane.showMessageDialog(null, "Kullanici Adi Basarili");
                            kaydet_butonu.setVisible(false);
                        }
                    }

                }
            });
        }
        return kaydet_butonu;
    }

    public static JButton getCik_butonu() {
        if (cik_butonu == null) {
            cik_butonu = new JButton("Uygulamadan Çık");
            cik_butonu.setBounds(465, 380, 133, 28);

            //Uygulamayı kaptma kodu
            cik_butonu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
            ThreadTCPClient.out.println("sil>"+ThreadTCPClient.kullanici_adi);
            ThreadTCPClient.socket.close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
            });
        }
        return cik_butonu;
    }

}
