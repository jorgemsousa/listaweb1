
package controler;

import entidades.Alunos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
      static final String DATABASE_URL = "jdbc:mysql://localhost/listaweb1";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String turma = request.getParameter("id");
            String disciplina = request.getParameter("id1");
            String nome = request.getParameter("id2");
            String hora = request.getParameter("id3");
            
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "root" );
	    Statement state = conn.createStatement();
            
                       
      out.println("<html>");
          out.println("<head>");
            out.println("<title>Detalhes</title>");
            out.println("<link href=\"frameworks/bootstrap-3.3.7-dist/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<script src=\"frameworks/bootstrap-3.3.7-dist/js/bootstrap.min.js\" type=\"text/javascript\"></script>");
          out.println("</head>");
            out.println("<body>");
       
            out.println("<div class=\"container\">");
                        
            out.println("<div class=\"alert alert-info\" role=\"alert\">");
            out.println("<strong>Programação WEB -</strong> Prof. Monteiro</div>");
            
            out.println("<div class='panel panel-primary'>");
                 out.println("<div class='panel-heading'>Disciplina</div>");
                 out.println("<table class='table'>");
                     out.println("<thead>");
                         out.println("<tr class='info'>");
                             out.println("<td><strong>Cod. Disiciplina:  </strong>"+ disciplina +"</td>");
                             out.println("<td><strong>Nome Disciplina:  </strong>"+ nome +"</td>");
                             out.println("<td><strong>Carga Horária:  </strong>"+ hora +"</td>");
                         out.println("</tr>");
                     out.println("</thead>");
                 out.println("</table>");
             out.println("</div>");
             
             ResultSet result = state.executeQuery("select * FROM alunos where turmas_idturma = '"+ turma +"' and turmas_disciplinas_iddisciplina = '"+ disciplina +"'");
            
	        out.println("<div class=\"panel panel-primary\">");
                out.println("<div class=\"panel-heading\">Alunos Matriculados</div>");
                    out.println("<table class='table table-bordered' style='text-align: center'>");
                    out.println("<thead>");
	            out.println("<tr class=\"info\"><td><b>Matrícula</b></td><td><b>Nome do Aluno</b></td><td><b>Turma</b></td><td><b>Disciplina</b></td><td><b>Curso</b></td></tr></thead>");
                        while(result.next()) {
                            out.println("<tr><td>"+ result.getString(1) + "</td>");
                            out.println ("<td>"+result.getString(2)+ "</td>");
                            out.println ("<td>"+result.getString(3)+ "</td>");
                            out.println ("<td>"+result.getString(4)+ "</td>");
                            out.println ("<td>"+result.getString(5)+ "</td></tr>");
                        }     
                    out.println("</table>");
                out.println("</div>");
	            state.close();
                    out.println("<div class=\"panel panel-default\">");
                    out.println("<div class=\"panel-body\">");
	            out.println("<a class=\"btn btn-default\" href=\"/listaweb1/Servlet1\" role=\"button\">Voltar</a>");
	            out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<script src=\"frameworks/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>");
                    out.println("</body>");
     out.println("</html>");
//           request.setAttribute("lista", lista);
//           request.getRequestDispatcher("/detalhes.jsp").forward(request, response);
            
        } catch (SQLException ex) {
              Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
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
