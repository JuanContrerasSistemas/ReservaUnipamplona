async function iniciarSesion(event) {
  event.preventDefault(); // Previene el envío tradicional del formulario

  // Capturar los datos del formulario
  document.getElementById("loginForm").addEventListener("submit", iniciarSesion);
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  // Crear un objeto con los datos
  const credenciales = {
    email: email,
    password: password,
  };

  try {
    // Enviar los datos a la API de login
    const response = await fetch(
      "http://localhost:8080/api/usuarios/login",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(credenciales),
      }
    );

    if (response.ok) {
      // Inicio de sesión exitoso, ahora obtener los detalles del usuario
      const usuarioResponse = await fetch(
        `http://localhost:8080/api/usuarios/detalle?email=${email}`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      if (usuarioResponse.ok) {
        const usuarioData = await usuarioResponse.json();

        // Guardar el nombre y la cédula del usuario en localStorage
        localStorage.setItem("nombreUsuario", usuarioData.fullName);
        localStorage.setItem("cedulaUsuario", usuarioData.cedula);

        // Redirigir a perfil.html
        alert("Inicio de sesión exitoso.");
        window.location.href = "perfil.html";
      } else {
        alert("Error al obtener los datos del usuario.");
      }
    } else {
      // Si el inicio de sesión falla, muestra mensaje de error
      alert("Correo o contraseña incorrecto. Intenta nuevamente.");
      document.getElementById("password").value = ""; // Limpiar solo el campo de contraseña
    }
  } catch (error) {
    console.error("Error en la solicitud:", error);
    alert("Error en la conexión con el servidor.");
  }
}