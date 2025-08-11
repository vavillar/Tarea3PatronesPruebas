package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ComponenteTest {

    // Clase de prueba que implementa Componente
    static class ComponenteStub implements Componente {
        private final double precio;
        private final boolean disponible;

        public ComponenteStub(double precio, boolean disponible) {
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
    void testPrecio() {
        Componente componente = new ComponenteStub(150.0, true);
        assertEquals(150.0, componente.precio());
    }

    @Test
    void testEstaDisponibleTrue() {
        Componente componente = new ComponenteStub(50.0, true);
        assertTrue(componente.estaDisponible());
    }

    @Test
    void testEstaDisponibleFalse() {
        Componente componente = new ComponenteStub(50.0, false);
        assertFalse(componente.estaDisponible());
    }
}