<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Taller UTP</title>
    <!-- <link rel="stylesheet" href="login.css" /> -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;500;700&display=swap"
      rel="stylesheet"/>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #243A73;
        }
        * {
            box-sizing: border-box;
            margin : 0;
            padding : 0;
            font-family: 'Quicksand', sans-serif;
        }
        main {
            width: 100%;
            height: 100vh;
            display : flex;
            justify-content: center;
            align-items: center;
        }
        .contenedor {
            outline: 1px solid black;
            width: 70%;
            height: 90%;
            display : flex;
            flex-direction: column;
            align-items: center;
            overflow: hidden;
            border-radius: 20px;
            background-color: white;
        }
        form {
            width: 100%;
            text-align: center;
        }
        .titulo {
            text-align: center;
            font-size: 2rem;
            margin-top: 1rem;
        }
        .columnas {
            width: 100%;
            display: flex;
            justify-content: space-evenly;
        }
        .boton-registrar {
            display: inline-block;
            margin : auto;
        }
    </style>
  </head>
  <body>
    <main>
      <div class="contenedor">
        <h1 class="titulo">Registrar</h1>
        <form action="ControladorSesion" class="registrar-card">
            <div class="columnas">
                <div class="columna">
                    <label class="form-label" for="codigoPersona">Ingrese su DNI</label>
                    <input class="form-control" type="text" name="codigoPersona" required="" pattern="[0-9]+" /><br />
                    <label class="form-label" for="password">Ingrese su Contraseña</label>
                    <input class="form-control" type="password" name="password" required="" /><br />
                    <label class="form-label" for="nombre">Ingrese su Nombre</label>
                    <input class="form-control" type="text" name="nombre" required="" pattern="[A-Za-z]+" /><br />
                    <label class="form-label" for="apellidoPaterno">Ingrese su Apellido Paterno</label>
                    <input class="form-control" type="text" name="apellidoPaterno" required="" pattern="[A-Za-z]+"/><br />
                </div>
    
                <div class="columna">
                    <label class="form-label" for="apellidoMaterno">Ingrese su Apellido Materno</label>
                    <input class="form-control" type="text" name="apellidoMaterno" required="" pattern="[A-Za-z]+" /><br />
                    <label class="form-label" for="telefono">Ingrese su Telefono</label>
                    <input class="form-control" type="text" name="telefono" required="" pattern="[0-9]+"/><br />
                    <label class="form-label" for="correo">Ingrese su Correo</label>
                    <input class="form-control" type="email" name="correo" required=""/><br />
                    <label class="form-label" for="direccion">Ingrese su Direccion</label>
                    <input class="form-control" type="text" name="direccion" /><br />
                    <label class="form-label" for="distrito">Seleccione su distrito:</label>
                    <select class="form-select" name="distrito">
                        <option value="1">Cerro Colorado</option>
                    </select><br />
                </div>
            </div>
            <input class="boton-registrar" type="submit" name="accion" value="registrar" />
        </form>
      </div>
    </main>
  </body>
</html>
