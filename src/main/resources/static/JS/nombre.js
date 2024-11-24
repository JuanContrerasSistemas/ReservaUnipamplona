
      // JavaScript para mostrar el nombre del usuario
      document.addEventListener("DOMContentLoaded", () => {
        const nombreUsuario = localStorage.getItem("nombreUsuario");
        const cedulaUsuario = localStorage.getItem("cedulaUsuario");

        if (nombreUsuario && cedulaUsuario) {
          document.getElementById("userName").textContent = nombreUsuario;
          document.getElementById("cedulaUsuario").textContent = cedulaUsuario;
        } else {
          alert("Sesión expirada. Por favor, inicia sesión de nuevo.");
          window.location.href = "InicioDeSecion.html";
        }
      });