
package bank.management.system;
import java.sql.*;
/**
 *
 * @author Shubham Funde
 */
public class Conn {
    
    Connection c ;
    Statement s;
    
    public Conn(){
        try{
           // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmngmntsstm","root","admin");
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
