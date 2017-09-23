/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import entidades.Disciplinas;
import entidades.Turmas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        PrintWriter out = response.getWriter();
        String matricula = request.getParameter("matricula");
        
        try {
	    Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "root" );
	    Statement state = conn.createStatement();
          
            //ResultSet resultado = state.executeQuery("SELECT * FROM alunos WHERE matricula =" + matricula );
            // processa resultados da consulta
            
               ResultSet resultado = state.executeQuery("SELECT * FROM disciplinas, turmas WHERE iddisciplina = disciplinas_iddisciplina");
                
                
//                Turmas turma;
//                ArrayList<Turmas> lista = new ArrayList<>();
//                
//                while(resultado.next()){
//                   turma = new Turmas();                   
//                   
//                   turma.setIdturma(resultado.getString(2));
//                   turma.setHorario1(resultado.getString(3));
//                   turma.setHorario2(resultado.getString(4));
//                   turma.setHorario3(resultado.getString(5));
//                   
//                   
//                   lista.add(turma);
//                }                
               
                Disciplinas disc;          
                ArrayList lista = new ArrayList<>();
                 
                while(resultado.next()){
                    
                    disc = new Disciplinas();
                   
                    
                    disc.setIddisciplina(resultado.getString(1));
                    disc.setNomedisciplina(resultado.getString(2));
                    disc.setCargahoraria(resultado.getString(3));
                    disc.setIdturma(resultado.getString(4));
                    disc.setHorario1(resultado.getString(5));
                    disc.setHorario2(resultado.getString(6));
                    disc.setHorario3(resultado.getString(7));
                    
                    
                    lista.add(disc);
                    
                    
               }
                
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/listar.jsp").forward(request, response);
                
                   
            
            state.close();
	    } catch (SQLException s) {
	      out.println("SQL Error: " + s.toString() + " "
	                + s.getErrorCode() + " " + s.getSQLState());
	    } catch (Exception e) {
	      out.println("Error: " + e.toString() + e.getMessage());
	    }
                      
            out.close();
        
    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            Connection conn;
//            String matricula = request.getParameter("matricula");
//            
//            
//            
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Lista de Disciplinas</title>");
//            
//            out.println("<link href='frameworks/bootstrap-3.3.7-dist/css/bootstrap.min.css' rel='stylesheet' type='text/css'/>");
//            out.println("<script src='frameworks/bootstrap-3.3.7-dist/js/bootstrap.min.js' type='text/javascript'></script>");
//            out.println("</head>");
//            out.println("<body>");
//            
//            out.println("<div class='container'>");
//            
//            out.println("<div class=\"alert alert-info\" role=\"alert\"><strong>Programação WEB -</strong> Prof. Monteiro</div>");
//            out.println("<div class=\"panel panel-primary\">");
//            out.println("<div class=\"panel-heading\">Listagem das Disciplinas</div>");
//            out.println("<div class=\"panel-body\">");
//            
//	       try {
//	            Class.forName( JDBC_DRIVER );
//	            conn = Conexao.getConnection();
//	            Statement st = conn.createStatement();
//	            ResultSet rec = st.executeQuery("SELECT * FROM disciplinas");
//                    out.println("<table class='table table-bordered' style='text-align: center'><tr>");
//	            out.println("<td><b>Disciplina</b></td><td><b>Nome da Disciplina</b></td><td><b>Carga Horária</b></td>" +
//                        "</tr>");
//	            while(rec.next()) {
//	                out.println("<tr><td>"+ rec.getString(1) + "</td>");
//	                out.print("<td>"+rec.getString(2)+ "</td>");  
//	                out.println("<td>"+rec.getString(3)+ "</td></tr>");
//                    }
//                    out.println("</table>");
//	            st.close();
//	        } catch (SQLException s) {
//	            out.println("SQL Error: " + s.toString() + " "
//	                + s.getErrorCode() + " " + s.getSQLState());
//	        } catch (ClassNotFoundException e) {
//	            out.println("Error: " + e.toString()
//	                + e.getMessage());
//	        }
//               out.println("</div>");
//               out.println("</div>");
//               out.println("</div>");
//	out.println("</div>");
//        out.println("<script src=\"frameworks/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>");
//        out.println("</body>");
//        out.println("</html>");
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
