package main;

import com.restoran.data.DataAccess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class restoranIslem extends javax.swing.JInternalFrame {

    public restoranIslem() {
        initComponents();
        txRestoran.setVisible(false);
        ekleButton.setVisible(false);
        silButton.setVisible(false);
        jLabel1.setVisible(false);
        txRestoranName.setVisible(false);
        jLabel3.setVisible(false);
        PopulateRestorans();
    }

    public void isletEkle() {
        silButton.setVisible(false);
        jLabel3.setVisible(false);
        txRestoranName.setVisible(false);
        txRestoran.setVisible(true);
        ekleButton.setVisible(true);
        jLabel1.setVisible(true);
    }

    public void isletSil() {
        txRestoran.setVisible(false);
        ekleButton.setVisible(false);
        jLabel1.setVisible(false);
        txRestoranName.setVisible(true);
        jLabel3.setVisible(true);
        silButton.setVisible(true);
        
    }

    protected void PopulateRestorans() {
        listeRestoranlar.removeAll();
        ResultSet rs = DataAccess.Select("select * from mekan order by mekanAdi");
        String sListe = "";
        try {
            while (rs.next()) {
                sListe = String.valueOf(rs.getInt("id")) + ". ";
                sListe += rs.getString("mekanAdi").toString();
                listeRestoranlar.add(sListe);
                listeRestoranlar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txRestoranName.setText(listeRestoranlar.getSelectedItem());
                    }
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(restoranIslem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int findId() {
        int id = 0;
        String sStr = "";
        for (int i = 0; i < txRestoranName.getText().length(); i++) {
            if (txRestoranName.getText().charAt(i) == '.') {
                break;
            }
            sStr += txRestoranName.getText().charAt(i);

        }
        id = Integer.parseInt(sStr);
        System.out.println(id);

        return id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txRestoran = new javax.swing.JTextField();
        ekleButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        listeRestoranlar = new java.awt.List();
        txRestoranName = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("İŞLETME");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("");
        setPreferredSize(new java.awt.Dimension(700, 410));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Restoran Adını Griniz : ");

        txRestoran.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        ekleButton.setText("Kaydet");
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });

        silButton.setText("Sil");
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Restoranlar");

        scrollPane1.add(listeRestoranlar);

        txRestoranName.setEditable(false);
        txRestoranName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRestoranNameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Seçilen restoran : ");

        jMenu1.setText("İşletme Ekle");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("İşletme Sil");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txRestoranName, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ekleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1045, 1045, 1045))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRestoranName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRestoran, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ekleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        isletEkle();
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        isletSil();
    }//GEN-LAST:event_jMenu2MousePressed

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
        String sSql = "";
        if ("".equals(txRestoran.getText())) {
            JOptionPane.showMessageDialog(rootPane, "İşletme Adını Giriniz");
        } else {
            sSql += "insert into mekan (mekanAdi) values ('";
            sSql += txRestoran.getText() + "')";
            DataAccess.InsertDeleteUpdate(sSql);
            txRestoran.setText("");
            JOptionPane.showMessageDialog(rootPane, "Kayıt Başarıyla Eklendi");
            PopulateRestorans();

        }

    }//GEN-LAST:event_ekleButtonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        listeRestoranlar.getSelectedItem();
        String sSql = "";
        sSql += "delete from mekan where id = '";
        sSql += findId() + "'";
        DataAccess.InsertDeleteUpdate(sSql);
        txRestoran.setText("");
        txRestoranName.setText("");
        JOptionPane.showMessageDialog(rootPane, "Kayıt Başarıyla Silindi");
        PopulateRestorans();
        
    }//GEN-LAST:event_silButtonActionPerformed

    private void txRestoranNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRestoranNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            silButtonActionPerformed(null);
        }
    }//GEN-LAST:event_txRestoranNameKeyPressed

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
            java.util.logging.Logger.getLogger(restoranIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(restoranIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(restoranIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(restoranIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new restoranIslem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.List listeRestoranlar;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton silButton;
    private javax.swing.JTextField txRestoran;
    private java.awt.TextField txRestoranName;
    // End of variables declaration//GEN-END:variables
}
