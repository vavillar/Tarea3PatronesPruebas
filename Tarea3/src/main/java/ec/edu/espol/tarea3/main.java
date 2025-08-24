package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.builder.*;
import ec.edu.espol.tarea3.chainofresponsability.*;
import ec.edu.espol.tarea3.estadosTipos.Resultado;
public class main {
    public static void main(String[] args) {
        ManejadorIncidente manejador = new AgenteSoporte();
        ManejadorIncidente siguiente = new HotelManejador();
        manejador.setSiguiente(siguiente);

        // 2. Crear cliente
        Cliente cliente = new Cliente(manejador);

        // 3. Construir paquete personalizado
        PaqueteBuilder builder = new PaqueteConcreteBuilder()
            .agregarHabitacion("201", 100.0)
            .agregarPaseo("Tour Gastronómico", 60.0);

        // 4. Intentar reserva
        Reserva reserva = cliente.crearReserva(builder);

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