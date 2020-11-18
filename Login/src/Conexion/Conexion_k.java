package Conexion;




import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion_k {
    
     Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/bd_repuestos"+
                    "?userTimezone=true&serverTimezone=UTC","root","");
            
            
          // System.out.print("Conexion exitosa...");
        } catch (Exception e) {
           
        }
        return conectar;
    }
    //Por aquello....
     public void Desconectar(){
        conectar=null;
        if(conectar==null){
          //  System.out.println("Conexion terminada...");
        }
    }
    
    
}