/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

/**
 *
 * @author 97798
 * 
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    static Connection con;
    
    public static Connection getConnection(){
    
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_validation", "root", "");
            
        }catch(Exception ex){
            System.out.println("From MyConnection Class"+ex);
        }
        return con;
    }
    
}
