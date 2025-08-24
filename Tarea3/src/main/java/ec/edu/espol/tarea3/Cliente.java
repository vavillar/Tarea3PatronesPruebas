package ec.edu.espol.tarea3;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.tarea3.builder.*;
import ec.edu.espol.tarea3.chainofresponsability.*;
import ec.edu.espol.tarea3.estadosTipos.*;
import ec.edu.espol.tarea3.observer.ObservadorReserva;


public class Cliente {
    private final ManejadorIncidente manejadorIncidentes;
    private final List<ObservadorReserva> observadores;

    public Cliente(ManejadorIncidente manejadorIncidentes) {
        this.manejadorIncidentes = manejadorIncidentes;
        this.observadores = new ArrayList<>();
    }
     //Reserva con estado CONFIRMADA o RECHAZADA
    public Reserva crearReserva(PaqueteBuilder builder) {
        Reserva reserva = builder.construir(); // Intenta construir
        
        // Verifica disponibilidad post-construcción
        if (reserva.getPaquete().estaDisponible()) {
            reserva.setEstado(EstadoReserva.CONFIRMADA);
        } else {
            reserva.setEstado(EstadoReserva.RECHAZADA);
        }
        
        return reserva;
    }

    public Resultado reportarIncidente(String descripcion) {
        Incidente incidente = new Incidente("INC-" + System.currentTimeMillis(), descripcion);
        return manejadorIncidentes.manejar(incidente);
    }

    public void agregarObservador(ObservadorReserva observador) {
        observadores.add(observador);
    }

}