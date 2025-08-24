package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ec.edu.espol.tarea3.estadosTipos.*;

class AgenteSoporteTest {
    
    private AgenteSoporte agente;
    
    @BeforeEach
    void setUp() {
        agente = new AgenteSoporte();
    }

    @Test
    void testManejarIncidenteSimple() {
        Incidente incidente = new Incidente("INC-001", "Problema simple de conexión");
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }

    @Test
    void testManejarSinSiguienteManejador() {
        Incidente incidente = new Incidente("INC-002", "Problema complejo");
        assertEquals(Resultado.NO_RESUELTO, agente.manejar(incidente));
    }

    @Test
    void testManejarConSiguienteManejador() {
        // Crear un manejador siguiente que siempre resuelve
        ManejadorIncidente siguienteManejador = new ManejadorIncidente() {
            @Override
            public Resultado manejar(Incidente incidente) {
                return Resultado.RESUELTO;
            }
        };
        
        agente.setSiguiente(siguienteManejador);
        Incidente incidente = new Incidente("INC-003", "Problema complejo");
        
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }

    @Test
    void testManejarIncidenteNulo() {
        assertThrows(NullPointerException.class, () -> agente.manejar(null));
    }
}