package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.observer.EmailNotificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class EmailNotificacionTest {
    
    private EmailNotificacion emailNotificacion;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        emailNotificacion = new EmailNotificacion();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Clase auxiliar para simular una Reserva
    private static class ReservaStub extends Reserva {
        private final String id;
        private final String estado;

        public ReservaStub(String id, String estado) {
            super(null);
            this.id = id;
            this.estado = estado;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getEstado() {
            return estado;
        }
    }

    @Test
    void testActualizarNotificacion() {
        // Arrange
        ReservaStub reserva = new ReservaStub("R001", "CONFIRMADA");
        
        // Act
        emailNotificacion.actualizar(reserva);
        
        // Assert
        String expectedOutput = "Email: Reserva R001 - Estado: CONFIRMADA";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testActualizarNotificacionCancelada() {
        ReservaStub reserva = new ReservaStub("R002", "CANCELADA");
        emailNotificacion.actualizar(reserva);
        String expectedOutput = "Email: Reserva R002 - Estado: CANCELADA";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    // Limpieza después de cada test
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
