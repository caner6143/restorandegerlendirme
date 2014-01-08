/*
 * Caner KANSIZ
 * 200913171063
 * 07.06.2012 17.15
 */
package com.restoran.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccess {

    private static Connection baglan = null;
    private static final String dbUser = "root";
    private static final String dbPassword = "root12";
    private static final String connURL = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "restorankayit";
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";

    public static void openConnection() {
        try {
            Class.forName(jdbcDriver);
            if (baglan == null) {
                baglan = DriverManager.getConnection(connURL + dbName, dbUser, dbPassword);
            }
        } catch (Exception ex) {
        }
    }

    public static void closeConnection() {
        try {
            if (baglan != null) {
                baglan.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getConnectionInfo() {
    }

    public static ResultSet Select(String sSql) {
        openConnection();   //  bağlantıyı aç
        ResultSet rs = null;

        try {
            Statement komut = baglan.createStatement();
            rs = komut.executeQuery(sSql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public static int InsertDeleteUpdate(String sSql) {

        openConnection();
        Statement command = null;
        try {
            command = baglan.createStatement();

            return command.executeUpdate(sSql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return 0;

    }
}
