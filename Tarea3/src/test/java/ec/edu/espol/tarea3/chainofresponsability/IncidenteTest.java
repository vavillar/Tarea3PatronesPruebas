package ec.edu.espol.tarea3.chainofresponsability;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.EstadoIncidente;

class IncidenteTest {

    @Test
    @DisplayName("INC-01: Constructor con valores válidos debe crear instancia correctamente")
    void testConstructorValidos() {
        Incidente incidente = new Incidente("INC-001", "Problema con la habitación");
        
        assertAll("Constructor válido",
            () -> assertEquals("INC-001", incidente.getId()),
            () -> assertEquals("Problema con la habitación", incidente.getDescripcion()),
            () -> assertEquals(EstadoIncidente.ABIERTO, incidente.getEstado())
        );
    }

    @Test
    @DisplayName("INC-02: Constructor con ID nulo debe lanzar excepción")
    void testConstructorIdNulo() {
        assertThrows(NullPointerException.class, 
            () -> new Incidente(null, "Problema con la habitación")
        );
    }

    @Test
    @DisplayName("INC-03: Constructor con descripción nula debe lanzar excepción")
    void testConstructorDescripcionNula() {
        assertThrows(NullPointerException.class, 
            () -> new Incidente("INC-001", null)
        );
    }

    @Test
    @DisplayName("INC-04: Setter de ID con valor nulo debe lanzar excepción")
    void testSetterIdNulo() {
        Incidente incidente = new Incidente("INC-001", "Problema test");
        assertThrows(NullPointerException.class, 
            () -> incidente.setId(null)
        );
    }

    @Test
    @DisplayName("INC-05: Setter de descripción con valor nulo debe lanzar excepción")
    void testSetterDescripcionNula() {
        Incidente incidente = new Incidente("INC-001", "Problema test");
        assertThrows(NullPointerException.class, 
            () -> incidente.setDescripcion(null)
        );
    }

    @Test
    @DisplayName("INC-06: Cerrar incidente cambia su estado a CERRADO")
    void testCerrarIncidente() {
        Incidente incidente = new Incidente("INC-001", "Problema test");
        incidente.cerrar();
        assertEquals(EstadoIncidente.CERRADO, incidente.getEstado());
    }
}