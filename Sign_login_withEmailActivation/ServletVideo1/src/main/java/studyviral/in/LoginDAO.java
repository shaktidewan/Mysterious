/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 97798
 */
public class LoginDAO {
    
    String sql ="select * from usertable where email=? and pword=?";
    String url="jdbc:mysql://localhost:3306/email_validation";
    String username="root";
    String password="";
    
    public boolean check(String email,String pword){
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, username, password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pword);
            ResultSet rs= st.executeQuery();
            if(rs.next())
            {
                return true;
            }
        
        }catch(Exception e){
        e.printStackTrace();
        }
        
    
    return false;
    }
    
}
