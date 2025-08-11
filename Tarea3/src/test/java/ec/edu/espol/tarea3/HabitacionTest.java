package ec.edu.espol.tarea3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HabitacionTest {
    
    @Test
    @DisplayName("Precio de habitación debe coincidir con el valor asignado")
    void testPrecio() {
        Habitacion hab = new Habitacion("101", 50.0);
        assertEquals(50.0, hab.precio());
    }
    
    @Test
    @DisplayName("Habitación nueva debe estar disponible")
    void testEstaDisponible() {
        Habitacion hab = new Habitacion("101", 50.0);
        assertTrue(hab.estaDisponible());
    }
}