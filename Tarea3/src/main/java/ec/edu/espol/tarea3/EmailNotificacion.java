package ec.edu.espol.tarea3;

public class EmailNotificacion implements ObservadorReserva {
    @Override
    public void actualizar(Reserva reserva) {
        System.out.println("Email: Reserva " + reserva.getId() + " - Estado: " + reserva.getEstado());
    }
}

