/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3.builder;

import ec.edu.espol.tarea3.composite.PaqueteCompuesto;
import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.observer.ObservadorReserva;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor
 */
public class ReservaTest {
    
    public ReservaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarObservador method, of class Reserva.
     */
    @Test
    public void testAgregarObservador() {
        System.out.println("agregarObservador");
        ObservadorReserva observador = null;
        Reserva instance = null;
        instance.agregarObservador(observador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Reserva.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoReserva nuevoEstado = null;
        Reserva instance = null;
        instance.setEstado(nuevoEstado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Reserva.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Reserva instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Reserva instance = null;
        EstadoReserva expResult = null;
        EstadoReserva result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaquete method, of class Reserva.
     */
    @Test
    public void testGetPaquete() {
        System.out.println("getPaquete");
        Reserva instance = null;
        PaqueteCompuesto expResult = null;
        PaqueteCompuesto result = instance.getPaquete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
