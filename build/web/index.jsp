<%-- 
    Document   : index
    Created on : 19/09/2017, 17:19:20
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>listaweb1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        
        <link href="frameworks/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="frameworks/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="alert alert-info" role="alert"><strong>Programação WEB -</strong> Prof. Monteiro</div>
              <div class="panel panel-primary">
                <div class="panel-heading">Consultar Aluno</div>
                <div class="panel-body">
                    <div class="well well-lg">             
                        <form class="form-inline" action="Servlet1" method="post">
                            <div class="form-group">
                              <label for="matricula">Matricula:</label>
                              <input type="number" class="form-control" id="matricula" required="true" placeholder="Somente Números">
                            </div>        
                            <button type="submit" class="btn btn-default">Consultar</button>
                        </form>
                    </div>
                 </div>
              </div>
        </div>     
    <script src="frameworks/jquery-3.2.1.min.js" type="text/javascript"></script>
    </body>
</html>
