<%-- 
    Document   : detalhes
    Created on : 23/09/2017, 08:58:38
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes</title>
        <link href="frameworks/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="frameworks/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
         <div class="container">
            <div class="alert alert-info" role="alert">
                <strong>Programação WEB -</strong> Prof. Monteiro</div>
             
             <div class="panel panel-primary">
                 <div class="panel-heading">Disciplina</div>
                 <table class="table">
                     <thead>
                         <tr class="info">
                             <td><strong>Cod. Disiciplina:</strong></td>
                             <td><strong>Nome Disciplina:</strong></td>
                             <td><strong>Carga Horária:</strong></td>
                         </tr>
                     </thead>
                 </table>
             </div>
             
               <div class="panel panel-primary">
                   <div class="panel-heading">Alunos Matriculados</div>
                     
                     <table class="table table-hover table-bordered container-fluid" style="text-align: center" >
                                <thead>
                                    <tr class="info">
                                    <td><strong>Matricula</strong></td>
                                    <td><strong>Nome Aluno</strong></td>
                                                                       
                                </tr>
                                </thead>
                                <tr>
                                    <c:forEach var="inc" items="${lista}" varStatus="meuIndex" >
                                    <tr>
                                        <td>
                                            <c:out value="${inc.matricula}"></c:out>
                                        </td> 
                                        <td>
                                            <c:out value="${inc.nome}"></c:out>
                                        </td>  
                                        
                                                                                
                                    </tr>                                    
                                    </c:forEach>
                                    
                                </tr>
                            </table> 
                                  
                    </div>
                                 
                </div>  
             
        </div>  
                 
        <div class="footer">
            
        </div>
        <script src="frameworks/jquery-3.2.1.min.js" type="text/javascript"></script>
    </body>
</html>
