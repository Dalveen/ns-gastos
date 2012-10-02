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
public class Mysql { 
    private String driver, user, pass;
    private Connection conn;

    public Connection getConnection() {
        return this.conn;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }    

    public Mysql(String driver, String user, String pass) {
        this.driver = driver;
        this.user = user;
        this.pass = pass;
    }
    
    public Mysql(String server, String port, String db, String user, String pass) {
        this.driver = "jdbc:mysql://"+server+":"+port+"/"+db;
        this.user = user;
        this.pass = pass;
    }
    
    public Mysql(String server, String db, String user, String pass) {
        this.driver = "jdbc:mysql://"+server+"/"+db;
        this.user = user;
        this.pass = pass;
    }
    
    public boolean openConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
        Mysql conexion = new Mysql("localhost","gastos_v2","gastos", "natalia");
        
        if(conexion.openConnection()) {
            System.out.println("Todo ok");
        } else {
            System.out.println("Error!");
        }
        
        try {
            Statement stmt = conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EstructuraCampoEntidad");
            
            while(rs.next()) {
                System.out.println("id: "+rs.getInt(1)+" identificador: "+rs.getString(2));
            }
            System.out.println("Hola".getClass().getName());
        } catch (Exception e) {
        }
    }
    
   
}