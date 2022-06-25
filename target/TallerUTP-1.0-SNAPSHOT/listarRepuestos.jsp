<%-- 
    Document   : listarRepuestos
    Created on : 9 jun. 2022, 23:38:45
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
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">

                        <h1>Lista de Repuestos</h1>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="repuesto" items="${listaRepuestos}">
                                <tr>
                                    <td>${repuesto.getCodigoRepuesto() }</td>
                                    <td>${repuesto.getNombreRepuesto() }</td>
                                    <td>${repuesto.getDescripcionRepuesto() }</td>
                                    <td>${repuesto.getPrecioRepuesto() }</td>
                                    <td>${repuesto.getStockRepuesto() }</td>
                                    <td>
                                        <a style="color:#CE885E;" href="ControladorAdmin?accion=modificarRepuesto&codigoRepuesto=${repuesto.getCodigoRepuesto()}"><i class="fas fa-edit"></i></a>
                                        <a style="color:red;" href="ControladorAdmin?accion=eliminarRepuesto&codigoRepuesto=${repuesto.getCodigoRepuesto()}"><i class="fas fa-trash"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>
