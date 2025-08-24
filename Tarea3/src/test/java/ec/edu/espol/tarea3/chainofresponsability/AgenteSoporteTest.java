package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.estadosTipos.*;

public class AgenteSoporteTest {

    @Test
    @DisplayName("AGS-01: Debe resolver incidente con palabra clave 'simple'")
    public void testManejarIncidenteSimple() {
        AgenteSoporte agente = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-001", "Problema simple de conexión");
        
        Resultado resultado = agente.manejar(incidente);
        
        assertEquals(Resultado.RESUELTO, resultado);
    }



    @Test
    @DisplayName("AGS-02: Debe retornar NO_RESUELTO si no hay siguiente manejador")
    public void testManejarSinSiguienteManejador() {
        AgenteSoporte agente = new AgenteSoporte();
        // No configurar siguiente manejador
        
        Incidente incidente = new Incidente("INC-002", "Problema complejo no manejable");
        
        Resultado resultado = agente.manejar(incidente);
        
        assertEquals(Resultado.NO_RESUELTO, resultado);
    }
}