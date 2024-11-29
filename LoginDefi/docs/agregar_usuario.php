<?php
$host = 'localhost';  
$db = 'usuarios';  
$user = 'root';  
$pass = '';  
$conn = new mysqli($host, $user, $pass, $db);


if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $_POST['nombre'];
    $correo = $_POST['correo'];
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT); 


    $rol = "Usuario";


    $sql = "INSERT INTO usuarios (nombre, correo, password, rol) VALUES (?, ?, ?, ?)";
    

    if ($stmt = $conn->prepare($sql)) {

        $stmt->bind_param("ssss", $nombre, $correo, $password, $rol);
        

        if ($stmt->execute()) {
            echo "<script>alert('Usuario agregado exitosamente.');</script>";
        } else {
            echo "<script>alert('Error al agregar el usuario.');</script>";
        }


        $stmt->close();
    } else {
        echo "<script>alert('Error en la preparación de la consulta.');</script>";
    }
}


$conn->close();
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://kit.fontawesome.com/375a0b3132.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="style.css">
  <title>Darion</title>

  <style>
    body {
      background-image: url('../docs/img/font1.jpeg');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      margin: 0;
      padding: 0;
      height: 100vh;
    }

    .container-fluid,
    .container {
      position: relative;
      z-index: 1;
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
                  <a class="nav-link" href="agregar_juego.php"><i class="fa-solid fa-gamepad"></i> Agregar juego</a>
                </li>
              <?php } else { ?>
                <li class="nav-item">
                  <a class="nav-link" href="agregar_usuario.php"><i class="fa-solid fa-user-plus"></i> Agregar usuario</a>
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

  <main class="orden">
    <div id="Juego" class="card text-bg-dark mb-3" style="margin-bottom: 0;">
      <div class="card-body">
        <img class="card-img-top" src="img/logo.png" alt="Card image cap" style="border-radius: 5px;">
      </div>
    </div>
  </main>


  <div class="container mt-5">
    <div class="card text-bg-dark mb-3">
      <div class="card-header">
        <h4><i class="fa-solid fa-user-plus"></i> Agregar Usuario</h4>
      </div>
      <div class="card-body">
        <form action="agregar_usuario.php" method="POST">
          <div class="mb-3">
            <label for="nombre" class="form-label">Nombre Completo</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
          </div>
          <div class="mb-3">
            <label for="correo" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" id="correo" name="correo" required>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" required>
          </div>
          <button type="submit" class="btn btn-primary">Agregar Usuario</button>
        </form>
      </div>
    </div>
  </div>

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
