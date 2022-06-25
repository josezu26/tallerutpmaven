<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Taller UTP</title>
    <link rel="stylesheet" href="./css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <div class="contenedor">
            <h1 class="titulo">Iniciar Sesion</h1>
            <form action="ControladorSesion" class="login-card">
                <label class="label" for="usuario">Ingresa tu usuario</label>
                <input class="input" type="text" name="usuario" required="" pattern="[0-9]+">
        
                <label class="label" for="password">Ingrese su contraseña</label>
                <input class="input" type="password" name="password" required="">
                <input class="button" type="submit" name="accion" value="ingresar">
                <div class="alert alert-danger" role="alert">
                    Credenciales incorrectas!
                </div>
            </form>
            <div class="olvidaste">
                <a href="registrar.jsp">¿No estas registrado? Registrarse</a>
            </div>
        </div>
    </main>
</body>
</html>