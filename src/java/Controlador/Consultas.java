/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Curiosidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javi0
 */


/*
Extendemos de la clase Conexion para utilizar sus metodos
Y para que el constructor se inicialize solo
*/
public class Consultas extends Conexion{

    public List<Curiosidades> consultar(String tabla){
        
        PreparedStatement  pst = null;
        //ResultSet para hacer consulta
        ResultSet rs = null;
        
        List<Curiosidades> lista =  new ArrayList<Curiosidades>();
        try{

            //Creamos QUERY
            String consulta = "SELECT*FROM "+tabla;

            pst = getConexion().prepareStatement(consulta);
            //Guardamos la consulta
            rs = pst.executeQuery();
             
            //Si tiene un registro procedemos
            while(rs.next()){
                Curiosidades obj = new Curiosidades();
                obj.setDescripcion(rs.getString("curiosidad"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setId(rs.getInt("id"));
               
                lista.add(obj);
            }  
           
            return lista;
            
        }catch(Exception e){
            System.err.println("Error ??????: "+e);
        }finally{

                try{
                    //Cerramos todas las conexiones.
                    if(getConexion() != null) getConexion().close();

                    if(pst != null) pst.close();

                    if(rs != null) rs.close();

                }catch(Exception e){
                    System.err.println("Error: "+e);
                }
        }
        return lista;
    }
    
    public ArrayList<String> consultarIMG(String tabla){
         
        PreparedStatement  pst = null;
        //ResultSet para hacer consulta
        ResultSet rs = null;
        
        ArrayList<String> lista =  new ArrayList<String>();
        try{

            //Creamos QUERY
            String consulta = "SELECT*FROM "+tabla;

            pst = getConexion().prepareStatement(consulta);
            //Guardamos la consulta
            rs = pst.executeQuery();
             
            //Si tiene un registro procedemos
            while(rs.next()){
                lista.add(rs.getString("ruta"));
            }  
           
            return lista;
        }catch(Exception e){
            System.err.println("Error ??????: "+e);
        }finally{

                try{
                    //Cerramos todas las conexiones.
                    if(getConexion() != null) getConexion().close();

                    if(pst != null) pst.close();

                    if(rs != null) rs.close();

                }catch(Exception e){
                    System.err.println("Error: "+e);
                }
        }
        return lista;
    }
    
    
}
