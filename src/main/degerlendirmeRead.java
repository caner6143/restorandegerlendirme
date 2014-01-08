package main;

import com.restoran.data.DataAccess;
import com.templates.menu;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class degerlendirmeRead extends javax.swing.JInternalFrame {

    static ArrayList kisi = null;
    static ArrayList mekan = null;
    static ArrayList soru = null;
    static ArrayList cevap = null;

    public degerlendirmeRead() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showAllButton = new javax.swing.JButton();
        searchNameButton = new javax.swing.JButton();
        txArama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEĞERLENDİRME OKU");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(950, 500));

        showAllButton.setText("Tümünü Göster");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        searchNameButton.setText("İsime Göre Ara");
        searchNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNameButtonActionPerformed(evt);
            }
        });

        txArama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAramaKeyPressed(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setUpdateSelectionOnSort(false);
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txArama, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 368, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllButton)
                    .addComponent(searchNameButton)
                    .addComponent(txArama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed

        showAll();

    }//GEN-LAST:event_showAllButtonActionPerformed

    private void searchNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNameButtonActionPerformed

        searchByName();

    }//GEN-LAST:event_searchNameButtonActionPerformed

    private void txAramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAramaKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            searchNameButtonActionPerformed(null);
        
    }//GEN-LAST:event_txAramaKeyPressed

    public static String mekanIDcevir(Object id) {
        String mekan = "";
        String sSql = "";
        sSql += "select mekanAdi from mekan where id = ";
        sSql += id;

        ResultSet rs = DataAccess.Select(sSql);
        try {
            while (rs.next()) {
                mekan = rs.getString("mekanAdi");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mekan;
    }

    public static String soruIDcevir(Object id) {
        String soru = "";
        String sSql = "";
        sSql += "select soruKelimesi from soru where id = ";
        sSql += id;

        ResultSet rs = DataAccess.Select(sSql);
        try {
            while (rs.next()) {
                soru = rs.getString("soruKelimesi");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return soru;
    }

    public static String cevapIDcevir(Object id) {
        String cevap = "";
        String sSql = "";
        sSql += "select cevapKelimesi from cevap where id = ";
        sSql += id;

        ResultSet rs = DataAccess.Select(sSql);
        try {
            while (rs.next()) {
                cevap = rs.getString("cevapKelimesi");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cevap;
    }

    public void showAll() {

        String sSql = "Select kisiAdiSoyadi,mekanID,soruID,cevapID from hareketler order by kisiAdiSoyadi";
        ResultSet rs = DataAccess.Select(sSql);

        if (kisi == null) {
            kisi = new ArrayList();
        }
        if (mekan == null) {
            mekan = new ArrayList();
        }
        if (cevap == null) {
            cevap = new ArrayList();
        }
        if (soru == null) {
            soru = new ArrayList();
        }

        try {
            while (rs.next()) {
                kisi.add(rs.getString("kisiAdiSoyadi"));
                mekan.add(rs.getInt("mekanID"));
                soru.add(rs.getInt("soruID"));
                cevap.add(rs.getInt("cevapID"));
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        };

        DefaultTableModel dm = new DefaultTableModel();
        Object[][] rows = new Object[kisi.size()][kisi.size()];
        for (int i = 0; i < kisi.size(); i++) {
            rows[i][0] = kisi.get(i);
            rows[i][1] = mekanIDcevir(mekan.get(i));
            rows[i][2] = soruIDcevir(soru.get(i));
            rows[i][3] = cevapIDcevir(cevap.get(i));

        }

        dm.setDataVector(rows, new Object[]{"Kişi", "Mekan", "Soru", "Cevap"});
        jTable1.setModel(dm);

        kisi = null;
        mekan = null;
        soru = null;
        cevap = null;

    }

    public void searchByName() {

        String sSql = "";
        sSql += "Select kisiAdiSoyAdi,mekanID,soruID,cevapID from hareketler where kisiAdiSoyadi = '";

        if (txArama.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Aranacak Kişi Seçilmedi !");
        } else {
            sSql += txArama.getText().toUpperCase().trim() + "'";
            ResultSet rs = DataAccess.Select(sSql);

            if (kisi == null) {
                kisi = new ArrayList();
            }
            if (mekan == null) {
                mekan = new ArrayList();
            }
            if (cevap == null) {
                cevap = new ArrayList();
            }
            if (soru == null) {
                soru = new ArrayList();
            }

            try {
                while (rs.next()) {
                    
                        kisi.add(rs.getString("kisiAdiSoyadi"));
                        mekan.add(rs.getInt("mekanID"));
                        soru.add(rs.getInt("soruID"));
                        cevap.add(rs.getInt("cevapID"));
                    
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            };

            DefaultTableModel dm = new DefaultTableModel();
            Object[][] rows = new Object[mekan.size()][mekan.size()];
            for (int i = 0; i < mekan.size(); i++) {
                rows[i][0] = kisi.get(i);
                rows[i][1] = mekanIDcevir(mekan.get(i));
                rows[i][2] = soruIDcevir(soru.get(i));
                rows[i][3] = cevapIDcevir(cevap.get(i));

            }

            
            dm.setDataVector(rows, new Object[]{"Kişi", "Mekan", "Soru", "Cevap"});
            jTable1.setModel(dm);

            kisi = null;
            mekan = null;
            soru = null;
            cevap = null;

        }
    }

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
            java.util.logging.Logger.getLogger(degerlendirmeRead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(degerlendirmeRead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(degerlendirmeRead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(degerlendirmeRead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            

            public void run() {
                new degerlendirmeRead().setVisible(true);
                //new yoneticiPanel().enableInputMethods(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchNameButton;
    private javax.swing.JButton showAllButton;
    private javax.swing.JTextField txArama;
    // End of variables declaration//GEN-END:variables
}
