<%-- 
    Document   : inicioAdmin
    Created on : 9 jun. 2022, 22:53:33
    Author     : Jose
--%>

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
        <style>
            .principal label{
                font-size: 1.5rem;
                margin-bottom: 1rem;
            }
            .principal{
                margin-left: 4rem;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
            </div>

                    <div class="principal">
                        <div class="principal">
                            <h1>Tus Datos:</h1>
                            <div>
                                <h2>Datos de tu usuario:</h2>
                                <label>Tu código: ${usuario.getCodigoUsuario()}</label><br>
                            <label>Tu contraseña: ${usuario.getPassword()}</label><br>
                        </div>
                        <div>
                            <h2>Tus datos personales:</h2>
                            <label>Bienvenid@, ${usuario.getPersona().getNombre()} ${usuario.getPersona().getApellidoPaterno()} ${usuario.getPersona().getApellidoMaterno()} </label><br>
                            <label>Telefono: ${usuario.getPersona().getTelefono()}</label><br>
                            <label>Direccion: ${usuario.getPersona().getDireccion().getDescripcionDireccion()}</label><br>
                            <label>Correo: ${usuario.getPersona().getCorreo()}</label><br>
                        </div>
                    </div>
                </div>
        </main>
    </body>
</html>
