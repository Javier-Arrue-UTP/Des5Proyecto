/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Curiosidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javi0
 */


/*
Extendemos de la clase Conexion para utilizar sus metodos
Y para que el constructor se inicialize solo
*/
public class Consultas extends Conexion{


    public boolean autenticacion(String username, String password){

        PreparedStatement  pst = null;
        //ResultSet para hacer consulta
        ResultSet rs = null;


        try{

            //Creamos QUERY
            String consulta = "SELECT*FROM usuarios "
                    + "where nickName= ? and contraseña= ?";

            pst = getConexion().prepareStatement(consulta);
            pst.setString(1,username);
            pst.setString(2,password);

            //Guardamos la consulta
            rs = pst.executeQuery();

            //Si tiene un registro procedemos
            if(rs.next()){
                return true;
            }

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


        //Si no encuentra el usuario retorna un FALSE.
        return false;
    }


    public List<Curiosidades> consultar(){
        
        PreparedStatement  pst = null;
        //ResultSet para hacer consulta
        ResultSet rs = null;
        
        List<Curiosidades> lista =  new ArrayList<Curiosidades>();
        try{

            //Creamos QUERY
            String consulta = "SELECT*FROM prueba";

            pst = getConexion().prepareStatement(consulta);
            //Guardamos la consulta
            rs = pst.executeQuery();
             
            //Si tiene un registro procedemos
            while(rs.next()){
                Curiosidades obj = new Curiosidades();
                obj.setDescripcion(rs.getString("descripcion"));
               
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
    
    
}
