/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class Oracle { 
    private String driver, user, pass;
    private Connection conn;

    public Connection getConnection() {
        return this.conn;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }    

    public Oracle(String driver, String user, String pass) {
        this.driver = driver;
        this.user = user;
        this.pass = pass;
    }
    
    public Oracle(String user, String pass) {
        this.driver = "jdbc:oracle:thin:@localhost:1521:orcl";
        this.user = user;
        this.pass = pass;
    }
    
    public boolean openConnection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            this.conn = DriverManager.getConnection(this.driver, this.user, this.pass);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean closeConnection() {
        try {
            this.conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static void main(String args[]) {
        Oracle conexion = new Oracle("NIGHTSHADE", "natalia");
        
        if(conexion.openConnection()) {
            System.out.println("Todo ok");
        } else {
            System.out.println("Error!");
        }
    }
    
   
}