/*
 * Caner KANSIZ
 * 200913171063
 * 31.05.2012 12.11
 */
package com.restoran.core;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionListener implements ListSelectionListener {
JTable table;
    SelectionListener(JTable table) {
        this.table = table;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
       
        if (e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
           
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
        } else if (e.getSource() == table.getColumnModel().getSelectionModel() && table.getColumnSelectionAllowed() ){
            
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
        }

        if (e.getValueIsAdjusting()) {
        }
    }
}
