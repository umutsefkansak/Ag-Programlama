
import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class UDPClientGUI extends javax.swing.JFrame {

    
    public UDPClientGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kullanici_adi_alani = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesaj_alani = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        erisim_hakki_yazisi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gelen_mesajlar_alani = new javax.swing.JTextArea();
        port_alani = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        hata_konsolu = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setText("Client");

        kullanici_adi_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanici_adi_alaniActionPerformed(evt);
            }
        });

        jLabel2.setText("Kullanici Adi:");

        jButton1.setText("Onayla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mesaj Giriniz:");

        mesaj_alani.setColumns(20);
        mesaj_alani.setRows(5);
        jScrollPane1.setViewportView(mesaj_alani);

        jButton2.setText("Gonder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        erisim_hakki_yazisi.setBackground(new java.awt.Color(255, 255, 255));
        erisim_hakki_yazisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        erisim_hakki_yazisi.setForeground(new java.awt.Color(51, 51, 255));
        erisim_hakki_yazisi.setText("Erişim Hakkı : 3");

        jLabel4.setText("Gelen Mesajlar");

        gelen_mesajlar_alani.setColumns(20);
        gelen_mesajlar_alani.setRows(5);
        jScrollPane2.setViewportView(gelen_mesajlar_alani);

        jLabel5.setText("Sunucu Port'u:");

        hata_konsolu.setColumns(20);
        hata_konsolu.setRows(5);
        jScrollPane3.setViewportView(hata_konsolu);

        jLabel6.setText("Hata Konsolu:");

        jButton3.setText("Konsolu Temizle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/client_boyutlu1.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/client_boyutlu2.png"))); // NOI18N
        jLabel9.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(erisim_hakki_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(30, 30, 30)
                                                .addComponent(port_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(274, 274, 274)
                                            .addComponent(jButton3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(kullanici_adi_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kullanici_adi_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(port_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(erisim_hakki_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kullanici_adi_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanici_adi_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kullanici_adi_alaniActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clientName = kullanici_adi_alani.getText();
        JOptionPane.showMessageDialog(null, "İsminiz Basariyla Guncellendi");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(mesaj_alani.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bos Mesaj Giremezsiniz!");
        }else{
            
        
        
        try {
            sunucu_port = Integer.valueOf(port_alani.getText());
            String mesaj = mesaj_alani.getText();
            mesaj = " " + clientName + ">" + mesaj;

            //girilen veriyi byte olarak datagram pakete dönüştür ve gönder:
            DatagramPacket outPacket = new DatagramPacket(mesaj.getBytes(), mesaj.length(), host, sunucu_port);
            socket.send(outPacket);

            try {
                byte[] buffer = new byte[256];
                DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(inPacket);
                denemeHakki = 3;
                erisim_hakki_yazisi.setForeground(Color.blue);
                erisim_hakki_yazisi.setText("Erisim Hakkı: " + denemeHakki);
                //gelen datagram paketini Stringe dönüştür ve ekrana yazdır:
                String gelenMesaj = new String(inPacket.getData(), 0, inPacket.getLength());
                gelen_mesajlar_alani.setText(gelen_mesajlar_alani.getText()+"SERVER " + inPacket.getAddress() + ":" + inPacket.getPort() + ":" + gelenMesaj+"\n");
                System.out.println("SERVER " + inPacket.getAddress() + ":" + inPacket.getPort() + ":" + gelenMesaj);

            } catch (Exception e) {
                
                //HATA LOGLARI
                LocalTime time = LocalTime.now();
                LocalDate date = LocalDate.now();
                hata_konsolu.setForeground(Color.red);
                hata_konsolu.setText(hata_konsolu.getText()+"Tarih:"+date+" Saat:"+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+">"+e+"\n");
                
                //Deneme hakkı kontrolü
                denemeHakki--;
                if (denemeHakki == 1) {
                    erisim_hakki_yazisi.setForeground(Color.red);
                }
                erisim_hakki_yazisi.setText("Erişim Hakkı: " + denemeHakki);
                
                JOptionPane.showMessageDialog(null, "Sunucudan Mesaj Alınamadı Kalan Hakkınız:" + denemeHakki);
                
                if (denemeHakki == 0) {
                    System.out.println("Hata Sunucudan 3 kere yanıt alınamadı uygulama kapatiliyor");
                    System.exit(0);
                }
            }

        } catch (IOException ex) {
            LocalTime time = LocalTime.now();
                LocalDate date = LocalDate.now();
                hata_konsolu.setForeground(Color.red);
                hata_konsolu.setText(hata_konsolu.getText()+"Tarih:"+date+" Saat:"+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+">"+ex+"\n");
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hata_konsolu.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    private static DatagramSocket socket;
    private static InetAddress host;
    public static String clientName;
    static int denemeHakki = 3;
    static int sunucu_port;
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UDPClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UDPClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UDPClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UDPClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UDPClientGUI().setVisible(true);
            }
        });

        try {

            host = InetAddress.getLocalHost();//localhost üzerindeki sunucu ise
            //host = InetAddress.getByName("localhost");//belirtilen sunucu adının adresi
            socket = new DatagramSocket();
            socket.setSoTimeout(3000);//yanıt bekleme süresi ms olarak verilebilir

            Scanner giris = new Scanner(System.in);

            while (true) { //sürekli mesajlaşma devam etmesi için sonsuz döngü (veya kullanıcı exit yazınca durdurulabilir)

                System.out.println("Mesaj yaz:");
                String mesaj = giris.nextLine();
                mesaj = " " + clientName + ">" + mesaj;

                //girilen veriyi byte olarak datagram pakete dönüştür ve gönder:
                DatagramPacket outPacket = new DatagramPacket(mesaj.getBytes(), mesaj.length(), host, 1234);
                socket.send(outPacket);

                //Sunucudan yanıt alma:
                try {
                    byte[] buffer = new byte[256];
                    DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
                    socket.receive(inPacket);
                    //gelen datagram paketini Stringe dönüştür ve ekrana yazdır:
                    String gelenMesaj = new String(inPacket.getData(), 0, inPacket.getLength());
                    System.out.println("SERVER " + inPacket.getAddress() + ":" + inPacket.getPort() + ":" + gelenMesaj);

                } catch (Exception e) {
                    LocalTime time = LocalTime.now();
                LocalDate date = LocalDate.now();
                hata_konsolu.setForeground(Color.red);
                hata_konsolu.setText(hata_konsolu.getText()+"Tarih:"+date+" Saat:"+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+">"+e+"\n");
                    denemeHakki--;
                    if (denemeHakki == 0) {
                        System.out.println("Hata Sunucudan 3 kere yanıt alınamadı uygulama kapatiliyor");
                        System.exit(0);
                    } else {
                        continue;
                    }
                }

            }
        } catch (SocketException ex) {
            LocalTime time = LocalTime.now();
                LocalDate date = LocalDate.now();
                hata_konsolu.setForeground(Color.red);
                hata_konsolu.setText(hata_konsolu.getText()+"Tarih:"+date+" Saat:"+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+">"+ex+"\n");
            System.out.println("Socket hatasi!");
            System.exit(1);
        } catch (IOException ex) {
            LocalTime time = LocalTime.now();
                LocalDate date = LocalDate.now();
                hata_konsolu.setForeground(Color.red);
                hata_konsolu.setText(hata_konsolu.getText()+"Tarih:"+date+" Saat:"+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+">"+ex+"\n");
            System.out.println("Hata." + ex.getMessage());

        } finally {
            System.out.println("Baglanti kapatiliyor!\n");
            socket.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel erisim_hakki_yazisi;
    private javax.swing.JTextArea gelen_mesajlar_alani;
    private static javax.swing.JTextArea hata_konsolu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextField kullanici_adi_alani;
    private javax.swing.JTextArea mesaj_alani;
    private javax.swing.JTextField port_alani;
    // End of variables declaration//GEN-END:variables
}
