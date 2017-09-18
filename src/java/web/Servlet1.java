/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

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
 * @author Jorge
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    static final String DATABASE_URL = "jdbc:mysql://localhost/listaweb1";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Connection conn;
            String disciplina = request.getParameter("disciplina");
            String saida = null;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Disciplinas</title>");
            
            out.println("</head>");
            out.println("<body>");
       
            out.println("<h1>Consultando um database MySql</h1>");
            out.println("<h2>Tabela Alunos</h2>");
	       try {
	            Class.forName( JDBC_DRIVER );
	            conn = DriverManager.getConnection( DATABASE_URL, 
                            "root", "root" );
	            Statement st = conn.createStatement();
	            ResultSet rec = st.executeQuery("SELECT * FROM disciplinas");
                    out.println("<table border=1><tr>");
	            out.println("<td><b>Disciplina</b></td><td><b>Nome da Disciplina</b></td><td><b>Carga Horária</b></td>" +
                        "</tr>");
	            while(rec.next()) {
	                out.println("<tr><td>"+ rec.getString(1) + "</td>");
	                out.print("<td>"+rec.getString(2)+ "</td>");  
	                out.println("<td>"+rec.getString(3)+ "</td></tr>");
                    }
                    out.println("</table>");
	            st.close();
	        } catch (SQLException s) {
	            out.println("SQL Error: " + s.toString() + " "
	                + s.getErrorCode() + " " + s.getSQLState());
	        } catch (Exception e) {
	            out.println("Error: " + e.toString()
	                + e.getMessage());
	        }
	    
        out.println("</body>");
        out.println("</html>");
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
