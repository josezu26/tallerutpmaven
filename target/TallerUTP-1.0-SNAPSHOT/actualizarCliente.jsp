<%-- 
    Document   : actualizarTecnico
    Created on : 10 jun. 2022, 01:34:07
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
            }
            .form-select{
                font-size: 1.6rem;
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
                    <h1>Actualizar Tecnico</h1>
                    <form class="formulario" action="ControladorAdmin">
                        <label class="form-label" for="codigoUsuario">Codigo: </label>
                        <input class="form-control" type="text" name="codigoUsuario" readonly="readonly" value="${usuario.getCodigoUsuario() }"><br>
                        <label class="form-label" for="codigoPersona">Ingrese su DNI</label>
                        <input class="form-control" type="text" name="codigoPersona" readonly="readonly" value="${usuario.getPersona().getCodigoPersona()}"><br>
                        <label class="form-label" for="password">Ingrese su Contraseña</label>
                        <input class="form-control" type="password" name="password" value="${usuario.getPassword()}"
                               required=""><br>
                        <label class="form-label" for="nombre">Ingrese su Nombre</label>
                        <input class="form-control" type="text" name="nombre" value="${usuario.getPersona().getNombre()}"
                               required="" pattern="[A-Za-z]+"><br>
                        <label class="form-label" for="apellidoPaterno">Ingrese su Apellido Paterno</label>
                        <input class="form-control" type="text" name="apellidoPaterno" value="${usuario.getPersona().getApellidoPaterno()}"
                               required="" pattern="[A-Za-z]+"><br>
                        <label class="form-label" for="apellidoMaterno">Ingrese su Apellido Materno</label>
                        <input class="form-control" type="text" name="apellidoMaterno" value="${usuario.getPersona().getApellidoMaterno()}"
                               required="" pattern="[A-Za-z]+"><br>
                        <label class="form-label" for="telefono">Ingrese su Telefono</label>
                        <input class="form-control" type="text" name="telefono" value="${usuario.getPersona().getTelefono()}"
                               required="" pattern="[0-9]+" minlength="9" maxlength="9"><br>
                        <label class="form-label" for="correo">Ingrese su Correo</label>
                        <input class="form-control" type="email" name="correo" value="${usuario.getPersona().getCorreo()}"
                               required=""><br>
                        <label class="form-label" for="direccion">Ingrese su Direccion</label>
                        <input class="form-control" type="text" name="direccion" value="${usuario.getPersona().getDireccion().getDescripcionDireccion()}"
                               required=""><br>
                        <label class="form-label" for="distrito">Seleccione su distrito:</label>
                        <select class="form-select" name="distrito" >
                            <option value="1">Cerro Colorado</option>
                        </select><br>
                        
                        <input type="submit" name="accion" value="actualizarCliente"></div>
                    </form>
                </div>
            </div>
        </main>
    </body>
</html>
