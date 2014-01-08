/*
 * Caner KANSIZ
 * 200913171063
 * 31.05.2012 11.56
 */
package main;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class RBHelper {

    public static class RadioButtonPanel extends JPanel {

        JRadioButton[] buttons;

        RadioButtonPanel(String[] str) {
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            buttons = new JRadioButton[str.length];
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JRadioButton(str[i]);
                buttons[i].setFocusPainted(false);
                add(buttons[i]);
            }
        }

        public void setSelectedIndex(int index) {
            for (int i = 0; i < buttons.length; i++) {
                if (i == index) {
                    buttons[i].setSelected(true);
                } else {
                    buttons[i].setSelected(false);
                }
            }
        }

        public int getSelectedIndex() {
            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].isSelected()) {
                    return i;
                }
            }
            return -1;
        }

        public JRadioButton[] getButtons() {
            return buttons;
        }
    }

    public static class RadioButtonRenderer extends RadioButtonPanel implements TableCellRenderer {

        RadioButtonRenderer(String[] strs) {
            super(strs);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Integer) {
                setSelectedIndex(((Integer) value).intValue());
            }
            return this;
        }
    }

    public static class RadioButtonEditor extends DefaultCellEditor implements ItemListener {

        RadioButtonPanel panel;

        public RadioButtonEditor(JCheckBox checkBox, RadioButtonPanel panel) {
            super(checkBox);
            this.panel = panel;
            ButtonGroup buttonGroup = new ButtonGroup();
            JRadioButton[] buttons = panel.getButtons();
            for (int i = 1; i < buttons.length; i++) {
                //buttonGroup.add(buttons[i]);
                buttons[i].addItemListener(this);
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (value instanceof Integer) {
                panel.setSelectedIndex(((Integer) value).intValue());
            }
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return new Integer(panel.getSelectedIndex());
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            super.fireEditingStopped();
        }
    }
    
    enum DbMode{
        Insert,Update,Delete
    }
}



