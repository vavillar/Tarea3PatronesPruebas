package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaqueteConcreteBuilderTest {

    // Stub para un componente extra controlado
    static class ComponenteStub implements Componente {
        private final double precio;
        private final boolean disponible;

        ComponenteStub(double precio, boolean disponible) {
            this.precio = precio;
            this.disponible = disponible;
        }

        @Override
        public double precio() {
            return precio;
        }

        @Override
        public boolean estaDisponible() {
            return disponible;
        }
    }

    @Test
    @DisplayName("Debe construir un paquete con habitación y paseo correctamente")
    void testConstruirConHabitacionYPaseo() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Reserva reserva = builder
                .agregarHabitacion("101", 100.0)
                .agregarPaseo("City Tour", 50.0)
                .construir();

        double precioEsperado = 100.0 + 50.0;
        assertEquals(precioEsperado, reserva.getPaquete().precio(), 0.0001);
        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    @DisplayName("Debe permitir agregar extras al paquete")
    void testAgregarExtra() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Componente extra = new ComponenteStub(30.0, true);

        Reserva reserva = builder
                .agregarExtra(extra)
                .construir();

        assertEquals(30.0, reserva.getPaquete().precio(), 0.0001);
        assertTrue(reserva.getPaquete().estaDisponible());
    }

    @Test
    @DisplayName("Debe reflejar disponibilidad falsa si un componente no está disponible")
    void testDisponibilidadFalsaConExtraNoDisponible() {
        PaqueteConcreteBuilder builder = new PaqueteConcreteBuilder();
        Componente noDisponible = new ComponenteStub(40.0, false);

        Reserva reserva = builder
                .agregarHabitacion("102", 80.0)
                .agregarExtra(noDisponible)
                .construir();

        assertFalse(reserva.getPaquete().estaDisponible());
    }
}
