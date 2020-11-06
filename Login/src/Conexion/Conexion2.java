/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author justi
 */
public class Conexion2 {
      Connection conectar2=null;
    
    public Connection conectar(){
        try{

//CONEXION DE JUSTIN PARA LA FACTURA

            Class.forName("com.mysql.jdbc.Driver");//TRABAJA CON EL DRIVER QUE ME FUNCIONA A MI (JUSTIN) 5.1.13
            conectar2=DriverManager.getConnection("jdbc:mysql://localhost/db_sistema"+
                    "?userTimezone=true&serverTimezone=UTC","root","1234");//COLOQUÉ MI PUERTO 3305
            
            System.out.println("Conexion exitosa");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conectar2;
    }
    
    public void Desconectar(){
        conectar2=null;
        if(conectar2==null){
            System.out.println("Conexion terminada...");
        }
    }
}


