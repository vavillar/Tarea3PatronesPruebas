/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Victor
 */
public class DesayunoDecoratorTest {
    
    public DesayunoDecoratorTest() {
    }
    
    // Stub para Componente base
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
    void testPrecioConDesayuno() {
        Componente base = new ComponenteStub(100.0, true);
        DesayunoDecorator desayuno = new DesayunoDecorator(base, 20.0);
        assertEquals(120.0, desayuno.precio());
    }

    @Test
    void testPrecioConDesayunoCero() {
        Componente base = new ComponenteStub(80.0, true);
        DesayunoDecorator desayuno = new DesayunoDecorator(base, 0.0);
        assertEquals(80.0, desayuno.precio());
    }

    @Test
    void testPrecioConDesayunoNegativo() {
        Componente base = new ComponenteStub(50.0, true);
        DesayunoDecorator desayuno = new DesayunoDecorator(base, -10.0);
        assertEquals(40.0, desayuno.precio());
    }
}
