<%-- 
    Document   : procesoServicioTecnico3
    Created on : 24 jun. 2022, 00:17:11
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            
            .principal{
                display: flex;
                flex-direction: column;
            }
            .cuerpo{
                display: flex;
                gap: 3rem;
                padding-left: 3rem;
                font-size: 1.5rem;
                margin-top: 3rem;
            }
            .cuerpo table{
                margin-bottom: 4rem;
            }
            .tabla-izq{
                width: 80%;
            }
            .tabla-der form{
                display: flex;
                flex-direction: column;
                align-items: flex-end;
            }
            .tabla-der input{
                margin-bottom: 2rem;
            }
            h1{
                
                padding-left: 3rem;
            }
            
           
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="../sidebar/sidebarTecnico.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <h1>Detalles de Atención</h1>
                    <div class="cuerpo">
                        <div class="tabla-izq">
                            <h2>Servicios</h2>
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
                        <table class="table table-hover">
                            <h2>Repuestos</h2>
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Precio</th>
                                    

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="repuesto" items="${carritoRepuestos}">
                                    <tr>
                                        <td>${repuesto.getCodigoRepuesto() }</td>
                                        <td>${repuesto.getNombreRepuesto() }</td>
                                        <td>${repuesto.getDescripcionRepuesto() }</td>
                                        <td>${repuesto.getPrecioRepuesto() }</td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tabla-der">
                        <form action="ControladorTecnico">
                            <label class="form-label" for="precioVisita">Ingresa el monto de la visita:</label>
                            <input class="form-control" type="number" step="0.1" name="precioVisita" pattern="[0-9]+" min="0">

                            <input type="hidden" name="codigoHojaServicio" value="${codigoHojaServicio}">

                            <input type="submit" name="accion" value="Finalizar">
                        </form>
                    </div>    
                </div>

            </div>
        </main>
    </body>
</html>
