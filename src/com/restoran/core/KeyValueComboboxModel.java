/*
 * Caner KANSIZ
 * 200913171063
 * 08.06.2012 14.56
 */
package com.restoran.core;

import java.util.*;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class KeyValueComboboxModel extends AbstractListModel implements ComboBoxModel, Map<String, String> {

    private TreeMap<String, String> values = new TreeMap<String, String>();
    private Map.Entry<String, String> selectedItem = null;

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (java.util.Map.Entry<String, String>) anItem;
        fireContentsChanged(this, -1, -1);
    }

    public void setSelectedKey(String key) {
        selectedItem = values.ceilingEntry(key);
        setSelectedItem(key);
    }

    public void setSelectedItem(String key, String value) {
        values.put(key, value);
        setSelectedKey(key);
    }

    @Override
    public Object getElementAt(int index) {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(values.entrySet());
        return list.get(index);
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return values.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

    @Override
    public Set<java.util.Map.Entry<String, String>> entrySet() {
        return values.entrySet();
    }

    @Override
    public String get(Object key) {
        return values.get(key);
    }

    @Override
    public Set<String> keySet() {
        return values.keySet();
    }

    @Override
    public String put(String key, String value) {
        return values.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return values.remove(key);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public Collection<String> values() {
        return values.values();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        values.putAll(m);
    }

    public static String entryToString(Map.Entry<String, String> entry) {
        String str =
                 // "" + entry.getKey() + "->" +
                 entry.getValue();
        return str;
    }
}