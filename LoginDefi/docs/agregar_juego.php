<?php
session_start();


if (!isset($_SESSION['usuario']) || $_SESSION['role'] != 'superadmin') {
    header("Location: Main.php"); 
    exit();
}


$conexion = mysqli_connect("localhost", "root", "", "usuarios");

if (!$conexion) {
    die("Conexión fallida: " . mysqli_connect_error());
}

$mensaje = '';


if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $nombre_juego = mysqli_real_escape_string($conexion, $_POST['nombre_juego']);
    $descripcion = mysqli_real_escape_string($conexion, $_POST['descripcion']);
    $imagen = $_FILES['imagen']['name'];


    $directorio = 'img/juegos/';
    $ruta_imagen = $directorio . basename($imagen);


    if (move_uploaded_file($_FILES['imagen']['tmp_name'], $ruta_imagen)) {

        $query = "INSERT INTO juegos (nombre_juego, descripcion, imagen) VALUES ('$nombre_juego', '$descripcion', '$imagen')";

        if (mysqli_query($conexion, $query)) {
            $mensaje = "Juego agregado correctamente y la imagen se subió con éxito.";
        } else {
            $mensaje = "Error al agregar el juego: " . mysqli_error($conexion);
        }
    } else {
        $mensaje = "Error al subir la imagen.";
    }
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://kit.fontawesome.com/375a0b3132.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="style.css">
  <title>Agregar Juego</title>

  <style>
    body {
      background-image: url('../docs/img/font1.jpeg');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      margin: 0;
      padding: 0;
      height: 100vh;
      color: white; 
    }

    .container-fluid,
    .container {
      position: relative;
      z-index: 1;
    }

 
    .form-label, .form-control, .btn {
      color: white;
    }

    .form-control {
      background-color: rgba(0, 0, 0, 0.7); 
      border-color: white;
    }

    .form-control:focus {
      border-color: #ffc107; 
      box-shadow: 0 0 0 0.25rem rgba(255, 193, 7, 0.5);
    }


    h2, .card-header, .informacion, p {
      color: white;
    }


    .mensaje {
      margin-top: 20px;
      padding: 10px;
      border-radius: 5px;
      text-align: center;
      font-size: 16px;
      color: white;
    }
    .mensaje-success {
      background-color: green;
    }
    .mensaje-error {
      background-color: red;
    }
  </style>
</head>

<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top border-bottom border-secondary">
      <div class="container-fluid">
        <a class="navbar-brand" href="Main.php">
          <img src="img/LLBlanco.png" alt="Logo" style="width: 250px; height: 79px;">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a class="nav-link active" href="Main.php"><i class="fa-solid fa-house"></i> Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="juego.php"><i class="fa-solid fa-gamepad"></i> Juegos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="nosotros.php"><i class="fa-solid fa-users"></i> Equipo</a>
            </li>
            <?php if (isset($_SESSION['usuario'])) { ?>
              <?php if ($_SESSION['role'] == 'superadmin') { ?>
                <li class="nav-item">
                  <a class="nav-link" href="agregar_juego.php"><i class="fa-solid fa-gamepad"></i> Agregar Juego</a>
                </li>
              <?php } ?>
              <li class="nav-item">
                <a class="nav-link" href="logout.php"><i class="fa-solid fa-sign-out-alt"></i> Cerrar sesión</a>
              </li>
            <?php } else { ?>
              <li class="nav-item">
                <a class="nav-link" href="../Login.php"><i class="fa-solid fa-sign-in-alt"></i> Iniciar Sesión</a>
              </li>
            <?php } ?>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <main class="container my-5">
    <h2>Agregar Juego</h2>

  
    <?php if (!empty($mensaje)): ?>
      <div class="mensaje <?php echo (strpos($mensaje, 'Error') === false) ? 'mensaje-success' : 'mensaje-error'; ?>">
        <?php echo $mensaje; ?>
      </div>
    <?php endif; ?>

    <form method="POST" enctype="multipart/form-data">
      <div class="mb-3">
        <label for="nombre_juego" class="form-label">Nombre del Juego</label>
        <input type="text" class="form-control" id="nombre_juego" name="nombre_juego" required>
      </div>
      <div class="mb-3">
        <label for="descripcion" class="form-label">Descripción</label>
        <textarea class="form-control" id="descripcion" name="descripcion" rows="4" required></textarea>
      </div>
      <div class="mb-3">
        <label for="imagen" class="form-label">Imagen del Juego</label>
        <input type="file" class="form-control" id="imagen" name="imagen" accept="image/*" required>
      </div>
      <button type="submit" class="btn btn-primary">Agregar Juego</button>
    </form>
  </main>

  <footer class="bg-dark text-white pt-4">
    <div class="container">
      <div class="text-center py-3 border-top border-secondary">
        <p class="mb-0">@2024 Darion Inc. | <a href="#" class="text-white">Política de privacidad</a></p>
      </div>
    </div>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>

</html>
