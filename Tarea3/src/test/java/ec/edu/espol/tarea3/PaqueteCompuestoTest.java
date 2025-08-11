package ec.edu.espol.tarea3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaqueteCompuestoTest {
    
    @Test
    @DisplayName("Agregar componente incrementa el tamaño de la lista")
    void testAgregarComponente() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("201", 75.0));
        assertEquals(1, paquete.getComponentes().size());
    }
    
    @Test
    @DisplayName("Precio total debe sumar correctamente los componentes")
    void testPrecio() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("201", 75.0));
        paquete.agregar(new Paseo("Tour", 30.0));
        assertEquals(105.0, paquete.precio());
    }
    
    @Test
    @DisplayName("Paquete debe estar disponible si todos sus componentes lo están")
    void testEstaDisponible() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(new Habitacion("201", 75.0));
        assertTrue(paquete.estaDisponible());
    }
}