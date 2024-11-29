<?php
$conexion = mysqli_connect("localhost", "root", "", "usuarios");

if (!$conexion) {
    die("Conexión fallida: " . mysqli_connect_error());
}
?>
