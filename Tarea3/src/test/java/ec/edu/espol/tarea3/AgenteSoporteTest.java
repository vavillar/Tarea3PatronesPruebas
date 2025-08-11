package ec.edu.espol.tarea3;

<<<<<<< Updated upstream
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

>>>>>>> Stashed changes
import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenteSoporteTest {
    
<<<<<<< Updated upstream
    @Test
    @DisplayName("Debe resolver incidentes simples")
=======
    public AgenteSoporteTest() {
    }
    
    @Test
    @DisplayName("Debe manejar un incidente simple correctamente")
    public void testManejar() {
        AgenteSoporte instance = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-0", "Incidente simple: luz no funciona");
        Resultado expResult = Resultado.RESUELTO;
        Resultado result = instance.manejar(incidente);
        assertEquals(expResult, result);
    }
    
    @Test
    @DisplayName("Debe manejar un incidente complejo correctamente")
>>>>>>> Stashed changes
    void testManejarIncidenteSimple() {
        AgenteSoporte agente = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-001", "Problema simple");
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }
    
    @Test
<<<<<<< Updated upstream
    @DisplayName("Debe escalar incidentes complejos al siguiente manejador")
    void testManejarIncidenteComplejo() {
=======
    @DisplayName("Debe manejar un incidente complejo sin resolver")
    void testManejarIncidenteNoResueltoSinSiguiente() {
>>>>>>> Stashed changes
        AgenteSoporte agente = new AgenteSoporte();
        agente.setSiguiente(new HotelManejador());
        Incidente incidente = new Incidente("INC-002", "Problema con TV");
        assertEquals(Resultado.RESUELTO, agente.manejar(incidente));
    }
<<<<<<< Updated upstream
}
=======

    @Test
    @DisplayName("Debe manejar un incidente complejo con siguiente manejador")
    void testManejarIncidenteNoResueltoConSiguiente() {
        AgenteSoporte agente = new AgenteSoporte();
        // Stub para siguiente manejador
        ManejadorIncidente siguienteStub = new ManejadorIncidente() {
            @Override
            public Resultado manejar(Incidente incidente) {
                return Resultado.RESUELTO;
            }
        };
        agente.setSiguiente(siguienteStub);

        Incidente incidente = new Incidente("INC-3", "Incidente complejo: fuga de agua");
        Resultado resultado = agente.manejar(incidente);
        assertEquals(Resultado.RESUELTO, resultado);
    }
}
>>>>>>> Stashed changes
