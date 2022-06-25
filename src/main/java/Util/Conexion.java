package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jose
 */
public class Conexion {
    
    Connection con;
    
    String url = "jdbc:mysql://localhost:3306/tallerutp";
    String user = "root";
    String password = "";
    
    public Connection getConnection(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
                    
        } catch (Exception e){
            
        }
        
        return con;
    }
    
}
