<?php
include('bd.php');

$usuario = $_POST['usuario'];
$contraseña = $_POST['contraseña'];
session_start();
$_SESSION['usuario'] = $usuario;


$consulta = "SELECT * FROM usuarios_juego WHERE username='$usuario' AND password='$contraseña'";
$resultado = mysqli_query($conexion, $consulta);

if (mysqli_num_rows($resultado)) {

    $usuario_data = mysqli_fetch_assoc($resultado);
    $_SESSION['role'] = $usuario_data['role']; 

    header("Location: docs/Main.php"); 
} else {

    header("Location: Login.php?error=auth");
}

mysqli_free_result($resultado);
mysqli_close($conexion);
?>
