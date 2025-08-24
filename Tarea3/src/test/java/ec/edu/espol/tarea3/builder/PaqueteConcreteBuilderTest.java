package ec.edu.espol.tarea3.builder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.composite.Componente;
import ec.edu.espol.tarea3.composite.Habitacion;
import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;

class PaqueteConcreteBuilderTest {
    
    private PaqueteConcreteBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new PaqueteConcreteBuilder();
    }

    @Test
    void testPrecioTotalPaquete() {
        Reserva reserva = builder
            .agregarHabitacion("101", 50.0)
            .agregarPaseo("Tour City", 30.0)
            .agregarPaseo("Tour Playa", 20.0)
            .construir();

        assertEquals(100.0, reserva.getPaquete().precio(), 0.001);
    }

    @Test
    void testPaqueteDisponible() {
        Reserva reserva = builder
            .agregarHabitacion("101", 100.0)
            .agregarPaseo("Tour Gastronómico", 50.0)
            .construir();

        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    void testPaqueteNoDisponible() {
        Habitacion habitacion = new Habitacion("102", 80.0);
        habitacion.setEstado(EstadoHabitacion.OCUPADA);

        Reserva reserva = builder
            .agregarHabitacion("101", 100.0)
            .agregarExtra(habitacion)
            .construir();

        assertFalse(reserva.getPaquete().estaDisponible());
    }

    @Test
    void testPaqueteVacio() {
        Reserva reserva = builder.construir();
        assertEquals(0.0, reserva.getPaquete().precio(), 0.001);
        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    void testAgregarComponenteNulo() {
        Componente componente = null;
        assertThrows(NullPointerException.class, () -> 
            builder.agregarExtra(componente)
        );
    }

    @Test
    void testParametrosInvalidos() {
        assertAll("Validación de parámetros",
            () -> assertThrows(IllegalArgumentException.class, () -> 
                builder.agregarHabitacion("101", -50.0),
                "Debe lanzar excepción con precio negativo"
            ),
            () -> assertThrows(NullPointerException.class, () -> 
                builder.agregarHabitacion(null, 100.0),
                "Debe lanzar excepción con número nulo"
            ),
            () -> assertThrows(NullPointerException.class, () -> 
                builder.agregarPaseo(null, 50.0),
                "Debe lanzar excepción con nombre nulo"
            )
        );
    }

    @Test
    void testHabitacionDuplicada() {
        builder.agregarHabitacion("101", 100.0);
        assertThrows(IllegalArgumentException.class, () -> 
            builder.agregarHabitacion("101", 150.0),
            "Debe lanzar excepción al agregar habitación duplicada"
        );
    }
}