/*
 * Caner KANSIZ
 * 200913171063
 * 01.06.2012 15.10
 */
package com.restoran.controller;

import com.restoran.core.KeyValueComboboxModel;
import com.restoran.data.DataAccess;
import com.restoran.data.cevaplar;
import com.restoran.data.sorular;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Business {
    
   static ResultSet rs= null; 
   static ArrayList sorularArray=null;
   static ArrayList cevaplarArray=null;
   
   public static ArrayList<sorular> getSorular(){
       
       if(sorularArray==null)
            sorularArray=new ArrayList();
       else
           return sorularArray;
       
       ResultSet rs = DataAccess.Select("select * from soru");
       sorular soru=null;
        try {
            while(rs.next()){
                 try {
                     soru=new sorular(rs.getInt("soruKodu"),rs.getString("soruKelimesi"));
                     sorularArray.add(soru);
                 } catch (SQLException ex) {
                     Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return sorularArray;
   }
   
   public static ArrayList<cevaplar> getCevaplar(){
       
       if(cevaplarArray==null)
            cevaplarArray=new ArrayList();
       else
           return cevaplarArray;
       
       ResultSet rs = DataAccess.Select("select Id,cevapKod,cevapKelimesi from cevap");
       cevaplar cevap=null;
        try {
            while(rs.next()){
                 try {
                     cevap=new cevaplar(rs.getInt("cevapKod"),rs.getString("cevapKelimesi"));
                     cevaplarArray.add(cevap);
                 } catch (SQLException ex) {
                     Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cevaplarArray;
   }
    
   public static KeyValueComboboxModel getComboboxModel(){
       
       rs = DataAccess.Select("select id,mekanAdi from mekan");
       
       Map<String,String> map= new HashMap<String,String>(){{
                try {
                    while(rs.next()){
                        put(rs.getString("id"),rs.getString("mekanAdi"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }};
       
       KeyValueComboboxModel model = new KeyValueComboboxModel();
       model.putAll(map);
       
       return model;
   }
   
   public static KeyValueComboboxModel getComboboxAdmin(){
       
       rs = DataAccess.Select("select id,yetkili from yetki");
       
       Map<String,String> map= new HashMap<String,String>(){{
                try {
                    while(rs.next()){
                        put(rs.getString("id"),rs.getString("yetkili"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }};
       
       KeyValueComboboxModel model = new KeyValueComboboxModel();
       model.putAll(map);
       
       return model;
   }

}