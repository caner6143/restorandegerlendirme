package com.restoran.core;
/**
 * CANER KANSIZ
 * 200913171063
 * 12.06.2012  
*/
public class mySession {

    private static String yetkiID="",name="",surname="",username="";
    private static boolean login;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        mySession.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        mySession.surname = surname;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        mySession.username = username;
    }

    public static String getYetkiID() {
        return yetkiID;
    }

    public static void setYetkiID(String yetkiID) {
        mySession.yetkiID = yetkiID;
    }

    public static boolean getLogin() {
        return login;
    }
    
    public static void setLogin(boolean aLogin) {
        login = aLogin;
    }
    
    public static void clearItems(){
        yetkiID="";name="";surname="";username="";
        login=false;
    }
}