<%-- 
    Document   : index
    Created on : Sep 15, 2017, 8:36:41 AM
    Author     : rober
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Hello, world!</h1>
                <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
            </div>
        </div>
        <div class="container">
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4">
                    <h2>Heading</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Heading</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Heading</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h2>Mi formulario</h2>
                    <form>
                        <div class="form-group"> <!-- Name field -->
                            <label class="control-label " for="name">Nombre</label>
                            <input class="form-control" id="name" name="name" type="text"/>
                        </div>
                        <div class="form-group"> <!-- Email field -->
                            <label class="control-label requiredField" for="email">Correo<span class="asteriskField">*</span></label>
                            <input class="form-control" id="email" name="email" type="text"/>
                        </div>
                        <div class="form-group"> <!-- Subject field -->
                            <label class="control-label " for="subject">Titulo</label>
                            <input class="form-control" id="subject" name="subject" type="text"/>
                        </div>
                        <div class="form-group"> <!-- Message field -->
                            <label class="control-label " for="message">Mensaje</label>
                            <textarea class="form-control" cols="40" id="message" name="message" rows="10"></textarea>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary " name="submit" type="submit">Enviar</button>
                        </div>
                    </form>	
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

