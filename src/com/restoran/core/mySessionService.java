package com.restoran.core;
import com.restoran.data.DataAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * CANER KANSIZ
 * 200913171063
 * 12.06.2012  
*/
public class mySessionService {

    
    public static boolean checkUser(String sUsername,String sPassword){
        String sSql = "select yetkiID,name,surname from kisi where username='" + sUsername + "' and password = '" + sPassword + "'";
        ResultSet rs = DataAccess.Select(sSql);
        String sYetkiID="";
        String sName="";
        String sSurname="";
        try {
            while(rs.next()){
                sYetkiID=String.valueOf(rs.getInt("yetkiID"));
                sName=String.valueOf(rs.getString("name"));
                sSurname=String.valueOf(rs.getString("surname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mySessionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if("".equals(sYetkiID)){
            JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
            return false;
        }
        mySession.setLogin(true);
        mySession.setName(sName);
        mySession.setSurname(sSurname);
        mySession.setYetkiID(sYetkiID);
        mySession.setUsername(sUsername);
        
        return true;
       
    }
    public static String getUsername(){
        
       
        if("".equals(mySession.getUsername())){
            JOptionPane.showMessageDialog(null, "Aktif Kullanıcı Bulunmamaktadır!");
            return "";
        }
        else
            return mySession.getUsername();
    }
    
    
}