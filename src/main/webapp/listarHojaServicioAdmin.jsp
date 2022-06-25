<%-- 
    Document   : listarHojaServicioAdmin
    Created on : 11 jun. 2022, 01:33:30
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
            .cabecera {
                display : flex;
                justify-content: space-between;
            }
            .cabecera form {
                width: 25%;
                display : flex;
                justify-content: space-between;
            }
            .cabecera form select {
                font-size: 1.6rem;
                margin-right: 1rem;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">
                        <div class="cabecera">
                            <h1>Lista de Hojas de Servicio Administrador</h1>
                            <form action="ControladorAdmin">
                                <select name="codigoEstado" class="form-select">
                                    <option value="1">Pendientes</option>
                                    <option value="2">Verificados</option>
                                    <option value="3">Finalizados</option>
                                </select>
                                <input type="submit" name="accion" value="Filtrar">
                            </form>
                        </div>

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
                            <c:forEach var="hojaServicio" items="${listaHojaServicio}">
                                <tr>
                                    <td>${hojaServicio.getCodigoHojaServicio() }</td>
                                    <td>${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getNombre() }</td>
                                    <td>${hojaServicio.getTecnicoHojaServicio().getPersona().getNombre() }</td>
                                    <td>${hojaServicio.getEquipoHojaServicio().getDescripcionEquipo() }</td>
                                    <td>${hojaServicio.getFechaHojaServicio() }</td>
                                    <td>${hojaServicio.getHoraHojaServicio() }</td>
                                    <td>${hojaServicio.getEstadoHojaServicio().getDescripcionEstadoHojaServicio() }</td>
                                    <td>${hojaServicio.getTotal()}</td>
                                    <td><a href="ControladorAdmin?accion=procesar&codigoHojaServicio=${hojaServicio.getCodigoHojaServicio()}"><i class="fas fa-wrench"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>
