<%-- 
    Document   : listarTecnicos
    Created on : 10 jun. 2022, 00:59:54
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

                        <h1>Lista de Tecnicos</h1>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido Paterno</th>
                                    <th scope="col">Apellido Materno</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">accion</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cliente" items="${listaClientes}">
                                <tr>
                                    <td>${cliente.getCodigoUsuario() }</td>
                                    <td>${cliente.getPersona().getNombre() }</td>
                                    <td>${cliente.getPersona().getApellidoPaterno() }</td>
                                    <td>${cliente.getPersona().getApellidoMaterno() }</td>
                                    <td>${cliente.getPersona().getEspecialidad().getDescripcionEspecialidad() }</td>
                                    <td>
                                        <a style="color:#CE885E;" href="ControladorAdmin?accion=modificarCliente&codigo=${cliente.getCodigoUsuario() }"><i class="fas fa-edit"></i></a>
                                        <a style="color:red;" href="ControladorAdmin?accion=eliminarCliente&codigo=${cliente.getCodigoUsuario() }"><i class="fas fa-trash"></i></a>
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