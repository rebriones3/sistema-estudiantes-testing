/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestorEstudiantesTest {
    
    private GestorEstudiantes gestor;
    private Estudiante estudiante1;
    private Estudiante estudiante2;
    
    @BeforeEach
    public void setUp() {
        gestor = new GestorEstudiantes();
        estudiante1 = new Estudiante("1234567890", "Juan", "Pérez", "juan@email.com");
        estudiante2 = new Estudiante("0987654321", "María", "García", "maria@email.com");
    }
    
    // ========== PRUEBAS DE AGREGAR ==========
    
    @Test
    @DisplayName("Agregar estudiante válido")
    public void testAgregarEstudianteValido() {
        assertTrue(gestor.agregarEstudiante(estudiante1));
        assertEquals(1, gestor.contarEstudiantes());
    }
    
    @Test
    @DisplayName("Agregar estudiante nulo lanza excepción")
    public void testAgregarEstudianteNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.agregarEstudiante(null);
        });
        assertEquals("El estudiante no puede ser nulo", exception.getMessage());
    }
    
    @Test
    @DisplayName("Agregar estudiante sin cédula lanza excepción")
    public void testAgregarEstudianteSinCedula() {
        Estudiante estudianteSinCedula = new Estudiante();
        estudianteSinCedula.setNombre("Pedro");
        
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.agregarEstudiante(estudianteSinCedula);
        });
    }
    
    @Test
    @DisplayName("Agregar estudiante con cédula duplicada lanza excepción")
    public void testAgregarCedulaDuplicada() {
        gestor.agregarEstudiante(estudiante1);
        
        Estudiante duplicado = new Estudiante("1234567890", "Pedro", "López", "pedro@email.com");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.agregarEstudiante(duplicado);
        });
        assertTrue(exception.getMessage().contains("Ya existe"));
    }
    
    @Test
    @DisplayName("Agregar múltiples estudiantes")
    public void testAgregarMultiplesEstudiantes() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        assertEquals(2, gestor.contarEstudiantes());
    }
    
    // ========== PRUEBAS DE BUSCAR ==========
    
    @Test
    @DisplayName("Buscar estudiante existente por cédula")
    public void testBuscarPorCedulaExistente() {
        gestor.agregarEstudiante(estudiante1);
        
        Estudiante encontrado = gestor.buscarPorCedula("1234567890");
        assertNotNull(encontrado);
        assertEquals("Juan", encontrado.getNombre());
    }
    
    @Test
    @DisplayName("Buscar estudiante inexistente retorna null")
    public void testBuscarPorCedulaInexistente() {
        gestor.agregarEstudiante(estudiante1);
        
        Estudiante encontrado = gestor.buscarPorCedula("9999999999");
        assertNull(encontrado);
    }
    
    @Test
    @DisplayName("Buscar con cédula nula retorna null")
    public void testBuscarPorCedulaNula() {
        assertNull(gestor.buscarPorCedula(null));
    }
    
    @Test
    @DisplayName("Buscar por nombre parcial")
    public void testBuscarPorNombre() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        List<Estudiante> resultados = gestor.buscarPorNombre("Juan");
        assertEquals(1, resultados.size());
        assertEquals("Juan", resultados.get(0).getNombre());
    }
    
    @Test
    @DisplayName("Buscar por apellido")
    public void testBuscarPorApellido() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        List<Estudiante> resultados = gestor.buscarPorNombre("García");
        assertEquals(1, resultados.size());
        assertEquals("María", resultados.get(0).getNombre());
    }
    
    @Test
    @DisplayName("Buscar con texto vacío retorna lista vacía")
    public void testBuscarPorNombreVacio() {
        gestor.agregarEstudiante(estudiante1);
        
        List<Estudiante> resultados = gestor.buscarPorNombre("");
        assertEquals(0, resultados.size());
    }
    
    // ========== PRUEBAS DE ELIMINAR ==========
    
    @Test
    @DisplayName("Eliminar estudiante existente")
    public void testEliminarEstudianteExistente() {
        gestor.agregarEstudiante(estudiante1);
        assertEquals(1, gestor.contarEstudiantes());
        
        assertTrue(gestor.eliminarEstudiante("1234567890"));
        assertEquals(0, gestor.contarEstudiantes());
    }
    
    @Test
    @DisplayName("Eliminar estudiante inexistente retorna false")
    public void testEliminarEstudianteInexistente() {
        gestor.agregarEstudiante(estudiante1);
        
        assertFalse(gestor.eliminarEstudiante("9999999999"));
        assertEquals(1, gestor.contarEstudiantes());
    }
    
    @Test
    @DisplayName("Eliminar con cédula nula retorna false")
    public void testEliminarCedulaNula() {
        assertFalse(gestor.eliminarEstudiante(null));
    }
    
    // ========== PRUEBAS DE ACTUALIZAR NOTAS ==========
    
    @Test
    @DisplayName("Actualizar notas válidas")
    public void testActualizarNotasValidas() {
        gestor.agregarEstudiante(estudiante1);
        
        assertTrue(gestor.actualizarNotas("1234567890", 8.0, 7.5, 9.0));
        
        Estudiante estudiante = gestor.buscarPorCedula("1234567890");
        assertEquals(8.0, estudiante.getNotaParcial1());
        assertEquals(7.5, estudiante.getNotaParcial2());
        assertEquals(9.0, estudiante.getNotaFinal());
    }
    
    @Test
    @DisplayName("Actualizar con nota negativa lanza excepción")
    public void testActualizarNotaNegativa() {
        gestor.agregarEstudiante(estudiante1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.actualizarNotas("1234567890", -1.0, 8.0, 9.0);
        });
    }
    
    @Test
    @DisplayName("Actualizar con nota mayor a 10 lanza excepción")
    public void testActualizarNotaMayorA10() {
        gestor.agregarEstudiante(estudiante1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.actualizarNotas("1234567890", 8.0, 11.0, 9.0);
        });
    }
    
    @Test
    @DisplayName("Actualizar notas de estudiante inexistente retorna false")
    public void testActualizarNotasEstudianteInexistente() {
        assertFalse(gestor.actualizarNotas("9999999999", 8.0, 7.0, 9.0));
    }
    
    // ========== PRUEBAS DE VALIDACIÓN ==========
    
    @Test
    @DisplayName("Validar nota válida")
    public void testValidarNotaValida() {
        assertTrue(gestor.validarNota(0.0));
        assertTrue(gestor.validarNota(5.0));
        assertTrue(gestor.validarNota(10.0));
    }
    
    @Test
    @DisplayName("Validar nota inválida")
    public void testValidarNotaInvalida() {
        assertFalse(gestor.validarNota(-0.1));
        assertFalse(gestor.validarNota(10.1));
    }
    
    @Test
    @DisplayName("Validar email válido")
    public void testValidarEmailValido() {
        assertTrue(gestor.validarEmail("usuario@dominio.com"));
        assertTrue(gestor.validarEmail("test@test.com.ec"));
    }
    
    @Test
    @DisplayName("Validar email inválido")
    public void testValidarEmailInvalido() {
        assertFalse(gestor.validarEmail("correosinArroba.com"));
        assertFalse(gestor.validarEmail("correo@sinpunto"));
        assertFalse(gestor.validarEmail(null));
        assertFalse(gestor.validarEmail(""));
    }
    
    @Test
    @DisplayName("Validar cédula válida")
    public void testValidarCedulaValida() {
        assertTrue(gestor.validarCedula("1234567890"));
    }
    
    @Test
    @DisplayName("Validar cédula inválida")
    public void testValidarCedulaInvalida() {
        assertFalse(gestor.validarCedula("123"));
        assertFalse(gestor.validarCedula("12345678901"));
        assertFalse(gestor.validarCedula("abcdefghij"));
        assertFalse(gestor.validarCedula(null));
    }
    
    // ========== PRUEBAS DE CÁLCULOS ==========
    
    @Test
    @DisplayName("Calcular promedio general sin estudiantes")
    public void testPromedioGeneralSinEstudiantes() {
        assertEquals(0.0, gestor.calcularPromedioGeneral());
    }
    
    @Test
    @DisplayName("Calcular promedio general con estudiantes")
    public void testPromedioGeneralConEstudiantes() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        gestor.actualizarNotas("1234567890", 8.0, 8.0, 8.0); // promedio 8.0
        gestor.actualizarNotas("0987654321", 6.0, 6.0, 6.0); // promedio 6.0
        
        double promedioEsperado = (8.0 + 6.0) / 2.0;
        assertEquals(promedioEsperado, gestor.calcularPromedioGeneral(), 0.001);
    }
    
    // ========== PRUEBAS DE APROBADOS/REPROBADOS ==========
    
    @Test
    @DisplayName("Obtener estudiantes aprobados")
    public void testObtenerAprobados() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        gestor.actualizarNotas("1234567890", 8.0, 8.0, 8.0); // aprobado
        gestor.actualizarNotas("0987654321", 5.0, 5.0, 5.0); // reprobado
        
        List<Estudiante> aprobados = gestor.obtenerAprobados();
        assertEquals(1, aprobados.size());
        assertEquals("Juan", aprobados.get(0).getNombre());
    }
    
    @Test
    @DisplayName("Obtener estudiantes reprobados")
    public void testObtenerReprobados() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        gestor.actualizarNotas("1234567890", 8.0, 8.0, 8.0); // aprobado
        gestor.actualizarNotas("0987654321", 5.0, 5.0, 5.0); // reprobado
        
        List<Estudiante> reprobados = gestor.obtenerReprobados();
        assertEquals(1, reprobados.size());
        assertEquals("María", reprobados.get(0).getNombre());
    }
    
    @Test
    @DisplayName("Obtener aprobados sin estudiantes")
    public void testObtenerAprobadosSinEstudiantes() {
        List<Estudiante> aprobados = gestor.obtenerAprobados();
        assertEquals(0, aprobados.size());
    }
    
    // ========== PRUEBAS DE UTILIDAD ==========
    
    @Test
    @DisplayName("Obtener todos los estudiantes")
    public void testObtenerTodos() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        
        List<Estudiante> todos = gestor.obtenerTodos();
        assertEquals(2, todos.size());
    }
    
    @Test
    @DisplayName("Limpiar todos los estudiantes")
    public void testLimpiar() {
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        assertEquals(2, gestor.contarEstudiantes());
        
        gestor.limpiar();
        assertEquals(0, gestor.contarEstudiantes());
    }
    
    @Test
    @DisplayName("Contar estudiantes vacío")
    public void testContarEstudiantesVacio() {
        assertEquals(0, gestor.contarEstudiantes());
    }
}
