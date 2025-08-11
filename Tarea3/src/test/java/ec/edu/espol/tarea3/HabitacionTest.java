package ec.edu.espol.tarea3;

<<<<<<< Updated upstream
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
>>>>>>> Stashed changes
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

<<<<<<< Updated upstream
public class HabitacionTest {
    
    @Test
    @DisplayName("Precio de habitación debe coincidir con el valor asignado")
    void testPrecio() {
        Habitacion hab = new Habitacion("101", 50.0);
        assertEquals(50.0, hab.precio());
    }
    
    @Test
    @DisplayName("Habitación nueva debe estar disponible")
    void testEstaDisponible() {
        Habitacion hab = new Habitacion("101", 50.0);
        assertTrue(hab.estaDisponible());
=======
import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;

class HabitacionTest {

    @Test
    @DisplayName("El precio debe coincidir con el asignado en el constructor")
    void testPrecio() {
        Habitacion habitacion = new Habitacion("101", 80.5);
        assertEquals(80.5, habitacion.precio());
    }

    @Test
    @DisplayName("Una habitación nueva debe estar disponible")
    void testHabitacionNuevaDisponible() {
        Habitacion habitacion = new Habitacion("101", 80.5);
        assertTrue(habitacion.estaDisponible(), "La habitación nueva debería estar disponible");
    }

    @Test
    @DisplayName("Habitación no disponible si se cambia el estado")
    void testHabitacionNoDisponible() throws Exception {
        Habitacion habitacion = new Habitacion("101", 80.5);

        // Cambiamos el estado usando reflexión (no hay setter público)
        var campoEstado = Habitacion.class.getDeclaredField("estado");
        campoEstado.setAccessible(true);
        campoEstado.set(habitacion, EstadoHabitacion.OCUPADA);

        assertFalse(habitacion.estaDisponible(), "La habitación ocupada no debería estar disponible");
>>>>>>> Stashed changes
    }
}