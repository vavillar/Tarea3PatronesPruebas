package ec.edu.espol.tarea3.composite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.estadosTipos.*;

public class HabitacionTest {

    @Test
    @DisplayName("HAB-01: Constructor con valores válidos debe crear instancia correctamente")
    public void testConstructorValidos() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        
        assertEquals("101", habitacion.getNumero());
        assertEquals(150.0, habitacion.precio(), 0.001);
        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.getEstado());
        assertTrue(habitacion.estaDisponible());
    }

    @Test
    @DisplayName("HAB-02: Constructor con número nulo debe lanzar excepción")
    public void testConstructorNumeroNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Habitacion(null, 150.0);
        });
    }

    @Test
    @DisplayName("HAB-03: Constructor con número vacío debe lanzar excepción")
    public void testConstructorNumeroVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Habitacion("", 150.0);
        });
    }

    @Test
    @DisplayName("HAB-04: Constructor con precio negativo debe lanzar excepción")
    public void testConstructorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Habitacion("101", -50.0);
        });
    }

    @Test
    @DisplayName("HAB-05: Precio cero debe ser permitido")
    public void testConstructorPrecioCero() {
        assertDoesNotThrow(() -> {
            Habitacion habitacion = new Habitacion("102", 0.0);
            assertEquals(0.0, habitacion.precio(), 0.001);
        });
    }

    @Test
    @DisplayName("HAB-06: Estado inicial debe ser DISPONIBLE")
    public void testEstadoInicialDisponible() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.getEstado());
        assertTrue(habitacion.estaDisponible());
    }

    @Test
    @DisplayName("HAB-07: Cambio de estado a OCUPADA debe afectar disponibilidad")
    public void testEstadoOcupada() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        habitacion.setEstado(EstadoHabitacion.OCUPADA);
        
        assertEquals(EstadoHabitacion.OCUPADA, habitacion.getEstado());
        assertFalse(habitacion.estaDisponible());
    }

    @Test
    @DisplayName("HAB-08: Cambio de estado a MANTENIMIENTO debe afectar disponibilidad")
    public void testEstadoMantenimiento() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        habitacion.setEstado(EstadoHabitacion.MANTENIMIENTO);
        
        assertEquals(EstadoHabitacion.MANTENIMIENTO, habitacion.getEstado());
        assertFalse(habitacion.estaDisponible());
    }

    @Test
    @DisplayName("HAB-09: Setter de estado nulo debe lanzar excepción")
    public void testSetterEstadoNulo() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        
        assertThrows(NullPointerException.class, () -> {
            habitacion.setEstado(null);
        });
    }

    @Test
    @DisplayName("HAB-10: Precio debe mantenerse consistente después de cambios de estado")
    public void testPrecioConsistente() {
        Habitacion habitacion = new Habitacion("101", 150.0);
        double precioInicial = habitacion.precio();
        
        habitacion.setEstado(EstadoHabitacion.OCUPADA);
        assertEquals(precioInicial, habitacion.precio(), 0.001);
        
        habitacion.setEstado(EstadoHabitacion.MANTENIMIENTO);
        assertEquals(precioInicial, habitacion.precio(), 0.001);
    }
}