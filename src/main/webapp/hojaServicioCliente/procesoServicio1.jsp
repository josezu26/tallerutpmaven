<%-- 
    Document   : procesoServicio1
    Created on : 10 jun. 2022, 15:37:35
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
        <link rel="stylesheet" href="../css/sidebar.css">
        <style>
            h1 {
                text-align: center;
            }
            .card {
                text-align: center;
                margin: 3rem 4rem 0 0;
                height: 22.6rem;
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
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="../sidebar/sidebarCliente.jsp"></jsp:include>
            </div>

            <div class="principal">
                <h1>Elija el equipo</h1>
                
                <div class="general">    
                    <c:forEach var="listaequipocliente" items="${listaequipocliente}">
                        <div class="card" style="width: 18rem;">
                            <div class="card-header">
                                <img src="https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4LqQX?ver=fe80&q=90&m=6&h=705&w=1253&b=%23FFFFFFFF&f=jpg&o=f&p=140&aim=true" class="card-img-top" alt="...">    
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${listaequipocliente.getTipoEquipo().getDescripcionTipoEquipo()} ${listaequipocliente.getMarcaEquipo().getDescripcionMarcaEquipo()}</h5>
                                <p class="card-text">${listaequipocliente.getDescripcionEquipo()}.</p>
                            </div>
                            <div class="card-footer">
                                <a href="ControladorCliente?accion=seleccionarEquipo&codigoEquipo=${listaequipocliente.getCodigoEquipo()}" class="btn btn-primary">Seleccionar</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
    </body>
</html>
