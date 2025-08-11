package ec.edu.espol.tarea3;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.EstadoPaseo;


class PaseoTest {

    @Test
    @DisplayName("El precio debe coincidir con el valor pasado en el constructor")
    void testPrecio() {
        Paseo paseo = new Paseo("City Tour", 75.0);
        assertEquals(75.0, paseo.precio(), 0.0001);
    }

    @Test
    @DisplayName("Debe estar disponible por defecto")
    void testDisponibilidadPorDefecto() {
        Paseo paseo = new Paseo("City Tour", 75.0);
        assertTrue(paseo.estaDisponible());
    }

    @Test
    @DisplayName("Debe retornar false si el estado no es DISPONIBLE")
    void testNoDisponible() throws Exception {
        Paseo paseo = new Paseo("City Tour", 75.0);

        // Usamos reflexión para cambiar el estado privado
        Field estadoField = Paseo.class.getDeclaredField("estado");
        estadoField.setAccessible(true);
        estadoField.set(paseo, EstadoPaseo.NO_DISPONIBLE);

        assertFalse(paseo.estaDisponible());
    }
}