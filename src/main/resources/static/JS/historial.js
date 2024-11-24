const cedulaUsuario = localStorage.getItem("cedulaUsuario");

      if (!cedulaUsuario) {
        alert(
          "No se encontró la cédula del usuario. Inicia sesión nuevamente."
        );
        window.location.href = "InicioDeSesion.html";
      }

      function formatearFecha(fecha) {
        return new Date(fecha).toLocaleDateString("es-ES");
      }

      function formatearHora(hora) {
        return hora.substring(0, 5);
      }

      async function cargarHistorial() {
        try {
          const response = await fetch(
            `http://localhost:8080/api/reservas/usuario/${cedulaUsuario}`
          );
          if (!response.ok) {
            throw new Error("No se pudieron cargar las reservas.");
          }

          const reservas = await response.json();
          const historialBody = document.getElementById("historialBody");
          historialBody.innerHTML = "";

          reservas.forEach((reserva) => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
                        <td>${reserva.zona.nombre}</td>
                        <td>${formatearFecha(reserva.fecha)}</td>
                        <td>${formatearHora(reserva.hora)}</td>
                        <td>${reserva.estado.descripcion}</td>
                    `;
            historialBody.appendChild(fila);
          });
        } catch (error) {
          console.error("Error al cargar el historial:", error);
          alert("Error al cargar el historial de reservas.");
        }
      }

      window.addEventListener("DOMContentLoaded", cargarHistorial);