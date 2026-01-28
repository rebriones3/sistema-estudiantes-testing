/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {
    
    private Estudiante estudiante;
    
    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante("1234567890", "Juan", "Pérez", "juan.perez@email.com");
    }
    
    @Test
    @DisplayName("Constructor inicializa correctamente los atributos")
    public void testConstructor() {
        assertEquals("1234567890", estudiante.getCedula());
        assertEquals("Juan", estudiante.getNombre());
        assertEquals("Pérez", estudiante.getApellido());
        assertEquals("juan.perez@email.com", estudiante.getEmail());
        assertEquals(0.0, estudiante.getNotaParcial1());
        assertEquals(0.0, estudiante.getNotaParcial2());
        assertEquals(0.0, estudiante.getNotaFinal());
    }
    
    @Test
    @DisplayName("Setters actualizan correctamente los valores")
    public void testSetters() {
        estudiante.setNotaParcial1(8.5);
        estudiante.setNotaParcial2(9.0);
        estudiante.setNotaFinal(7.5);
        
        assertEquals(8.5, estudiante.getNotaParcial1());
        assertEquals(9.0, estudiante.getNotaParcial2());
        assertEquals(7.5, estudiante.getNotaFinal());
    }
    
    @Test
    @DisplayName("getNombreCompleto devuelve nombre y apellido concatenados")
    public void testGetNombreCompleto() {
        assertEquals("Juan Pérez", estudiante.getNombreCompleto());
    }
    
    @Test
    @DisplayName("calcularPromedio con notas cero")
    public void testCalcularPromedioConCeros() {
        assertEquals(0.0, estudiante.calcularPromedio());
    }
    
    @Test
    @DisplayName("calcularPromedio con notas normales")
    public void testCalcularPromedioNormal() {
        estudiante.setNotaParcial1(8.0);
        estudiante.setNotaParcial2(7.0);
        estudiante.setNotaFinal(9.0);
        
        double esperado = (8.0 + 7.0 + 9.0) / 3.0;
        assertEquals(esperado, estudiante.calcularPromedio(), 0.001);
    }
    
    @Test
    @DisplayName("calcularPromedio con notas máximas")
    public void testCalcularPromedioNotasMaximas() {
        estudiante.setNotaParcial1(10.0);
        estudiante.setNotaParcial2(10.0);
        estudiante.setNotaFinal(10.0);
        
        assertEquals(10.0, estudiante.calcularPromedio());
    }
    
    @Test
    @DisplayName("toString contiene información del estudiante")
    public void testToString() {
        estudiante.setNotaParcial1(8.0);
        estudiante.setNotaParcial2(7.0);
        estudiante.setNotaFinal(9.0);
        
        String resultado = estudiante.toString();
        assertTrue(resultado.contains("1234567890"));
        assertTrue(resultado.contains("Juan Pérez"));
        assertTrue(resultado.contains("juan.perez@email.com"));
    }
}
