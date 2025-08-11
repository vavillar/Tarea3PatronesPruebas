package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenteSoporteTest {
    
    @Test
    @DisplayName("Debe resolver incidentes simples")
    void testManejarIncidenteSimple() {
        AgenteSoporte agente = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-001", "Problema simple");
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }
    
    @Test
    @DisplayName("Debe escalar incidentes complejos al siguiente manejador")
    void testManejarIncidenteComplejo() {
        AgenteSoporte agente = new AgenteSoporte();
        agente.setSiguiente(new HotelManejador());
        Incidente incidente = new Incidente("INC-002", "Problema con TV");
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }
}