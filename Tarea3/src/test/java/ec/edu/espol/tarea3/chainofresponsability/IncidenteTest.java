package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IncidenteTest {

    @Test
    @DisplayName("INC-01: Constructor con valores válidos debe crear instancia correctamente")
    public void testConstructorValidos() {
        Incidente incidente = new Incidente("INC-001", "Problema con la habitación");
        
        assertEquals("INC-001", incidente.getId());
        assertEquals("Problema con la habitación", incidente.getDescripcion());
    }

    @Test
    @DisplayName("INC-02: Constructor con ID nulo debe lanzar excepción")
    public void testConstructorIdNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Incidente(null, "Problema con la habitación");
        });
    }

    @Test
    @DisplayName("INC-03: Constructor con descripción nula debe lanzar excepción")
    public void testConstructorDescripcionNula() {
        assertThrows(NullPointerException.class, () -> {
            new Incidente("INC-001", null);
        });
    }

    @Test
    @DisplayName("INC-04: Setter de ID con valor nulo debe lanzar excepción")
    public void testSetterIdNulo() {
        Incidente incidente = new Incidente("INC-001", "Problema test");
        
        assertThrows(NullPointerException.class, () -> {
            incidente.setId(null);
        });
    }

    @Test
    @DisplayName("INC-05: Setter de descripción con valor nulo debe lanzar excepción")
    public void testSetterDescripcionNula() {
        Incidente incidente = new Incidente("INC-001", "Problema test");
        
        assertThrows(NullPointerException.class, () -> {
            incidente.setDescripcion(null);
        });
    }
}