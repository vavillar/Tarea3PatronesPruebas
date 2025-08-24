package ec.edu.espol.tarea3.builder;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.tarea3.composite.PaqueteCompuesto;
import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.observer.ObservadorReserva;

public class Reserva {
    private String id;
    private EstadoReserva estado;
    private PaqueteCompuesto paquete;
    private List<ObservadorReserva> observadores = new ArrayList<>();

    public Reserva(PaqueteCompuesto paquete) {
        this.id = "RES-" + System.currentTimeMillis();
        this.estado = EstadoReserva.PENDIENTE;
        this.paquete = paquete;
    }

    // Métodos para Observer
    public void agregarObservador(ObservadorReserva observador) {
        observadores.add(observador);
    }

    public void setEstado(EstadoReserva nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (ObservadorReserva obs : observadores) {
            obs.actualizar(this);
        }
    }
    // Método para confirmar reserva según disponibilidad del paquete
    public void confirmarSegunDisponibilidad() {
        this.estado = paquete.estaDisponible()
                ? EstadoReserva.CONFIRMADA
                : EstadoReserva.RECHAZADA;
    }

    // Getters
    public String getId() { return id; }
    public EstadoReserva getEstado() { return estado; }
    public PaqueteCompuesto getPaquete() { return paquete; }
}
