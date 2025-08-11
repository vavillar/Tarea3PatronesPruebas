package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

class OperadorTuristicoTest {

    @Test
    @DisplayName("Debe devolver RESUELTO si la descripción contiene 'tour'")
    void testManejarConTour() {
        OperadorTuristico operador = new OperadorTuristico();
        Incidente incidente = new Incidente("INC-001", "Problema con el tour de la mañana");

        Resultado resultado = operador.manejar(incidente);

        assertEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    @DisplayName("Debe devolver ESCALADO si la descripción no contiene 'tour'")
    void testManejarSinTour() {
        OperadorTuristico operador = new OperadorTuristico();
        Incidente incidente = new Incidente("INC-002", "Problema con transporte al hotel");

        Resultado resultado = operador.manejar(incidente);

        assertEquals(Resultado.ESCALADO, resultado);
    }
}