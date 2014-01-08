package main;

import com.restoran.data.DataAccess;
import com.templates.menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CANER
 */
public class kul extends javax.swing.JInternalFrame {

    public kul() {
        initComponents();
        tabloOlustur();
        rowSayisiBul();
    }
    
    public int rowSayisiBul(){
        int rowSayisi = 0 ;
        
        String sSql = "";
        sSql += "select count(*) from kisi join yetki on kisi.yetkiID=yetki.id ";
        sSql += "join dbyetki on yetki.id=dbyetki.yetkiliID";
        
        ResultSet rs = DataAccess.Select(sSql);
        try {
            while(rs.next()){
               rowSayisi = rs.getInt("count(*)");
           }
        } catch (SQLException ex) {
            Logger.getLogger(kul.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowSayisi;
    }

    public void tabloOlustur() {
        
        String sSql = "";
        sSql += "select username,yetkili,aciklama from kisi";
        sSql += " join yetki on kisi.yetkiID=yetki.id join dbyetki";
        sSql += " on yetki.id=dbyetki.yetkiliID  ";
        ResultSet rs = DataAccess.Select(sSql);
        DefaultTableModel dm = new DefaultTableModel();
        Object[][] rows = new Object[rowSayisiBul()][rowSayisiBul()];
        int index = 0;

        
        try {
            while (rs.next()) {

                rows[index][0] = rs.getString("username").toString();
                rows[index][1] = rs.getString("yetkili").toString();
                rows[index][2] = rs.getString("aciklama").toString();

                index++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(kul.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dm.setDataVector(rows, new Object[]{"Kullanıcı", "Görevi","Yetkileri"});
        jTable1.setModel(dm);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label1.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        label1.setText("Sistemdeki Kullanıcılar ve Görevleri");

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addGap(431, 431, 431))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(kul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            
            
            public void run() {
                new kul().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
