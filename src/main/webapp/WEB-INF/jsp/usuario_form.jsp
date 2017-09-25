<%-- 
    Document   : categoria_form
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

        <div class="container-header">
            <section class="content-header">
                <h1>
                    Opción Usuario
                    <small>administración de usuarios</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                    <li><a href="#">Usuario</a></li>
                    <li class="active"><c:out value="${operacion}" /></li>
                </ol>
            </section>
        </div>

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h2><c:out value="${operacion}" /> Registro</h2>
                    <form action="<c:url value="/usuario/submit" />" method="POST">
                        <div class="form-group"> <!-- Name field -->
                            <label class="control-label" for="name">Usuario</label>
                            <input type="text" id="codigo" name="codigo" value="<c:out value="${usuario.codigo}" />" class="form-control" 
                                   <c:if test="${operacion == 'Editar'}">readonly="true" </c:if>  required>
                        </div>
                        <div class="form-group"> <!-- Name field -->
                            <label class="control-label" for="name">Contraseña</label>
                            <input type="password" id="password" name="password" value="<c:out value="${usuario.password}" />" class="form-control" required>
                        </div>
                        <input type="hidden" name="strategy" value="<c:out value="${operacion}" />" >
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit">Guardar</button>
                        </div>
                    </form>
                    <c:if test="${sessionScope.resultado > 0}">
                        <div class="alert alert-success">
                            <strong>Exito!</strong> El registro se procesó correctamente.
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.resultado == 0}">
                        <div class="alert alert-danger">
                            <strong>Peligro!</strong>No se pudo procesar el registro.
                        </div>
                    </c:if>    
                    <c:remove var="resultado" scope="session" />                   
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

