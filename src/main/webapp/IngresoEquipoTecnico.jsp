<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TALLER UTP</title>
        <link rel="stylesheet" href="./css/sidebar.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/b528f7619b.js" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <style>
            .principal label{
                font-size: 1.5rem;
                margin-bottom: 1rem;
            }
            .principal{
                margin-left: 4rem;
            }
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
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar">
                <jsp:include page="./sidebar/sidebarTecnico.jsp"></jsp:include>
            </div>

                
                    <div class="principal">
                        <h1>Ingreso de un nuevo equipo</h1>
                        <div class ="general">
                        <div class="card" style="width: 18rem;">
                                <div class="card-header">
                                    <img src="https://smartphonesperu.pe/wp-content/uploads/2019/03/servicio-tecnico-de-celulares-smartphonesperu-3.jpg" class="card-img-top" alt="...">    
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">Existente?</h5>
                                    <p class="card-text">Busca un equipo existente</p>
                                    
                                </div>
                                <div class="card-footer">
                                    <a href="ControladorTecnico?accion=ListarEquipos" class="btn btn-primary">Buscar</a>                                   
                                </div>
                        </div>
                        <div class="card" style="width: 18rem;">
                                <div class="card-header">
                                    <img src="https://smartphonesperu.pe/wp-content/uploads/2019/03/servicio-tecnico-de-celulares-smartphonesperu-3.jpg" class="card-img-top" alt="...">    
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">Nuevo</h5>
                                    <p class="card-text">Ingresa un nuevo equipo</p>
                                    
                                </div>
                                <div class="card-footer">
                                    <a href="ControladorTecnico?accion=FormularioIngresoEquipo" class="btn btn-primary">Agregar</a>
                                </div>
                        </div>
                        </div>
                    </div>
                
        </main>
    </body>
</html>