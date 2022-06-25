<%-- 
    Document   : procesarHojaServicio
    Created on : 11 jun. 2022, 02:04:24
    Author     : Jose
--%>
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
        <link rel="stylesheet" href="./css/sidebar.css">
        <style>
            .form-control {
                font-size: 1.6rem;
            }
            .form-select {
                font-size: 1.6rem;
            }
            .general {
                width:95%;
                display : flex;
                flex-direction: column;
                align-items: center;
            }
            .informacion {
                width: 100%;
                display : flex;
                justify-content: center;
                gap : 3rem;
            }
            .formulario-derecha{
                padding: 2rem;
                margin-top: 3rem;
                border-radius: 1rem;
                outline : 1px solid #cecece;
                gap : 2rem;
            }
            .formulario-derecha input {
                margin-bottom: 2rem;
                text-align: center;
            }
            .boton {
                display : block;
                margin : auto;
            }
            /*
            .formulario-derecha textarea{
                resize: none;
            }
            .formulario-derecha .form-select{
                margin-bottom: 2rem;
            }
            form input:last-child{
                margin-top:3rem;
            }*/
        </style>
    </head>
    <body>

        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
                </div>

                <div class="principal">
                    <div class="general">

                        <h1>Procesar solicitud de servicio</h1>

                        <div class="informacion">
                            <!--
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Codigo</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Descripcion</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Stock</th>

                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="repuesto" items="${carritoRepuestos}">
                                    <tr>
                                        <td>${repuesto.getCodigoRepuesto() }</td>
                                        <td>${repuesto.getNombreRepuesto() }</td>
                                        <td>${repuesto.getDescripcionRepuesto() }</td>
                                        <td>${repuesto.getPrecioRepuesto() }</td>
                                        <td>${repuesto.getStockRepuesto() }</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>-->
                        <div class="formulario-derecha">
                            <form action="ControladorAdmin">
                                <label class="form-label" for="fechaHojaServicio">Ingresa la fecha</label>
                                <input class="form-control" type="date" name="fechaHojaServicio">
                                
                                <label class="form-label" for="horaHojaServicio">Ingresa la hora</label>
                                <input class="form-control" type="time" name="horaHojaServicio">
                                                                
                                <input type="hidden" name="codigoHojaServicio" value="${codigoHojaServicio}">

                                <input class="boton" type="submit" name="accion" value="Verificar">
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </main>


    </body>
</html>
