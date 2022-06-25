<%-- 
    Document   : agregarEquipo
    Created on : 10 jun. 2022, 01:50:51
    Author     : Jose
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TALLER UTP</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/b528f7619b.js" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./css/sidebar.css">
        <style>
            form {
                margin : 4rem auto 0;
                width: 50%;
            }
            .form-control {
                font-size: 1.6rem;
            }
            .form-select {
                font-size: 1.6rem;
            }
            form input:last-child{
                margin-top:3rem;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarCliente.jsp"></jsp:include>
            </div>

            <div class="principal">
                <div class="general">
                    <h1 style="text-align: center">Agregar nuevo Equipo</h1>

                    <form class="formulario" action="ControladorCliente">

                        <label class="form-label" for="codigoMarca">Marca del equipo: </label>
                        <select class="form-select" name="codigoMarca">
                            <c:forEach var="marca" items="${listaMarcas}">
                                <option value="${marca.getCodigoMarcaEquipo() }">${marca.getDescripcionMarcaEquipo()}</option>
                            </c:forEach>
                        </select>
                        <label class="form-label" for="codigoTipo">Tipo de equipo </label>
                        <select class="form-select" name="codigoTipo">
                            <c:forEach var="tipo" items="${listaTipos}">
                                <option value="${tipo.getCodigoTipoEquipo() }">${tipo.getDescripcionTipoEquipo()}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="codigoCliente" value="${usuario.getCodigoUsuario()}">

                        <label class="form-label" for="descripcionEquipo">Ingresa la descripcion del equipo:</label>
                        <textarea class="form-control" name="descripcionEquipo" maxlength="200" cols="40" rows="5" style="resize: none;"></textarea>
                        <input type="submit" name="accion" value="agregarEquipo">
                    </form>   
                </div>
            </div>
        </main>
    </body>
</html>
