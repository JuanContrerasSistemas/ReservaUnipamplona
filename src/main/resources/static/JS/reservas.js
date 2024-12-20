// Obtener la lista de áreas de la API
async function cargarZonas() {
  try {
    const response = await fetch("http://localhost:8080/api/zonas/todas");
    if (!response.ok) {
      throw new Error("Error al cargar las zonas.");
    }
    const zonas = await response.json();

    const zonaSelect = document.getElementById("zona");
    zonas.forEach((zona) => {
      const option = document.createElement("option");
      option.value = zona.id;
      option.textContent = zona.nombre;
      zonaSelect.appendChild(option);
    });
  } catch (error) {
    console.error("Error al cargar zonas:", error);
    alert("Error al cargar la lista de áreas.");
  }
}

// Establecer el valor mínimo para la fecha de reserva
function establecerFechaMinima() {
  const fechaInput = document.getElementById("fecha");
  const hoy = new Date();
  hoy.setDate(hoy.getDate() + 2); // Mínimo de 2 días desde hoy
  const fechaMinima = hoy.toISOString().split("T")[0];
  fechaInput.min = fechaMinima;
}

// Manejar el envío del formulario
async function registrarReserva(event) {
  event.preventDefault();

  const zona = document.getElementById("zona").value;
  const fecha = document.getElementById("fecha").value;
  const hora = document.getElementById("hora").value;
  const usuarioCedula = localStorage.getItem("cedulaUsuario"); // Obtener la cédula del usuario desde el almacenamiento local

  if (!zona || !fecha || !hora) {
    alert("Por favor, complete todos los campos.");
    return;
  }

  const reservaData = {
    usuarioCedula: usuarioCedula,
    zonaId: parseInt(zona),
    fecha: fecha,
    hora: hora + ":00", // Asegurarse de que esté en formato correcto
    estadoId: 1, // Estado predeterminado
  };

  try {
    const response = await fetch(
      "http://localhost:8080/api/reservas/registrar",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(reservaData),
      }
    );

    const mensajeDiv = document.getElementById("mensaje");
    if (response.ok) {
      mensajeDiv.textContent = "Reserva registrada exitosamente.";
      mensajeDiv.style.color = "green";
      document.getElementById("reservaForm").reset(); // Limpia el formulario
    } else {
      const errorText = await response.text();
      mensajeDiv.textContent = "Error: " + errorText;
      mensajeDiv.style.color = "red";
    }
  } catch (error) {
    console.error("Error al registrar la reserva:", error);
    alert("Error en la conexión con el servidor.");
  }
}

// Cargar zonas y configurar la fecha mínima cuando se carga la página
window.addEventListener("DOMContentLoaded", () => {
  cargarZonas();
  establecerFechaMinima();
});