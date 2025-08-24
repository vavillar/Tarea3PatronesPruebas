package ec.edu.espol.tarea3.composite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;
import ec.edu.espol.tarea3.estadosTipos.EstadoPaseo;

import org.junit.jupiter.api.DisplayName;
import java.util.List;

public class PaqueteCompuestoTest {

    @Test
    @DisplayName("PAC-01: Paquete vacío debe tener precio 0 y estar disponible")
    public void testPaqueteVacio() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();

        assertEquals(0.0, paquete.precio(), 0.001);
        assertTrue(paquete.estaDisponible());
        assertTrue(paquete.getComponentes().isEmpty());
    }

    @Test
    @DisplayName("PAC-02: Agregar componente nulo debe lanzar excepción")
    public void testAgregarComponenteNulo() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();

        assertThrows(NullPointerException.class, () -> {
            paquete.agregar(null);
        });
    }

    @Test
    @DisplayName("PAC-03: Precio debe sumar correctamente múltiples componentes")
    public void testPrecioSumaComponentes() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("101", 100.0));
        paquete.agregar(new Habitacion("102", 150.0));
        paquete.agregar(new Paseo("Tour City", 50.0));

        assertEquals(300.0, paquete.precio(), 0.001);
        assertEquals(3, paquete.getComponentes().size());
    }

    @Test
    @DisplayName("PAC-04: Debe estar disponible si todos los componentes están disponibles")
    public void testDisponibleTodosComponentesDisponibles() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("101", 100.0));
        paquete.agregar(new Paseo("Tour Beach", 75.0));

        assertTrue(paquete.estaDisponible());
    }

    @Test
    @DisplayName("PAC-05: No debe estar disponible si algún componente no está disponible")
    public void testNoDisponibleComponenteNoDisponible() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Habitacion habitacionOcupada = new Habitacion("101", 100.0);
        habitacionOcupada.setEstado(EstadoHabitacion.OCUPADA);

        paquete.agregar(habitacionOcupada);
        paquete.agregar(new Paseo("Tour Mountain", 60.0));

        assertFalse(paquete.estaDisponible());
    }

    @Test
    @DisplayName("PAC-06: Lista de componentes debe ser consistente")
    public void testListaComponentesConsistente() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Habitacion habitacion = new Habitacion("101", 100.0);
        Paseo paseo = new Paseo("Tour River", 40.0);

        paquete.agregar(habitacion);
        paquete.agregar(paseo);

        List<Componente> componentes = paquete.getComponentes();
        assertEquals(2, componentes.size());
        assertTrue(componentes.contains(habitacion));
        assertTrue(componentes.contains(paseo));
    }

    @Test
    @DisplayName("PAC-07: Paquete con componente de precio cero debe ser válido")
    public void testComponentePrecioCero() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("101", 0.0));
        paquete.agregar(new Paseo("Free Tour", 0.0));

        assertEquals(0.0, paquete.precio(), 0.001);
        assertTrue(paquete.estaDisponible());
    }

    @Test
    @DisplayName("PAC-08: Paquete con múltiples componentes no disponibles")
    public void testMultiplesComponentesNoDisponibles() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();

        Habitacion habitacionOcupada = new Habitacion("101", 100.0);
        habitacionOcupada.setEstado(EstadoHabitacion.OCUPADA);

        Paseo paseoCancelado = new Paseo("Tour Cancelado", 50.0);
        paseoCancelado.setEstado(EstadoPaseo.CANCELADO);

        paquete.agregar(habitacionOcupada);
        paquete.agregar(paseoCancelado);

        assertFalse(paquete.estaDisponible());
    }
}