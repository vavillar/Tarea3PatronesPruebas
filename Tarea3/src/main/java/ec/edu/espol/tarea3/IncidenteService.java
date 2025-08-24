package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.chainofresponsability.Incidente;
import ec.edu.espol.tarea3.chainofresponsability.ManejadorIncidente;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

public final class IncidenteService {
    private final ManejadorIncidente manejadorIncidentes;

    public IncidenteService(ManejadorIncidente manejador) {
        if (manejador == null) {
            throw new NullPointerException("El manejador no puede ser null");
        }
        this.manejadorIncidentes = manejador;
    }

    public Resultado reportar(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser null o vacía");
        }

        String id = "INC-" + System.currentTimeMillis();
        Incidente incidente = new Incidente(id, descripcion);
        return manejadorIncidentes.manejar(incidente);
    }
}
