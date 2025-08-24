package ec.edu.espol.tarea3.composite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.estadosTipos.EstadoPaseo;

public class PaseoTest {

    @Test
    @DisplayName("PAS-01: Constructor con valores válidos debe crear instancia correctamente")
    public void testConstructorValidos() {
        Paseo paseo = new Paseo("Tour City", 75.0);
        
        assertEquals("Tour City", paseo.getNombre());
        assertEquals(75.0, paseo.precio(), 0.001);
        assertEquals(EstadoPaseo.DISPONIBLE, paseo.getEstado());
        assertTrue(paseo.estaDisponible());
    }

    @Test
    @DisplayName("PAS-02: Constructor con nombre nulo debe lanzar excepción")
    public void testConstructorNombreNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Paseo(null, 75.0);
        });
    }

    @Test
    @DisplayName("PAS-03: Constructor con nombre vacío debe lanzar excepción")
    public void testConstructorNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Paseo("", 75.0);
        });
    }

    @Test
    @DisplayName("PAS-04: Constructor con precio negativo debe lanzar excepción")
    public void testConstructorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Paseo("Tour Beach", -25.0);
        });
    }

    @Test
    @DisplayName("PAS-05: Constructor con precio cero debe ser permitido")
    public void testConstructorPrecioCero() {
        assertDoesNotThrow(() -> {
            Paseo paseo = new Paseo("Free Tour", 0.0);
            assertEquals(0.0, paseo.precio(), 0.001);
        });
    }

    @Test
    @DisplayName("PAS-06: Estado inicial debe ser DISPONIBLE")
    public void testEstadoInicialDisponible() {
        Paseo paseo = new Paseo("Tour Mountain", 100.0);
        assertEquals(EstadoPaseo.DISPONIBLE, paseo.getEstado());
        assertTrue(paseo.estaDisponible());
    }

    @Test
    @DisplayName("PAS-07: Cambio de estado a COMPLETO debe afectar disponibilidad")
    public void testEstadoCompleto() {
        Paseo paseo = new Paseo("Tour River", 60.0);
        paseo.setEstado(EstadoPaseo.COMPLETO);
        
        assertEquals(EstadoPaseo.COMPLETO, paseo.getEstado());
        assertFalse(paseo.estaDisponible());
    }

    @Test
    @DisplayName("PAS-08: Cambio de estado a CANCELADO debe afectar disponibilidad")
    public void testEstadoCancelado() {
        Paseo paseo = new Paseo("Tour Forest", 80.0);
        paseo.setEstado(EstadoPaseo.CANCELADO);
        
        assertEquals(EstadoPaseo.CANCELADO, paseo.getEstado());
        assertFalse(paseo.estaDisponible());
    }

    @Test
    @DisplayName("PAS-09: Setter de estado nulo debe lanzar excepción")
    public void testSetterEstadoNulo() {
        Paseo paseo = new Paseo("Tour Desert", 90.0);
        
        assertThrows(NullPointerException.class, () -> {
            paseo.setEstado(null);
        });
    }

    @Test
    @DisplayName("PAS-10: Precio debe mantenerse consistente después de cambios de estado")
    public void testPrecioConsistente() {
        Paseo paseo = new Paseo("Tour Volcano", 120.0);
        double precioInicial = paseo.precio();
        
        paseo.setEstado(EstadoPaseo.COMPLETO);
        assertEquals(precioInicial, paseo.precio(), 0.001);
        
        paseo.setEstado(EstadoPaseo.CANCELADO);
        assertEquals(precioInicial, paseo.precio(), 0.001);
    }

    @Test
    @DisplayName("PAS-11: Paseo cancelado debe seguir teniendo precio pero no disponible")
    public void testPaseoCanceladoConPrecio() {
        Paseo paseo = new Paseo("Tour Cancelled", 50.0);
        paseo.setEstado(EstadoPaseo.CANCELADO);
        
        assertEquals(50.0, paseo.precio(), 0.001);
        assertFalse(paseo.estaDisponible());
    }
}