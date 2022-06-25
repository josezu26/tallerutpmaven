<%-- 
    Document   : actualizarRepuesto
    Created on : 10 jun. 2022, 00:48:38
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
        </style>
    </head>
    <body>
        <main class="contenido">
            <div class="sidebar1">
                <jsp:include page="./sidebar/sidebarAdmin.jsp"></jsp:include>
            </div>

            <div class="principal">
                <div class="general">
                    <h1>Actualizar Repuesto</h1>
                    <form class="formulario" action="ControladorAdmin">
                        <label class="form-label" for="codigoRepuesto">Codigo del repuesto: </label>
                        <input class="form-control" type="text" name="codigoRepuesto" readonly="readonly" value="${repuesto.getCodigoRepuesto()}"><br>
                        <label class="form-label" for="nombreRepuesto">Nombre del repuesto: </label>
                        <input class="form-control" type="text" name="nombreRepuesto" value="${repuesto.getNombreRepuesto()}"
                               required="" pattern="[A-Za-z0-9]+"><br>
                        <label class="form-label" for="descripcionRepuesto">Descripcion del repuesto: </label>
                        <input class="form-control" type="text" name="descripcionRepuesto" value="${repuesto.getDescripcionRepuesto()}"
                               required="" pattern="[A-Za-z0-9]+"><br>
                        <label class="form-label" for="precioRepuesto">Precio del repuesto: </label>
                        <input class="form-control" type="number" name="precioRepuesto" value="${repuesto.getPrecioRepuesto()}"
                               required="" step="0.1" min="0"><br>
                        <label class="form-label" for="stockRepuesto">Stock del repuesto: </label>
                        <input class="form-control" type="number" name="stockRepuesto" value="${repuesto.getStockRepuesto()}"
                               required="" min="1" step="1"><br>
                        <input class="form-control" type="submit" name="accion" value="actualizarRepuesto">
                    </form>
                </div>
            </div>
        </main>
    </body>
</html>
