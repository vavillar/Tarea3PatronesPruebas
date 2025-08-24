package ec.edu.espol.tarea3;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.tarea3.builder.PaqueteBuilder;
import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.chainofresponsability.Incidente;
import ec.edu.espol.tarea3.chainofresponsability.ManejadorIncidente;
import ec.edu.espol.tarea3.estadosTipos.Resultado;
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
        reserva.confirmarSegunDisponibilidad();
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