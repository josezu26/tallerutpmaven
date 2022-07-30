<%-- 
    Document   : prueba
    Created on : 18 jul. 2022, 15:05:06
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
            .principal {
                overflow : scroll;
                position : relative;
            }

            .boton-agregar {
                position : absolute;
                top : 5rem;
                right: 30rem;
                display : flex;
                flex-direction : column;
                gap : 1rem;
            }
            .boton-continuar {
                text-align: center;
                padding-bottom: 3rem;
            }
            
            .boton-agregar a,
            .boton-continuar a {
                font-size: 1.3rem;
            }
            .boton-eliminar {
                text-decoration: none;
                color : red;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="../sidebar/sidebarTecnico.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">

                        <div class="informacion">
                            <h1>Detalle de la consulta</h1>
                        
                            <p>Codigo de la hoja de servicio : ${hojaServicio.getCodigoHojaServicio() }</p>
                            <p>Cliente : ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getNombre()}
                                ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getApellidoPaterno()}
                                ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getApellidoMaterno()}
                            </p>
                            <p><b>Telefono Cliente : ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getTelefono()}</b></p>
                            <p>Tecnico : ${hojaServicio.getTecnicoHojaServicio().getPersona().getNombre()}
                                ${hojaServicio.getTecnicoHojaServicio().getPersona().getApellidoPaterno()}
                                ${hojaServicio.getTecnicoHojaServicio().getPersona().getApellidoMaterno()}
                            </p>
                            <p>Equipo : ${hojaServicio.getEquipoHojaServicio().getDescripcionEquipo()}</p>
                            <p><b>Distrito : ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getDireccion().getDistrito().getDescripcionDistrito()}</b></p>
                            <p><b>Direccion : ${hojaServicio.getEquipoHojaServicio().getUsuarioEquipo().getPersona().getDireccion().getDescripcionDireccion() }</b></p>
                            <p>Fecha : ${hojaServicio.getFechaHojaServicio() }</p>
                            <p>Hora : ${hojaServicio.getHoraHojaServicio() }</p>
                            <p>Estado de la visita: ${hojaServicio.getEstadoHojaServicio().getDescripcionEstadoHojaServicio() }</p>
                            <p>Total : ${hojaServicio.getTotal()}</p>
                        
                    </div>

                    <div class="boton-agregar">
                        <a href="ControladorTecnico?accion=agregarServicioBrindado&codigoHojaServicio=${codigoHojaServicio}" class="btn btn-success">Agregar un nuevo servicio</a>
                    </div>

                    <br><br>
                    <h2>Servicios solicitados</h2>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Precio</th>
                                <th style="text-align: center" scope="col">Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="servicio" items="${listaServiciosBrindados}">
                                <tr>
                                    <td>${servicio.getCodigoServicio() }</td>
                                    <td>${servicio.getNombreServicio() }</td>
                                    <td>${servicio.getDescripcionServicio()}</td>
                                    <td>${servicio.getPrecioServicio() }</td>
                                    <td style="text-align: center"><a class="boton-eliminar" href="ControladorTecnico?accion=eliminarServicioBrindado&codigoHojaServicio=${codigoHojaServicio}&codigoServicioBrindado=${servicio.getCodigoServicio()}"><i class="far fa-trash-alt"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>
