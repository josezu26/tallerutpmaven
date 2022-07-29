<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Taller UTP</title>
    <link rel="stylesheet" href="sidebar.css">
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
                    <h2>ADMINISTRADOR</h2>
                    <img src="https://icon-library.com/images/default-user-icon/default-user-icon-13.jpg" alt="">
                </div>
                <div class="opciones-perfil">
                    <div>
                        <p>TECNICOS</p>
                        <ul class="tecnico-opciones">
                            <li><a href="agregarTecnico.jsp"><i class="fas fa-plus"></i> Agregar Tecnico</a></li>
                            <li><a href="ControladorAdmin?accion=listarTecnicos"><i class="fas fa-list-ul"></i> Listar tecnicos</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>REPUESTOS</p>
                        <ul class="repuesto-opciones">
                            <li><a href="agregarRepuestos.jsp"><i class="fas fa-plus"></i> Agregar Repuesto</a></li>
                            <li><a href="ControladorAdmin?accion=listarRepuestos"><i class="fas fa-list-ul"></i> Listar repuesto</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>HOJAS DE SERVICIO</p>
                        <ul class="hojas-opciones">
                            <li><a href="ControladorAdmin?accion=listarHojasServicio&estadoHojaServicio=1"><i class="fas fa-list-ul"></i> Hojas de servicio</a></li>
                        </ul>
                    </div>
                    <div>
                        <p>SERVICIOS</p>
                        <ul class="hojas-opciones">
                            <li><a href="agregarServicio.jsp"><i class="fas fa-plus"></i>Agregar un Servicio</a></li>
                            <li><a href="ControladorAdmin?accion=listarServicios"><i class="fas fa-list-ul"></i>Listar Servicios</a></li>
                            
                        </ul>
                    </div>
                    <div>
                        <p>CLIENTES</p>
                        <ul class="hojas-opciones">
                            <li><a href="ControladorAdmin?accion=listarClientes"><i class="fas fa-plus"></i>Listar Clientes</a></li>
                            <li><a href="registrar.jsp"><i class="fas fa-list-ul"></i>Agregar un cliente</a></li>
                            
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