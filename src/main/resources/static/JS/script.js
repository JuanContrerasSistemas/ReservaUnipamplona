document.addEventListener("DOMContentLoaded", function () {
  const yearSelect = document.getElementById('yearSelect');
  const monthSelect = document.getElementById('monthSelect');
  const calendarTitle = document.getElementById('calendarTitle');
  const calendarDays = document.getElementById('calendarDays');

  
  // Festivos en Colombia aplica para 2024
  const holidays = {
    '2024-01-01': 'Año Nuevo',
    '2024-01-08': 'Reyes Mayos',
    '2024-03-25': 'Día San José',
    '2024-03-28': 'Jueves Santo',
    '2024-03-29': 'Viernes Santo',
    '2024-03-31': 'Domingo Resurección',
    '2024-05-01': 'Día Trabajo',
    '2024-05-13': 'Día Ascención',
    '2024-06-03': 'Corpus Christi',
    '2024-06-10': 'Día Sagrado Corazón',
    '2024-07-01': 'Día San Pedro y Pablo',
    '2024-07-20': 'Independencia Colombia',
    '2024-08-07': 'Batalla Boyacá',
    '2024-08-19': 'Asunción Virgen',
    '2024-10-14': 'Día Raza',
    '2024-11-04': 'Día Santos',
    '2024-11-11': 'Día Independencia Cartagena',
    '2024-12-08': 'Día Inmaculada Concepción',
    '2024-12-25': 'Navidad',
    // Agrega más festivos según lo necesites
  };

  const startYear = 2024;
  const endYear = 3000;

  // Llenar el select de años
  for (let i = startYear; i <= endYear; i++) {
    const option = document.createElement('option');
    option.value = i;
    option.textContent = i;
    yearSelect.appendChild(option);
  }

  // Función para actualizar el calendario
function updateCalendar() {
  const year = yearSelect.value;
  const month = monthSelect.value;

  // Actualizar el título
  const monthNames = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
  calendarTitle.textContent = `${monthNames[month]} ${year}`;

  // Limpiar los días anteriores
  calendarDays.innerHTML = '';

  // Agregar celdas con los días de la semana
  const daysOfWeek = ['D', 'L', 'M', 'X', 'J', 'V', 'S'];
  daysOfWeek.forEach(day => {
    const dayHeader = document.createElement('div');
    dayHeader.classList.add('day-header');
    dayHeader.textContent = day;
    calendarDays.appendChild(dayHeader);
  });

  // Obtener el primer día del mes y el número de días en el mes
  const firstDay = new Date(year, month, 1).getDay(); // Día de la semana del primer día del mes
  const daysInMonth = new Date(year, Number(month) + 1, 0).getDate(); // Número de días en el mes

  // Agregar celdas vacías antes del primer día
  for (let i = 0; i < firstDay; i++) {
    const emptyCell = document.createElement('div');
    emptyCell.classList.add('day');
    calendarDays.appendChild(emptyCell);
  }

  // Crear los días del mes
  for (let day = 1; day <= daysInMonth; day++) {
    const dateStr = `${year}-${String(Number(month) + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
    const dayCell = document.createElement('div');
    dayCell.classList.add('day');
    dayCell.textContent = day;
    // Marcar días festivos en rojo
    if (holidays[dateStr]) {
      dayCell.classList.add('holiday');
      dayCell.title = holidays[dateStr]; // Mostrar el nombre del festivo
    }

    // Agregar clase 'sunday' si el día cae en domingo
    const currentDay = new Date(year, month, day).getDay();
    if (currentDay === 0) { // 0 representa domingo en JavaScript
      dayCell.classList.add('sunday');
    }

    calendarDays.appendChild(dayCell);
  }
}

// Seleccionar los elementos
const reservationForm = document.getElementById('reservationForm');
const closeForm = document.getElementById('closeForm');
const clearForm = document.getElementById('clearForm');
const saveForm = document.getElementById('saveForm');
const eventNameInput = document.querySelector('input[name="eventName"]');
const zoneSelect = document.querySelector('select[name="zone"]');
const startHourSelect = document.querySelector('select[name="startHour"]');
const startMinuteSelect = document.querySelector('select[name="startMinute"]');

// Evento para abrir el formulario al hacer clic en un día disponible
calendarDays.addEventListener('click', (event) => {
  // Verificar si el elemento clickeado es un día del calendario
  if (!event.target.classList.contains('day')) return;
  
  // Si el día está vacío (las celdas del inicio del mes), no hacer nada
  if (!event.target.textContent) return;

  // No abrir el formulario si es domingo o festivo
  if (!event.target.classList.contains('sunday') && !event.target.classList.contains('holiday')) {
    // Obtener la fecha seleccionada
    const day = event.target.textContent;
    const month = monthSelect.value;
    const year = yearSelect.value;
    
    // Guardar la fecha seleccionada (podrías usar esto luego en el formulario)
    const selectedDate = `${year}-${String(Number(month) + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
    
    // Abrir el formulario
    openReservationForm();
  }
});

calendarDays.addEventListener('click', (event) => {
  // Verificar si el elemento clickeado es un día del calendario
  if (!event.target.classList.contains('day')) return;
  
  // Si el día está vacío, no hacer nada
  if (!event.target.textContent) return;

  if (event.target.classList.contains('sunday')) {
    alert('No se pueden hacer reservaciones los domingos');
    return;
  }

  if (event.target.classList.contains('holiday')) {
    alert(`No se pueden hacer reservaciones en días festivos: ${event.target.title}`);
    return;
  }

  // Si llegamos aquí, es un día disponible
  const day = event.target.textContent;
  const month = monthSelect.value;
  const year = yearSelect.value;
  
  const selectedDate = `${year}-${String(Number(month) + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
  
  // Podrías guardar la fecha seleccionada en un campo oculto del formulario
  document.getElementById('selectedDate').value = selectedDate; // Asumiendo que tienes este campo
  
  openReservationForm();
});

  // Evento para actualizar el calendario cuando se cambia el mes o año
  yearSelect.addEventListener('change', updateCalendar);
  monthSelect.addEventListener('change', updateCalendar);

  // Inicializar el calendario al cargar la página
  updateCalendar();
});
