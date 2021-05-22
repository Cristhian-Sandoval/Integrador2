/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.conecction;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class ConnectionDB {
    private static ConnectionDB instance = null;
    private static Connection conn;
    //DEFINIENDO VARIABLES CONSTANTES
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DB_GYM";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "123";

    private ConnectionDB() {
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión Exitosa" + conn.toString());
        } catch (Exception e) {
            System.out.println("Error al conectar :" + e.getMessage());
            e.printStackTrace();
        }
    }
    public synchronized static ConnectionDB newInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        instance = null;
    }
}
