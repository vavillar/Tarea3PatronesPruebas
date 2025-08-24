package ec.edu.espol.tarea3.builder;

import ec.edu.espol.tarea3.composite.Componente;

public interface PaqueteBuilder {
    PaqueteBuilder agregarHabitacion(String numero, double precio);

    PaqueteBuilder agregarPaseo(String nombre, double precio);

    PaqueteBuilder agregarExtra(Componente extra);

    Reserva construir(); // Ahora construye directamente la Reserva
}