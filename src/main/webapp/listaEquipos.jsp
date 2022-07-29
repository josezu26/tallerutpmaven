
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
            h1{
                margin-bottom: 2rem;
            }
            .principal{
                overflow: scroll;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarTecnico.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">

                        <h1>Lista de Equipos</h1>
                        <div>
                            <form action="ControladorTecnico">
                                <label>codigo del cliente:</label>
                                <input type="number" name="codigo" required pattern="[0-9]+">
                                <input type="submit" name="accion" value="ListarEquipoCliente">
                            </form>
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Marca</th>
                                    <th scope="col">Tipo</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Descripcion</th>
                                    <!-- <th scope="col">Estado</th>-->
                                    <th class="accion" scope="col">Acciones</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="listaEquipo" items="${listaEquipo}">
                                <tr>
                                    <td>${listaEquipo.getCodigoEquipo() }</td>
                                    <td>${listaEquipo.getMarcaEquipo().getDescripcionMarcaEquipo()}</td>
                                    <td>${listaEquipo.getTipoEquipo().getDescripcionTipoEquipo()}</td>
                                    <td>${listaEquipo.getUsuarioEquipo().getPersona().obtenerNombreCompleto() }</td>
                                    <td>${listaEquipo.getDescripcionEquipo()}</td>
                                    <td>${listaEquipo.getEstadoEquipo().getDescripcionEstadoEquipo()}</td>
                                    <td>
                                        <a style="color:#CE885E;" href="ControladorTecnico?accion=cambiarEstadoEquipo&codigoEquipo=${listaEquipo.getCodigoEquipo()}&codigoEstado=${listaEquipo.getEstadoEquipo().getCodigoEstadoEquipo()}"><i class="fas fa-edit"></i></a>
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

