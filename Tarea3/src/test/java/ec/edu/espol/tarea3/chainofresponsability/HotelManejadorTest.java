package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ec.edu.espol.tarea3.estadosTipos.*;

class HotelManejadorTest {
    
    private HotelManejador manejador;
    
    @BeforeEach
    void setUp() {
        manejador = new HotelManejador();
    }

    @Test
    void testManejarIncidenteHabitacion() {
        Incidente incidente = new Incidente("INC-001", "Problema con la habitación 101");
        assertEquals(Resultado.RESUELTO, manejador.manejar(incidente));
    }

    @Test
    void testManejarIncidenteNoHabitacion() {
        OperadorTuristico siguiente = new OperadorTuristico();
        manejador.setSiguiente(siguiente);
        
        Incidente incidente = new Incidente("INC-002", "Problema con el restaurante");
        assertNotEquals(Resultado.RESUELTO, manejador.manejar(incidente));
    }

    @Test
    void testManejarSinSiguienteManejador() {
        Incidente incidente = new Incidente("INC-003", "Problema con el servicio de limpieza");
        assertEquals(Resultado.NO_RESUELTO, manejador.manejar(incidente));
    }
    
    @Test
    void testManejarIncidenteNulo() {
        assertThrows(NullPointerException.class, () -> manejador.manejar(null));
    }
    
    @Test
    void testManejarIncidenteConAcentos() {
        Incidente incidente = new Incidente("INC-004", "Problema con la HABITACIÓN");
        assertEquals(Resultado.RESUELTO, manejador.manejar(incidente));
    }
}