package ec.edu.espol.tarea3;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

public class HotelManejador extends ManejadorIncidente {

    @Override
    public Resultado manejar(Incidente incidente) {
        if (incidente.getDescripcion().contains("habitación")) {
            return Resultado.RESUELTO;
        }
        return siguiente != null ? siguiente.manejar(incidente) : Resultado.NO_RESUELTO;
    }
}

