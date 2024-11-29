<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <main>
        <div class="contenedor__todo">
            <div class="contenedor__login-register">
                <form action="validar.php" method="POST" class="formulario__login">
                    <h2>Iniciar Sesión</h2>
                    
    
                    <?php
                    if (isset($_GET['error']) && $_GET['error'] == 'auth') {
                        echo '<p class="error">ERROR DE AUTENTIFICACION</p>';
                    }
                    ?>

                    <input type="text" name="usuario" placeholder="Correo Electrónico">
                    <input type="password" name="contraseña" placeholder="Contraseña">
                    <button>Entrar</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>


