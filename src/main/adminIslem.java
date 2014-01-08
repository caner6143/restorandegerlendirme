package main;

import com.restoran.data.DataAccess;
import com.templates.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class adminIslem extends javax.swing.JInternalFrame {

    private static JInternalFrame frameKulEkleme = null;
    private static JInternalFrame frameKulBilgi = null ;

    public adminIslem() {
        initComponents();
        showYetkili();
        txSeciliAlan.setVisible(false);
        silButton.setVisible(false);
        labKul1.setVisible(false);
    }

    public void showYetkili() {
        ResultSet rs = DataAccess.Select("select * from kisi join yetki on kisi.yetkiID=yetki.id");
        String sListe = "";
        listeAdmin.removeAll();

        try {
            while (rs.next()) {
                sListe = rs.getInt("id")+ ".";
                sListe += rs.getString("username").toString() + "   ---->    ";
                sListe += rs.getString("yetkili").toString();
                listeAdmin.add(sListe);
                listeAdmin.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txSeciliAlan.setText(listeAdmin.getSelectedItem());
                    }
                });

            }
        } catch (SQLException ex) {
            Logger.getLogger(adminIslem.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public int findId() {
        int id = 0;
        String sStr = "";
        for (int i = 0; i < txSeciliAlan.getText().length(); i++) {
            if (txSeciliAlan.getText().charAt(i) == '.') {
                break;
            }
            sStr += txSeciliAlan.getText().charAt(i);

        }
        id = Integer.parseInt(sStr);
        return id;
    }
    
    public void adminAdd() {
        if (frameKulEkleme == null) {
            frameKulEkleme = new kullaniciEkle();

            jDesktopPane1.add(frameKulEkleme);
            frameKulEkleme.addInternalFrameListener(new InternalFrameListener() {

                @Override
                public void internalFrameOpened(InternalFrameEvent e) {
                    showYetkili();
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    frameKulEkleme = null;
                }

                @Override
                public void internalFrameIconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent e) {
                    showYetkili();
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent e) {
                    showYetkili();
                }
            });

            try {
                frameKulEkleme.setMaximum(rootPaneCheckingEnabled);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            frameKulEkleme.setMaximizable(true);
            frameKulEkleme.setIconifiable(rootPaneCheckingEnabled);
            frameKulEkleme.setClosable(rootPaneCheckingEnabled);
            frameKulEkleme.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameKulEkleme.setResizable(true);
            frameKulEkleme.setEnabled(true);
            frameKulEkleme.setVisible(true);



        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        labKul = new java.awt.Label();
        scrollPane1 = new java.awt.ScrollPane();
        listeAdmin = new java.awt.List();
        labKul1 = new java.awt.Label();
        txSeciliAlan = new java.awt.TextField();
        silButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("KULLANICI MENÜ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 400));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        labKul.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labKul.setText("Sisteme Kayıtlı Kullanıcılar");
        labKul.setBounds(10, 10, 175, 31);
        jDesktopPane1.add(labKul, javax.swing.JLayeredPane.DEFAULT_LAYER);
        labKul.getAccessibleContext().setAccessibleName("labKul");

        listeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeAdminActionPerformed(evt);
            }
        });
        scrollPane1.add(listeAdmin);

        scrollPane1.setBounds(10, 60, 424, 210);
        jDesktopPane1.add(scrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labKul1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labKul1.setText("Seçilen Kullanıcı");
        labKul1.setBounds(10, 290, 100, 31);
        jDesktopPane1.add(labKul1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txSeciliAlan.setBounds(110, 290, 230, 30);
        jDesktopPane1.add(txSeciliAlan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        silButton.setText("Sil");
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });
        silButton.setBounds(350, 290, 80, 30);
        jDesktopPane1.add(silButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Kullanıcı Ekle");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Kullanıcı Silme");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Kullanıcı Bilgiler");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        adminAdd();
        showYetkili();
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        txSeciliAlan.setVisible(true);
        silButton.setVisible(true);
        labKul1.setVisible(true);
       
    }//GEN-LAST:event_jMenu2MousePressed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        listeAdmin.getSelectedItem();
        String sSql = "";
        sSql += "delete from kisi where id = '";
        sSql += findId() + "'";
        DataAccess.InsertDeleteUpdate(sSql);
        JOptionPane.showMessageDialog(rootPane, "Kayıt Başarıyla Silindi");
        txSeciliAlan.setText("");
        showYetkili();
    }//GEN-LAST:event_silButtonActionPerformed

    private void listeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listeAdminActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        if (frameKulBilgi == null) {
            frameKulBilgi = new kul();

            jDesktopPane1.add(frameKulBilgi);
            frameKulBilgi.addInternalFrameListener(new InternalFrameListener() {

                @Override
                public void internalFrameOpened(InternalFrameEvent e) {
                    showYetkili();
                }

                @Override
                public void internalFrameClosing(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    frameKulBilgi = null;
                }

                @Override
                public void internalFrameIconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameDeiconified(InternalFrameEvent e) {
                }

                @Override
                public void internalFrameActivated(InternalFrameEvent e) {
                    showYetkili();
                }

                @Override
                public void internalFrameDeactivated(InternalFrameEvent e) {
                    showYetkili();
                }
            });
            
            try {
                frameKulBilgi.setMaximum(rootPaneCheckingEnabled);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            frameKulBilgi.setMaximizable(true);
            frameKulBilgi.setIconifiable(rootPaneCheckingEnabled);
            frameKulBilgi.setClosable(rootPaneCheckingEnabled);
            frameKulBilgi.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frameKulBilgi.setResizable(true);
            frameKulBilgi.setEnabled(true);
            frameKulBilgi.setVisible(true);



        }
    }//GEN-LAST:event_jMenu3MousePressed

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
            java.util.logging.Logger.getLogger(adminIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminIslem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new adminIslem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.Label labKul;
    private java.awt.Label labKul1;
    private java.awt.List listeAdmin;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton silButton;
    private java.awt.TextField txSeciliAlan;
    // End of variables declaration//GEN-END:variables
}
