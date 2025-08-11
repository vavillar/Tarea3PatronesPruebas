package ec.edu.espol.tarea3;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;

public class Reserva {
    private final String id;
    private EstadoReserva estado;
    private final Componente paquete; // Relación directa con el paquete construido
    private final List<ObservadorReserva> observadores = new ArrayList<>();

    public Reserva(Componente paquete) {
        this.id = "RES-" + System.currentTimeMillis();
        this.estado = EstadoReserva.PENDIENTE;
        this.paquete = paquete;
    }

    // Getters
    public String getId() { return id; }
    public EstadoReserva getEstado() { return estado; }
    public double getPrecioTotal() { return paquete.precio(); }

    // Control de estado + notificaciones
    public void confirmar() {
        this.estado = EstadoReserva.CONFIRMADA;
        notificar("Reserva CONFIRMADA: " + id);
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
        notificar("Reserva CANCELADA: " + id);
    }

    private void notificar(String mensaje) {
        observadores.forEach(o -> o.actualizar(this));
    }

    public void agregarObservador(ObservadorReserva o) {
        observadores.add(o);
    }
}

