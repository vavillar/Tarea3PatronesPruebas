package ec.edu.espol.tarea3.chainofresponsability;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

public class OperadorTuristico extends ManejadorIncidente {

    @Override
    public Resultado manejar(Incidente incidente) {
        if (incidente.getDescripcion().contains("tour")) {
            return Resultado.RESUELTO;
        }
        return Resultado.ESCALADO;
    }
}

