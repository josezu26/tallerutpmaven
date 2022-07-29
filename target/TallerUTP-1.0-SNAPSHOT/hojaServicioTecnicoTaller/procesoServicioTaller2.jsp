
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet" href="../css/sidebar.css">
        <style>
            .form-control {
                font-size: 1.6rem;
            }
            .form-select {
                font-size: 1.6rem;
            }
            .general {
                width:95%;
            }
            .informacion {
                width: 100%;
                display : flex;
                gap : 3rem;
            }
            .formulario-derecha{
                padding: 2rem;
                margin-top: 3rem;
                border-radius: 1rem;
                outline : 1px solid #cecece;
            }
            .formulario-derecha textarea{
                resize: none;
            }
            .formulario-derecha .form-select{
                margin-bottom: 2rem;
            }
            form input:last-child{
                margin-top:3rem;
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

                    <h1>Detalles</h1>

                    <div class="informacion">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="servicio" items="${carritoServicios}">
                                    <tr>
                                        <td>${servicio.getCodigoServicio() }</td>
                                        <td>${servicio.getNombreServicio()}</td>
                                        <td>${servicio.getDescripcionServicio()}</td>
                                        <td>${servicio.getPrecioServicio() }</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="formulario-derecha">
                            <form action="ControladorTecnico">
                                <label class="form-label" for="codigoTecnico">Seleccione el tecnico:</label>
                                <select name="codigoTecnico" class="form-select">
                                    <c:forEach var="tecnico" items="${listaTecnicos}">
                                        <option value="${tecnico.getCodigoUsuario() }">${tecnico.getPersona().getNombre()} ${tecnico.getPersona().getApellidoPaterno()} ${tecnico.getPersona().getApellidoMaterno()} </option>
                                    </c:forEach>
                                </select>
                                
                                <label class="form-label" for="descripcionProblema">Ingrese el problema presentado:</label>
                                <textarea class="form-control" name="descripcionProblema" maxlength="50" cols="40" rows="5"></textarea>
                                
                                <label class="form-label" for="fechaHojaServicio">Ingresa la fecha</label>
                                <input class="form-control" type="date" name="fechaHojaServicio">
                                
                                <input type="hidden" name="codigoEquipo" value="${codigoEquipo}">
                                
                                <label class="form-label" for="horaHojaServicio">Ingresa la hora</label>
                                <input class="form-control" type="time" name="horaHojaServicio">
                                
                               
                                <input type="submit" name="accion" value="ingresarSolicitud">
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
        </main>
        
    </body>
</html>
