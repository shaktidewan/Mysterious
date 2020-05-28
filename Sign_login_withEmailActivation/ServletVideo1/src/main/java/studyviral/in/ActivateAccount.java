/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 97798
 */
@WebServlet(name = "ActivateAccount", urlPatterns = {"/ActivateAccount"})
public class ActivateAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        processRequest(request, response);
    
        String email = request.getParameter("key1");
        String hash = request.getParameter("key2");
        
        Connection con = MyConnection.getConnection();
        
        try{
            PreparedStatement pst = con.prepareStatement("SELECT email,hash, active FROM usertable WHERE email=? AND hash=? AND active='0'");
            pst.setString(1, email);
            pst.setString(2, hash);
            ResultSet rs=pst.executeQuery();
                if(rs.next()){
                        
                    PreparedStatement pst1=con.prepareStatement("UPDATE usertable SET active='1' WHERE email=? AND hash=?");
                    pst1.setString(1, email);
                    pst1.setString(2, hash);
                    int i =pst1.executeUpdate();
                    if(i==1){
                        response.sendRedirect("login.jsp");
                    }else{
                        response.sendRedirect("index.jsp");
                    }
                }
            
            
        }catch(Exception ex){
            System.out.println("ActivateAccount FIle::"+ex);
            
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
