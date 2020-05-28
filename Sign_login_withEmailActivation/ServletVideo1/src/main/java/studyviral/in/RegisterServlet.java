/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyviral.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author 97798
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})//No need to edit
public class RegisterServlet extends HttpServlet {

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
        try {//(PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String fname=request.getParameter("fname");
           String lname=request.getParameter("lname");
           String email=request.getParameter("email");
           String pword=request.getParameter("pword");
           String newPword= DigestUtils.md5Hex(pword);// Digest come from commons-codec- jar
           //Generate Hash Code which helps in Activation Link
           
           String myHash; 
           Random random = new Random();
           random.nextInt(999999);
           myHash = DigestUtils.md5Hex(""+random);
           
           //Create Data bean Now
           
           RegisterBean rb= new RegisterBean();
           rb.setFname(fname);
           rb.setLname(lname);
           rb.setEmail(email);
           rb.setPword(newPword);
           rb.setMyhash(myHash);
           
           //Create DAO file
           
           RegisterDAO regDao = new RegisterDAO();
           String str = regDao.RegisterUser(rb);
           if(str.equals("SUCCESS")){
               response.sendRedirect("verify.jsp");
           }else{
               response.sendRedirect("index.jsp");
           }
                      
        }catch(Exception ex){
            System.out.println("ResisterDAO file "+ex);
        }
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
