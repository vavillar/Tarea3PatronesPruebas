package ec.edu.espol.tarea3.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ec.edu.espol.tarea3.composite.*;
import ec.edu.espol.tarea3.decorator.SpaDecorator;
import ec.edu.espol.tarea3.estadosTipos.*;
import org.junit.jupiter.api.DisplayName;

/**
 * Pruebas para la clase PaqueteConcreteBuilder
 */
public class PaqueteConcreteBuilderTest {

    @Test
    @DisplayName("PAC-01: Debe sumar correctamente el precio de todos los componentes")
    public void testPrecioTotalPaquete() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Reserva reserva = builder
                .agregarHabitacion("101", 50.0)
                .agregarPaseo("Tour City", 30.0)
                .agregarPaseo("Tour Playa", 20.0)
                .construir();

        double precioEsperado = 50.0 + 30.0 + 20.0;
        assertEquals(precioEsperado, reserva.getPaquete().precio(), 0.0001);
    }

    @Test
    @DisplayName("PAC-02: Debe estar disponible si todos los componentes están disponibles")
    public void testPaqueteDisponibleTodosComponentesDisponibles() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Reserva reserva = builder
                .agregarHabitacion("101", 100.0)
                .agregarPaseo("Tour Gastronómico", 50.0)
                .construir();

        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    @DisplayName("PAC-03: Debe NO estar disponible si al menos un componente no está disponible")
    public void testPaqueteNoDisponibleSiUnComponenteNoDisponible() {
        Habitacion habitacion = new Habitacion("102", 80.0);
        habitacion.setEstado(EstadoHabitacion.OCUPADA);

        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Reserva reserva = builder
                .agregarHabitacion("101", 100.0)
                .agregarExtra(habitacion)
                .agregarPaseo("Tour Cultural", 40.0)
                .construir();

        assertFalse(reserva.getPaquete().estaDisponible());
    }

    @Test
    @DisplayName("SPA-01: Debe sumar el precio base y el precio extra correctamente")
    public void testSpaDecoratorPrecio() {
        Componente base = new Habitacion("201", 100.0);
        SpaDecorator spa = new SpaDecorator(base, 20.0);

        assertEquals(120.0, spa.precio(), 0.0001);
    }

    @Test
    @DisplayName("SPA-02: Debe delegar disponibilidad cuando componente base disponible")
    public void testSpaDecoratorDisponible() {
        Componente baseDisponible = new Habitacion("201", 100.0);
        SpaDecorator spa = new SpaDecorator(baseDisponible, 20.0);

        assertTrue(spa.estaDisponible());
    }

    @Test
    @DisplayName("BLD-01: Paquete vacío debe tener precio 0 y estar disponible")
    public void testPaqueteVacio() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Reserva reserva = builder.construir();

        assertEquals(0.0, reserva.getPaquete().precio(), 0.0001);
        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    @DisplayName("BLD-02: Agregar componente nulo debe lanzar excepción")
    public void testAgregarExtraNulo() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();

        assertThrows(NullPointerException.class, () -> {
            builder.agregarExtra(null);
        });
    }

    @Test
    @DisplayName("BLD-03: Builder con parámetros inválidos debe manejarse adecuadamente")
    public void testBuilderParametrosInvalidos() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();

        // Precio negativo - no debería permitirse 
        assertDoesNotThrow(() -> builder.agregarHabitacion("101", -50.0));

        // Número de habitación null - debe lanzar excepción
        assertThrows(NullPointerException.class, () -> {
            builder.agregarHabitacion(null, 100.0);
        });

        // Nombre de paseo null - debe lanzar excepción
        assertThrows(NullPointerException.class, () -> {
            builder.agregarPaseo(null, 50.0);
        });
    }

    /**
     * Identificador: BLD-LIM-02
     * Propósito: Validar comportamiento con componentes duplicados
     * Precondiciones: PaqueteConcreteBuilder instanciado
     * Entradas: Múltiples habitaciones con el mismo número
     * Salida esperada: Precio suma correctamente, disponibilidad según los estados
     */
@Test
@DisplayName("BLD-04: Debe lanzar excepción al agregar habitación con ID duplicado")
public void testHabitacionDuplicadaLanzaExcepcion() {
    PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
    
    // Agregar primera habitación (debería funcionar)
    builder.agregarHabitacion("101", 100.0);
    
    // Intentar agregar habitación con mismo ID - debería lanzar excepción
    assertThrows(IllegalArgumentException.class, () -> {
        builder.agregarHabitacion("101", 150.0);
    });
}





}