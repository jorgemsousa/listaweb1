/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
        static final String DATABASE_URL = "jdbc:mysql://localhost/listaweb1";
        
        
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String matricula = request.getParameter("matricula");
        
        try {
	    Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "root" );
	    Statement state = conn.createStatement();        
                      
               ResultSet resultado = state.executeQuery(" SELECT * FROM alunos WHERE matricula = '"+matricula+"'");
                
               if(resultado.next()){
                   request.getRequestDispatcher("/Servlet1").forward(request, response);
               } 
               else{
                   request.getRequestDispatcher("/Erro.jsp").forward(request, response);
               }       
            
            state.close();
	    } catch (SQLException s) {
	      out.println("SQL Error: " + s.toString() + " "
	                + s.getErrorCode() + " " + s.getSQLState());
	    } catch (Exception e) {
	      out.println("Error: " + e.toString() + e.getMessage());
	    }
                   
            out.close();
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


