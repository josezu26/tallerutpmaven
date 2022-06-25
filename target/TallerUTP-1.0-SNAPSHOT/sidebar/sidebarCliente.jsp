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
                    <h2>CLIENTE</h2>
                    <img src="https://icon-library.com/images/default-user-icon/default-user-icon-13.jpg" alt="">
                </div>
                <div class="opciones-perfil">
                    <div>
                        <p>SOBRE MI</p>
                        <ul class="hojas-opciones">
                            <li><a href="#"><i class="fas fa-info"></i> Mi perfil</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>HOJAS DE SERVICIO</p>
                        <ul class="hojas-opciones">
                            <li><a href="ControladorCliente?accion=formularioNuevaSolicitud&codigoCliente=${usuario.getCodigoUsuario()}"><i class="fas fa-plus"></i> Nueva Solicitud</a></li>
                            <li><a href="ControladorCliente?accion=listarHojaServicio&codigoCliente=${usuario.getCodigoUsuario()}"><i class="fas fa-list-ul"></i> Listar mis Solicitudes</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>EQUIPOS</p>
                        <ul class="repuesto-opciones">
                            <li><a href="ControladorCliente?accion=formularioNuevoEquipo&codigoCliente=${usuario.getCodigoUsuario()}"><i class="fas fa-plus"></i> Agregar Equipo</a></li>
                            <li><a href="ControladorCliente?accion=listarEquipoCliente&codigoCliente=${usuario.getCodigoUsuario()}"><i class="fas fa-list-ul"></i> Listar mis Equipos</a></li>
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