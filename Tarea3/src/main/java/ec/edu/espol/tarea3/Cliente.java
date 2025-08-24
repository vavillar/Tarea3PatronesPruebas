package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.estadosTipos.Resultado;


public final class Cliente {
  private final ReservaService reservas;
  private final IncidenteService incidentes;

  public Cliente(ReservaService reservas, IncidenteService incidentes){
    this.reservas = reservas;
    this.incidentes = incidentes;
  }

  public Reserva crearReserva(){ return reservas.crearYConfirmar(); }
  public Resultado reportarIncidente(String descripcion){ return incidentes.reportar(descripcion); }
}