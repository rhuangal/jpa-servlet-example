<%-- 
    Document   : index
    Created on : Sep 15, 2017, 8:36:41 AM
    Author     : rober
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Ejemplo de Plantilla bootstrap</title>
        <!-- Bootstrap core CSS -->
        <%@include file="template/inc_css.jsp" %>
    </head>

    <body>

        <%@include file="template/header.jsp" %>

        <div class="row">
            <div class="col-md-12">
                <h2>Mis usuarios</h2>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="item">
                            <tr>
                                <td>${item.codigo}</td>
                                <td>
                                    <a href="#" class="btn btn-sm btn-danger">
                                        Eliminar
                                    </a>
                                    <a href="#" class="btn btn-sm btn-info">
                                        Actualizar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>        
            </div>
        </div>
        <hr>

        <%@include file="template/footer.jsp" %>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <%@include file="template/inc_js.jsp" %>
</body>
</html>

