package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.builder.PaqueteBuilder;
import ec.edu.espol.tarea3.builder.PaqueteConcreteBuilder;
import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.chainofresponsability.AgenteSoporte;
import ec.edu.espol.tarea3.chainofresponsability.HotelManejador;
import ec.edu.espol.tarea3.chainofresponsability.ManejadorIncidente;
import ec.edu.espol.tarea3.composite.PaqueteCompuesto;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

public class main {
    public static void main(String[] args) {
        ManejadorIncidente manejador = new AgenteSoporte();
        ManejadorIncidente siguiente = new HotelManejador();
        manejador.setSiguiente(siguiente);
        
        // 3. Construir paquete personalizado
        PaqueteBuilder builder = new PaqueteConcreteBuilder()
            .agregarHabitacion("201", 100.0)
            .agregarPaseo("Tour Gastronómico", 60.0);

        // 2. Crear cliente
        Cliente cliente = new Cliente(new ReservaService(builder), new IncidenteService(manejador));

        // 4. Intentar reserva
        PaqueteCompuesto paquete = builder.construir().getPaquete();
        Reserva reserva = cliente.crearReserva();

        // 5. Procesar resultado
        switch(reserva.getEstado()) {
            case CONFIRMADA:
                System.out.println("¡Reserva confirmada! Precio: $" + reserva.getPaquete().precio());
                
                // Ejemplo: Reportar incidente (uso de Chain of Responsibility)
                Resultado resultado = cliente.reportarIncidente("¿A qué hora es el check-in?");
                System.out.println("Estado del incidente: " + resultado);
                break;
                
            case RECHAZADA:
                System.out.println("No se pudo completar la reserva (falta de disponibilidad)");
                break;
        }
    }
}