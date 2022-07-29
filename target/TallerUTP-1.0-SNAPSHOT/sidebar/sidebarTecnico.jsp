<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Taller UTP</title>
    <link rel="stylesheet" href="./css/sidebar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b528f7619b.js" crossorigin="anonymous"></script>
</head>
<body>
    <main class="contenido">
        <div class="sidebar1">
            <div class="contenido-sidebar">
                <div class="img-perfil">
                    <h2>TECNICO</h2>
                    <img src="https://icon-library.com/images/default-user-icon/default-user-icon-13.jpg" alt="">
                </div>
                <div class="opciones-perfil">
                    <div>
                        <p>HOJAS DE SERVICIO</p>
                        <ul class="hojas-opciones">
                            <li><a href="ControladorTecnico?accion=listarHojasServicioPendientes&Cod_EstadoHS=2&codigoUsuario=${usuario.getCodigoUsuario()}"><i class="fas fa-list-ul"></i>Pendientes</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>TALLER</p>
                        <ul class="hojas-opciones">
                            <li><a href="IngresoEquipoTecnico.jsp"><i class="fas fa-plus"></i> Nuevo ingreso cliente</a></li>
                            <li><a href="ControladorTecnico?accion=SeleccionarEquipo"><i class="fas fa-plus"></i> Nuevo pedido taller</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <a href="ControladorSesion?accion=cerrarSesion" class="boton-cerrar-sesion">
                <button class="cerrar-sesion">Cerrar Sesion</button>
            </a>
        </div>
        
    </main>
</body>
</html>
