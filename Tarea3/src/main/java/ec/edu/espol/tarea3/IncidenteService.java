package ec.edu.espol.tarea3;
import ec.edu.espol.tarea3.chainofresponsability.DescripcionIncidente;
import ec.edu.espol.tarea3.chainofresponsability.Incidente;
import ec.edu.espol.tarea3.chainofresponsability.ManejadorIncidente;
import ec.edu.espol.tarea3.estadosTipos.Resultado;



public final class IncidenteService {
  private final ManejadorIncidente manejadorIncidentes;

  public IncidenteService(ManejadorIncidente manejador){ this.manejadorIncidentes = manejador; }

  public Resultado reportar(String descripcion){
    DescripcionIncidente desc = DescripcionIncidente.of(descripcion);
        Incidente incidente = new Incidente("INC-" + System.currentTimeMillis(), desc);
        return manejadorIncidentes.manejar(incidente);
  }
}
