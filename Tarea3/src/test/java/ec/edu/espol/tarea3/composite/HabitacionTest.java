/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3.composite;

import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;
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
public class HabitacionTest {
    
    public HabitacionTest() {
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
     * Test of precio method, of class Habitacion.
     */
    @Test
    public void testPrecio() {
        System.out.println("precio");
        Habitacion instance = null;
        double expResult = 0.0;
        double result = instance.precio();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaDisponible method, of class Habitacion.
     */
    @Test
    public void testEstaDisponible() {
        System.out.println("estaDisponible");
        Habitacion instance = null;
        boolean expResult = false;
        boolean result = instance.estaDisponible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Habitacion.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoHabitacion ocupada = null;
        Habitacion instance = null;
        instance.setEstado(ocupada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
