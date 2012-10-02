/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import config.Configuracion;
import config.ListaConfiguracion;
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
        ListaConfiguracion configuraciones = Configuracion.cargarConfiguracion("mysql.xml");
        Mysql conexion = new Mysql(
                (String) configuraciones.getPorIdentificador("mysql_server").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_port").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_db").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_user").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_password").getValor()
                );
        
        if(conexion.openConnection()) {
            System.out.println("Todo ok");
        } else {
            System.out.println("Error!");
        }
        
        try {
            Statement stmt = conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM estructura_campo_entidad");
            
            while(rs.next()) {
                System.out.println("id: "+rs.getInt(1)+" identificador: "+rs.getString(2)+" tipo: "+rs.getString(3));
            }
        } catch (Exception e) {
        }
    }
    
   
}