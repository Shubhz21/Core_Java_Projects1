
import java.sql.*;
/**
 *
 * @author Shubham Funde
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","admin");
            s = c.createStatement();
        }catch(Exception er){
            er.printStackTrace();
        }
      
        
    }
    
}
