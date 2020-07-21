/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javi0
 */
public class Conexion {
    
    private String USERNAME = "usuarioDes5";
    private String PASSWORD = "1234";
    private String HOST = "DESKTOP-UH7R3KP";
    private String PORT = "1433";
    private String DATABASE = "ProyectoDes5";
    private String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL = "jdbc:sqlserver://"+HOST+":"+PORT+";DatabaseName="+ DATABASE;
    private Connection con;
    
    public Conexion(){
        try{
            
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
        }catch(ClassNotFoundException e){
            System.err.println("Error: " + e);
        }
        catch(SQLException e){
            System.err.println("Error: " + e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public static void main(String[] args){
        Conexion con = new Conexion();
        
        
    }
    
    
}
