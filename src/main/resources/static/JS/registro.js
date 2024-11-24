async function registrarUsuario(event) {
  event.preventDefault(); // Previene el envío tradicional del formulario

  // Capturar los datos del formulario
  const cedula = document.getElementById("cedula").value;
  const fullName = document.getElementById("full_name").value;
  const telf = document.getElementById("telf").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  // Crear un objeto con los datos
  const usuario = {
    cedula: cedula,
    fullName: fullName,
    telf: telf,
    email: email,
    password: password,
  };

  try {
    // Enviar los datos a la API con fetch
    const response = await fetch(
      "http://localhost:8080/api/usuarios/registrar",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(usuario),
      }
    );

    if (response.ok) {
      alert("Usuario registrado exitosamente.");
      // Redirige al archivo de inicio de sesión
      window.location.href = "InicioDeSesion.html";
    } else if (response.status === 409) {
      // Manejo del estado de conflicto cuando el usuario ya existe
      const error = await response.text();
      alert(error);
    } else {
      alert("Error al registrar usuario.");
    }
  } catch (error) {
    console.error("Error en la solicitud:", error);
    alert("Error en la conexión con el servidor.");
  }
}