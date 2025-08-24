package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.estadosTipos.*;

public class OperadorTuristicoTest {

    @Test
    @DisplayName("OPT-01: Debe resolver incidente con palabra clave 'tour'")
    public void testManejarIncidenteConTour() {
        OperadorTuristico operador = new OperadorTuristico();
        Incidente incidente = new Incidente("INC-001", "Problema con el tour de la mañana");
        
        Resultado resultado = operador.manejar(incidente);
        
        assertEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    @DisplayName("OPT-02: Debe escalar incidente sin palabra clave 'tour'")
    public void testManejarIncidenteSinTour() {
        OperadorTuristico operador = new OperadorTuristico();
        Incidente incidente = new Incidente("INC-002", "Problema con el transporte al hotel");
        
        Resultado resultado = operador.manejar(incidente);
        
        assertEquals(Resultado.ESCALADO, resultado);
    }

    @Test
    @DisplayName("OPT-03: Debe manejar incidente nulo lanzando excepción")
    public void testManejarIncidenteNulo() {
        OperadorTuristico operador = new OperadorTuristico();
        
        assertThrows(NullPointerException.class, () -> {
            operador.manejar(null);
        });
    }
}