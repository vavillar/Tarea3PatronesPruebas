package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpaDecoratorTest {

    // Stub simple para Componente base
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
    @DisplayName("Debe sumar el precio base y el precio extra correctamente")
    void testPrecioSumaCorrecta() {
        Componente base = new ComponenteStub(100.0, true);
        SpaDecorator spa = new SpaDecorator(base, 25.5);

        assertEquals(125.5, spa.precio(), 0.0001);
    }

    @Test
    @DisplayName("Debe delegar disponibilidad al componente base")
    void testDisponibilidadDelegada() {
        Componente baseDisponible = new ComponenteStub(100.0, true);
        SpaDecorator spaDisponible = new SpaDecorator(baseDisponible, 20.0);
        assertTrue(spaDisponible.estaDisponible());

        Componente baseNoDisponible = new ComponenteStub(100.0, false);
        SpaDecorator spaNoDisponible = new SpaDecorator(baseNoDisponible, 20.0);
        assertFalse(spaNoDisponible.estaDisponible());
    }
}
