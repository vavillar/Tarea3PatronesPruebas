package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    
    @Test
    @DisplayName("Crear reserva con paquete disponible debe confirmar")
    void testCrearReservaDisponible() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        PaqueteBuilder builder = new PaqueteConcreteBuilder()
            .agregarHabitacion("101", 80.0);
        
        Reserva reserva = cliente.crearReserva(builder);
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }
    
    @Test
    @DisplayName("Reportar incidente debe retornar resultado adecuado")
    void testReportarIncidente() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        Resultado resultado = cliente.reportarIncidente("Problema test");
        assertEquals(Resultado.RESUELTO, resultado);
    }
}