package ec.edu.espol.tarea3.observer;

import ec.edu.espol.tarea3.builder.Reserva;

public class MovilNotificacion implements ObservadorReserva {
    @Override
    public void actualizar(Reserva reserva) {
        System.out.println("SMS: Reserva " + reserva.getId() + " - Estado: " + reserva.getEstado());
    }
}

