package ec.edu.espol.tarea3;
import java.util.ArrayList;
import java.util.List;

import ec.edu.espol.tarea3.observer.ObservadorReserva;


public final class NotificadorReservas {
  private final List<ObservadorReserva> obs = new ArrayList<>();

  public void suscribir(ObservadorReserva o){ obs.add(o); }
  
}