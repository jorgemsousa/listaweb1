<%-- 
    Document   : listar
    Created on : 21/09/2017, 20:07:41
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored ="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplinas Ofertadas</title>
        <link href="frameworks/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="frameworks/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="alert alert-info" role="alert">
                <strong>Programação WEB -</strong> Prof. Monteiro
            </div>
               <div class="panel panel-primary">
                   <div class="panel-heading">Disciplinas Ofertadas</div>
                        
                   <table class="table table-hover table-bordered container-fluid" style="text-align: center" >
                                <thead>
                                    <tr class="info">
                                    <td><strong>Cod. Disciplina</strong></td>
                                    <td><strong>Nome Disciplina</strong></td>
                                    <td><strong>Carga Horária</strong></td>
                                    <td><strong>Turma</strong></td>
                                    <td><strong>Horario - 1</strong></td>
                                    <td><strong>Horario - 2</strong></td>
                                    <td><strong>Horario - 3</strong></td>                                    
                                    <td><strong>Selecionar</strong></td>
                                </tr>
                                </thead>
                                <tr>
                                    <c:forEach var="inc" items="${lista}" varStatus="meuIndex" >
                                    <tr>
                                        <td>
                                            <c:out value="${inc.iddisciplina}"></c:out>
                                        </td> 
                                        <td>
                                            <c:out value="${inc.nomedisciplina}"></c:out>
                                        </td>  
                                        <td>
                                            <c:out value="${inc.cargahoraria}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${inc.idturma}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${inc.horario1}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${inc.horario2}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${inc.horario3}"></c:out>
                                        </td>
                                        
                                        <td>                                           
                                            
                                            <a href="/listaweb1/Servlet2?id=${inc.idturma}&id1=${inc.iddisciplina}&id2=${inc.nomedisciplina}&id3=${inc.cargahoraria}"> 
                                                <input  type="radio" name="radio" value="radio ${meuIndex.index}" aria-label="...">  	
                                            </a>
                                        </td> 
                                        
                                    </tr>                                    
                                    </c:forEach>
                                    
                                </tr>
                            </table>  
                        
                    </div>
                     <div class="panel panel-default">
                      <div class="panel-body">
                        <div><a class="btn btn-default" href="/listaweb1/index.html" role="button">Sair do Sistema</a></div>
                      </div>
                    </div>
                                 
                </div>  
       
            
        
        </div>  
                 
        
        <script src="frameworks/jquery-3.2.1.min.js" type="text/javascript"></script>
    </body>
</html>
