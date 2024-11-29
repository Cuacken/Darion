<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    .game-section {
      text-align: center;
      margin-top: 50px;
    }

    .game-section img {
      width: 300px;
      height: 300px;
      object-fit: cover;
      margin-bottom: 20px;
    }

    .game-section p {
      color: white;
    }
  </style>
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top border-bottom border-secondary">
    <div class="container-fluid">
      <a class="navbar-brand" href="Main.php">
      <img src="img/LCBlancoFull.png" alt="Logo" style="width: 150  px; height: 50px;">
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
        </ul>
      </div>
    </div>
  </nav>

  <main>
    <div class="container game-section">
      <h2>Juego: The Escapists</h2>
      <img src="img/juegos/XD.jpg" alt="The Escapists">
      <p>Un emocionante juego de simulación de escape de prisión. ¡Haz lo que sea necesario para escapar!</p>


      <a href="archivos/TheEscapists.exe" class="btn btn-primary" download>
        Descargar Juego
      </a>
    </div>
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
