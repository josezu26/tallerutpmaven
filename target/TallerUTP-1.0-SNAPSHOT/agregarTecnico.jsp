<%-- 
    Document   : agregarTecnico
    Created on : 10 jun. 2022, 01:05:20
    Author     : Jose
--%>

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
            form {
                margin : 4rem auto 0;
                width: 50%;
            }
            .form-control {
                font-size: 1.6rem;
                margin-bottom: 0.8rem;
            }
            .form-select {
                font-size: 1.6rem;
                margin-bottom: 0.8rem;
            }
            form input:last-child{
                margin: 1rem auto 3rem;
            }
            .principal{
                overflow: scroll;
            }
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
            </div>

            <div class="principal">
                <div class="general">
                    <h1 style="text-align: center">Agregar nuevo tecnico</h1>

                    <form action="ControladorAdmin">
                        <label class="form-label" for="codigoPersona">Ingrese su DNI</label>
                        <input class="form-control" type="text" name="codigoPersona" minlength="8" maxlength="8" required pattern="[0-9]+">
                        <label class="form-label" for="password">Ingrese su Contraseña</label>
                        <input class="form-control" type="password" name="password" required>    
                        <label class="form-label" for="">Nombre</label>
                        <input class="form-control" type="text" placeholder="Nombre" name="nombre" required pattern="[A-Za-z]+"> 
                        <label class="form-label" for="">Apellido Paterno</label>
                        <input class="form-control" type="text" placeholder="Apellido" name="apellidoPaterno" required pattern="[A-Za-z]+"> 
                        <label class="form-label" for="">Apellido Materno</label>
                        <input class="form-control" type="text" placeholder="Apellido" name="apellidoMaterno" required pattern="[A-Za-z]+"> 
                        <label class="form-label" for="">Telefono</label>
                        <input class="form-control" type="text" placeholder="968034586" name="telefono" minlength="9" maxlength="9" required pattern="[0-9]+"> 
                        <label class="form-label" for="">Correo</label>
                        <input class="form-control" type="email" placeholder="alguien@algomail.com" name="correo" required> 
                        <label class="form-label" for="">Direccion</label>
                        <input class="form-control" type="text" placeholder="Direccion" name="direccion" required> 
                        <label class="form-label" for="distrito">Distrito</label>
                        <select class="form-select" name="distrito" id="">
                            <option value="1">Cerro Colorado</option>                                  
                        </select>
                        <label class="form-label" for="especialidad">Especialidad</label>
                        <select class="form-select" name="especialidad" id="">
                            <option value="1">Reparación</option>
                            <option value="2">Limpieza</option>                              
                        </select> 

                        <input type="submit" name="accion" value="registrar">
                    </form>
                </div>
            </div>
        </main>
    </body>
</html>
