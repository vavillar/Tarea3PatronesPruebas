package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

public class Cliente {
    private ManejadorIncidente manejadorIncidentes;

    public Cliente(ManejadorIncidente manejadorIncidentes) {
        this.manejadorIncidentes = manejadorIncidentes;
    }

    // Método para crear reservas
    public Reserva crearReserva() {
        PaqueteBuilder builder = new PaqueteConcreteBuilder();
        return builder
            .agregarHabitacion("101", 80.0)
            .agregarPaseo("Tour Histórico", 45.0)
            .agregarExtra(new SpaDecorator(new Habitacion("101", 80.0), 25.0))
            .construir();
    }

    // Método para reportar incidentes
    public Resultado reportarIncidente(String descripcion) {
        Incidente incidente = new Incidente("INC-" + System.currentTimeMillis(), descripcion);
        return manejadorIncidentes.manejar(incidente);
    }
}
