package ec.edu.espol.tarea3.decorator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.composite.*;

public class DesayunoDecoratorTest {

    @Test
    @DisplayName("DES-01: Componente nulo debe lanzar excepción")
    public void testComponenteNulo() {
        assertThrows(NullPointerException.class, () -> {
            new DesayunoDecorator(null, 15.0);
        });
    }

    @Test
    @DisplayName("DES-02: Precio extra negativo debe lanzar excepción")
    public void testPrecioExtraNegativo() {
        Componente habitacion = new Habitacion("101", 100.0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            new DesayunoDecorator(habitacion, -10.0);
        });
    }

    @Test
    @DisplayName("DES-03: Precio extra Double.MAX_VALUE debe lanzar excepción")
    public void testPrecioExtraMaxValue() {
        Componente habitacion = new Habitacion("102", 100.0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            new DesayunoDecorator(habitacion, Double.MAX_VALUE);
        });
    }
}