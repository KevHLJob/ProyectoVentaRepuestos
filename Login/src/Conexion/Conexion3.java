/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.beans.Statement;    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author justi
 */
public class Conexion3 {
    private Statement sql;
    static String bd ="bd_repuestos";
    static String login ="root";
    static String password ="";
    static String url ="jdbc:mysql://localhost/"+bd;
    static Connection conn=null;

    public static Connection getConn() {
        return conn;
    }
    
    public static void conn() throws Exception{
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn= DriverManager.getConnection(url, login, password);
            
            if(conn!= null){
                System.out.println("Conexion exitosa"); 
            }
        }
        
    catch(SQLException ex){
            System.out.println("Error"+url);
}
 catch(ClassNotFoundException ex){
            System.out.println("ex");
}
}


}
