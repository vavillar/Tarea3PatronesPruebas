package ec.edu.espol.tarea3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.observer.EmailNotificacion;

class EmailNotificacionTest {
    
    private EmailNotificacion emailNotificacion;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        emailNotificacion = new EmailNotificacion();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        outputStreamCaptor.reset();
    }

    private static class ReservaStub extends Reserva {
        private final String id;
        private final EstadoReserva estado;

        public ReservaStub(String id, EstadoReserva estado) {
            super(null);
            this.id = id;
            this.estado = estado;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public EstadoReserva getEstado() {
            return estado;
        }
    }

    @Test
    void testNotificacionReservaConfirmada() {
        ReservaStub reserva = new ReservaStub("R001", EstadoReserva.CONFIRMADA);
        emailNotificacion.actualizar(reserva);
        
        String expectedOutput = "Email: Reserva R001 - Estado: CONFIRMADA";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testNotificacionReservaCancelada() {
        ReservaStub reserva = new ReservaStub("R002", EstadoReserva.CANCELADA);
        emailNotificacion.actualizar(reserva);
        
        String expectedOutput = "Email: Reserva R002 - Estado: CANCELADA";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testNotificacionReservaConIdVacio() {
        ReservaStub reserva = new ReservaStub("", EstadoReserva.CONFIRMADA);
        emailNotificacion.actualizar(reserva);
        
        String expectedOutput = "Email: Reserva  - Estado: CONFIRMADA";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
