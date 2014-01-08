/*
 * Caner KANSIZ
 * 200913171063
 * 31.05.2012 11.52
 */
package main;

import com.restoran.controller.Business;
import com.restoran.core.KeyValueComboboxModel;
import com.restoran.data.DataAccess;
import com.restoran.data.cevaplar;
import com.restoran.data.sorular;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class yeniMain extends javax.swing.JInternalFrame {
   
    private static yeniMain ym;

    public yeniMain() {
        initComponents();
        createCombobox();
        sorularCevaplarTablosuOlustur();
    }
    
    

    public void createCombobox() {
        jComboBox1.setModel(Business.getComboboxModel());
        jComboBox1.setRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Map.Entry) {
                    Map.Entry<String, String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = KeyValueComboboxModel.entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
    }

    public Hashtable<String, String> tablodanVeriAl() {

        Hashtable<String, String> tempHash = new Hashtable<String, String>();

        DefaultTableModel dm2 = (DefaultTableModel) jTable1.getModel();

        for (int row = 0; row < dm2.getRowCount(); row++) {
            tempHash.put(String.valueOf(Business.getSorular().get(row).getSoruKod()), (dm2.getValueAt(row, 1).toString()));
        }
        return tempHash;
    }

    public void sorularCevaplarTablosuOlustur() {
        DefaultTableModel dm = new DefaultTableModel();
        Object[][] rows = new Object[Business.getSorular().size()][Business.getSorular().size()];
        int index = 0;
        for (sorular soru : Business.getSorular()) {
            rows[index][0] = soru.getSoru();
            rows[index][1] = new Integer(-1);
            index++;
        }

        dm.setDataVector(rows, new Object[]{"Sorular", "Cevaplar"});
        jTable1.setModel(dm);

        int i = 0;
        String[] cevap = new String[Business.getCevaplar().size()];
        for (cevaplar cvp : Business.getCevaplar()) {
            cevap[i] = cvp.getCevap();
            i++;
        }
        jTable1.getColumn("Cevaplar").setCellRenderer(new RBHelper.RadioButtonRenderer(cevap));
        jTable1.getColumn("Cevaplar").setCellEditor(new RBHelper.RadioButtonEditor(new JCheckBox(), new RBHelper.RadioButtonPanel(cevap)));

    }

    public String jcomboboxKeyValue() {

        KeyValueComboboxModel model = (KeyValueComboboxModel) jComboBox1.getModel();
        Map.Entry<String, String> map = (Map.Entry<String, String>) model.getSelectedItem();
        return map.getKey();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txMusteriAdSoyad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setTitle("Müşteri Değerlendirme");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("Müşteri Ad,Soyad");

        txMusteriAdSoyad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMusteriAdSoyadKeyPressed(evt);
            }
        });

        jLabel2.setText("Restoran Adı");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Değerlendirme");

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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Temizle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMusteriAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMusteriAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Hashtable<String, String> hashTemp = tablodanVeriAl();

        //isim kaydedilir.
        //mekan kaydedilir.
        //soru ve cevaplar kaydedilir.
        String sSql = "";
        Enumeration e = hashTemp.keys();
        String key = "";
        sSql += "insert into hareketler(kisiAdiSoyadi,mekanID,soruID,cevapID) values ";
        while (e.hasMoreElements()) {
            key = e.nextElement().toString();

            sSql += "('" + txMusteriAdSoyad.getText().trim().toUpperCase() + "',";
            sSql += jcomboboxKeyValue() + ",";
            sSql += key + ",";
            sSql += hashTemp.get(key) + "),";
        }

        sSql = sSql.substring(0, sSql.length() - 1);
        DataAccess.InsertDeleteUpdate(sSql);
        JOptionPane.showMessageDialog(null, "Bilgiler Eklendi..");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txMusteriAdSoyad.setText(null);
        createCombobox();
        sorularCevaplarTablosuOlustur();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txMusteriAdSoyadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMusteriAdSoyadKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txMusteriAdSoyad.transferFocus();
        }

    }//GEN-LAST:event_txMusteriAdSoyadKeyPressed

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
            java.util.logging.Logger.getLogger(yeniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(yeniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(yeniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(yeniMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ym = new yeniMain();
                ym.createCombobox();
                ym.sorularCevaplarTablosuOlustur();
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txMusteriAdSoyad;
    // End of variables declaration//GEN-END:variables
}