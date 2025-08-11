package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

class HotelManejadorTest {

    @Test
    @DisplayName("Debe resolver incidente si la descripción contiene 'habitación'")
    void testManejarConHabitacion() {
        HotelManejador manejador = new HotelManejador();
        Incidente incidente = new Incidente("INC-1", "Problema con la habitación 101");

        Resultado resultado = manejador.manejar(incidente);

        assertEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    @DisplayName("Debe devolver NO_RESUELTO si no contiene 'habitación' y no hay siguiente manejador")
    void testManejarSinHabitacionSinSiguiente() {
        HotelManejador manejador = new HotelManejador();
        Incidente incidente = new Incidente("INC-2", "Problema con el restaurante");

        Resultado resultado = manejador.manejar(incidente);

        assertEquals(Resultado.NO_RESUELTO, resultado);
    }

    @Test
    @DisplayName("Debe delegar al siguiente manejador si no contiene 'habitación'")
    void testManejarSinHabitacionConSiguiente() {
        HotelManejador manejador = new HotelManejador();

        // Siguiente manejador de prueba
        ManejadorIncidente siguiente = new ManejadorIncidente() {
            @Override
            public Resultado manejar(Incidente incidente) {
                return Resultado.RESUELTO;
            }
        };
        manejador.setSiguiente(siguiente);

        Incidente incidente = new Incidente("INC-3", "Problema con el restaurante");

        Resultado resultado = manejador.manejar(incidente);

        assertEquals(Resultado.RESUELTO, resultado);
    }
}
