package ec.edu.espol.tarea3;
import ec.edu.espol.tarea3.builder.PaqueteBuilder;
import ec.edu.espol.tarea3.builder.Reserva;

public final class ReservaService {
  private final PaqueteBuilder builder;
  public ReservaService(PaqueteBuilder builder){ this.builder = builder; }

  public Reserva crearYConfirmar() {
    Reserva r = builder.construir();
    r.confirmarSegunDisponibilidad();
    return r;
  }
}
