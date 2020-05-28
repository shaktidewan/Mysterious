/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

/**
 *
 * @author 97798
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDAO {
    
    public RegisterDAO(){}
    
    public String RegisterUser(RegisterBean rb){
         String fname = rb.getFname();
         String lname = rb.getLname();
         String email = rb.getEmail();
         String pword = rb.getPword();
         String myhash = rb.getMyhash();

         Connection con = MyConnection.getConnection();
         try{
             
             String sqlQuery= "insert into usertable (fname,lname,email,pword,hash) values (?,?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(sqlQuery);
             pst.setString(1, fname);
             pst.setString(2, lname);
             pst.setString(3, email);
             pst.setString(4, pword);
             pst.setString(5, myhash);
             
             int i = pst.executeUpdate();
             if(i !=0){
                 //Sending Email code
                 SendingEmail se= new SendingEmail(email,myhash); 
                 se.sendMail();//yo Sending mail banayepaaxi lekheko hai
                 return "SUCCESS";
             }   
         }catch(Exception ex){
             System.out.println("RegisterDAO file"+ex);
         }
         
        return "error";
    }
    
}
