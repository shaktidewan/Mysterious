/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 97798
 */
public class SendingEmail {
   
    private String userEmail;
    private String myHash;

    public SendingEmail(String userEmail, String myHash) {
        this.userEmail = userEmail;
        this.myHash = myHash;
    }
    
    public void sendMail(){
    
         final String email ="np03a180169@heraldcollege.edu.np";
         final String pword ="";//your mail password
      
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        //error changed xa hai yaha
        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email, pword);
            }            
        });
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message.setSubject("StudyViral in Email verification link");
            message.setText("Verification link...");
            message.setText("Your verification Link: "+ "http://localhost:8080/ServletVideo1/ActivateAccount?key1="+userEmail+"&key2="+myHash);
            Transport.send(message);
            
        }
        catch(Exception ex){
            System.out.println("SendingMail...."+ex);
        }

        
    }
}
