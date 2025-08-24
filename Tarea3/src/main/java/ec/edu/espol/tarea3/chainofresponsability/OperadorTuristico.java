package ec.edu.espol.tarea3.chainofresponsability;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

public class OperadorTuristico extends ManejadorIncidente {

    @Override
    public Resultado manejar(Incidente incidente) {
        if (incidente == null) {
            throw new NullPointerException("El incidente no puede ser null");
        }
        if (incidente.getDescripcion().toLowerCase().contains("tour")) {
            return Resultado.RESUELTO;
        }
        return Resultado.ESCALADO;
    }
}

