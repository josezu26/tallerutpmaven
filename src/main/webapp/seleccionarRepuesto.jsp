<%-- 
    Document   : procesarHojaServicio
    Created on : 11 jun. 2022, 01:40:33
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
            h1 {
                text-align: center;
            }
            .card {
                text-align: center;
                margin: 3rem 4rem 0 0;
                height: 32rem;
            }
            .card-text {
                font-size: 1.5rem;
            }
            .card-footer a{
                font-size : 1.2rem;
            }
            .principal{
                overflow: scroll;
            }
            .general{
                display : flex;
                justify-content: center;
                flex-wrap: wrap;
            }
            form {
                width: 100%;
                margin : auto;
                display : flex;
                flex-direction: column;
            }
            form input:last-child{
                width:10%;
                height: 2.4rem;
                font-size: 1.2rem;
                align-self: end;
                margin-right: 5rem;
                margin-top: 3rem;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
                </div>

                <div class="principal">

                    <h1>Seleccionar repuestos</h1>

                    <form action="ControladorAdmin">
                        <div class="general">    
                        <c:forEach var="repuesto" items="${listaRepuestos}">
                            <div class="card" style="width: 18rem;">
                                <div class="card-header">
                                    <img src="https://i.pinimg.com/originals/d2/06/ff/d206fff6b94316a5d46214e893b38335.png" class="card-img-top" alt="...">    
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${repuesto.getNombreRepuesto()}</h5>
                                    <p class="card-text">${repuesto.getDescripcionRepuesto()}.</p>
                                    <p class="card-text">Stock: ${repuesto.getStockRepuesto()}</p>
                                </div>
                                <div class="card-footer">
                                    <a href="ControladorAdmin?accion=agregarRepuestoCarrito&codigoRepuesto=${repuesto.getCodigoRepuesto()}" class="btn btn-primary">Agregar</a>
                                    <a href="ControladorAdmin?accion=eliminarRepuestoCarrito&codigoRepuesto=${repuesto.getCodigoRepuesto()}" class="btn btn-danger">Quitar</a>
                                </div>
                            </div>
                        </c:forEach>
                        </div>
                        <input type="hidden" name="codigoHojaServicio" value="${codigoHojaServicio}">
                        
                        <input type="submit" name="accion" value="Continuar">
                </form>
            </div>
        </main>
    </body>
</html>
