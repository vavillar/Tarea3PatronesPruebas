package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaqueteCompuestoTest {

    // ---- Stub para Componente ----
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
    @DisplayName("Debe sumar correctamente el precio de todos los componentes")
    void testPrecioTotal() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new ComponenteStub(100.0, true));
        paquete.agregar(new ComponenteStub(50.5, true));
        paquete.agregar(new ComponenteStub(25.0, true));

        double esperado = 100.0 + 50.5 + 25.0;
        assertEquals(esperado, paquete.precio(), 0.0001);
    }

    @Test
    @DisplayName("Debe estar disponible si todos los componentes están disponibles")
    void testEstaDisponibleTodosDisponibles() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new ComponenteStub(100.0, true));
        paquete.agregar(new ComponenteStub(50.0, true));

        assertTrue(paquete.estaDisponible());
    }

    @Test
    @DisplayName("Debe NO estar disponible si al menos un componente no está disponible")
    void testNoDisponibleSiUnComponenteNoDisponible() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new ComponenteStub(100.0, true));
        paquete.agregar(new ComponenteStub(50.0, false)); // uno no disponible

        assertFalse(paquete.estaDisponible());
    }
}