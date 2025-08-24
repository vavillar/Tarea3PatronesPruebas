package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.estadosTipos.*;

public class HotelManejadorTest {

    @Test
    @DisplayName("HOT-01: Debe resolver incidente con palabra clave 'habitación'")
    public void testManejarIncidenteHabitacion() {
        HotelManejador manejador = new HotelManejador();
        Incidente incidente = new Incidente("INC-001", "Problema con la habitación 101");
        
        Resultado resultado = manejador.manejar(incidente);
        
        assertEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    @DisplayName("HOT-02: Debe escalar incidente sin palabra clave 'habitación'")
    public void testManejarIncidenteNoHabitacion() {
        HotelManejador manejador = new HotelManejador();
        // Configurar siguiente manejador
        OperadorTuristico siguiente = new OperadorTuristico();
        manejador.setSiguiente(siguiente);
        
        Incidente incidente = new Incidente("INC-002", "Problema con el restaurante");
        
        Resultado resultado = manejador.manejar(incidente);
        
        // El manejador hotel no puede manejar este incidente, lo pasa al siguiente
        assertNotEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    @DisplayName("HOT-03: Debe retornar NO_RESUELTO si no hay siguiente manejador")
    public void testManejarSinSiguienteManejador() {
        HotelManejador manejador = new HotelManejador();
        // No configurar siguiente manejador
        
        Incidente incidente = new Incidente("INC-003", "Problema con el servicio de limpieza");
        
        Resultado resultado = manejador.manejar(incidente);
        
        assertEquals(Resultado.NO_RESUELTO, resultado);
    }
}