// JavaScript para limpiar el localStorage y redirigir a index
document.addEventListener("DOMContentLoaded", () => {
  // Verificar si el usuario ha vuelto a la página
  if (window.location.pathname.includes("index.html")) {
    // Limpiar las variables del usuario en el localStorage
    localStorage.removeItem("nombreUsuario");
    localStorage.removeItem("cedulaUsuario");
    localStorage.removeItem("emailUsuario"); // Agregar si tienes más variables
    
    console.log("Datos de usuario eliminados del localStorage.");
  }
});
