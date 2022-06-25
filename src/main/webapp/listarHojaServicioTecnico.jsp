<%-- 
    Document   : listarHojaServicioTecnico
    Created on : 23 jun. 2022, 12:32:21
    Author     : Usuario
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
                <jsp:include page="./sidebar/sidebarTecnico.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">

                        <h1>Lista de Hojas de Servicio Tecnico</h1>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Tecnico</th>
                                    <th scope="col">Equipo</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Hora</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="hojaServicio" items="${listaHojaServicioTecnico}">
                                <tr>
                                    <td>${hojaServicio.getCodigoHojaServicio() }</td>
                                    <td>${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getNombre() }</td>
                                    <td>${hojaServicio.getTecnicoHojaServicio().getPersona().getNombre() }</td>
                                    <td>${hojaServicio.getEquipoHojaServicio().getDescripcionEquipo() }</td>
                                    <td>${hojaServicio.getFechaHojaServicio() }</td>
                                    <td>${hojaServicio.getHoraHojaServicio() }</td>
                                    <td>${hojaServicio.getEstadoHojaServicio().getDescripcionEstadoHojaServicio() }</td>
                                    <td>${hojaServicio.getTotal()}</td>
                                    <td><a href="ControladorTecnico?accion=procesar&codigoHojaServicio=${hojaServicio.getCodigoHojaServicio()}"><i class="fas fa-wrench"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>