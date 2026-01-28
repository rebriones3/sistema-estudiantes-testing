/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    
  
    @Test
    @DisplayName("Calcular promedio con notas válidas")
    public void testCalcularPromedioValido() {
        double[] notas = {8.0, 7.0, 9.0};
        double esperado = (8.0 + 7.0 + 9.0) / 3.0;
        assertEquals(esperado, Calculadora.calcularPromedio(notas), 0.001);
    }
    
    @Test
    @DisplayName("Calcular promedio con todas las notas iguales")
    public void testCalcularPromedioNotasIguales() {
        double[] notas = {7.5, 7.5, 7.5};
        assertEquals(7.5, Calculadora.calcularPromedio(notas), 0.001);
    }
    
    @Test
    @DisplayName("Calcular promedio con una sola nota")
    public void testCalcularPromedioUnaNota() {
        double[] notas = {8.5};
        assertEquals(8.5, Calculadora.calcularPromedio(notas), 0.001);
    }
    
    @Test
    @DisplayName("Calcular promedio con arreglo nulo lanza excepción")
    public void testCalcularPromedioArregloNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedio(null);
        });
        assertTrue(exception.getMessage().contains("vacío"));
    }
    
    @Test
    @DisplayName("Calcular promedio con arreglo vacío lanza excepción")
    public void testCalcularPromedioArregloVacio() {
        double[] notas = {};
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedio(notas);
        });
    }
    
    @Test
    @DisplayName("Calcular promedio con nota fuera de rango lanza excepción")
    public void testCalcularPromedioNotaInvalida() {
        double[] notas = {8.0, 11.0, 9.0};
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedio(notas);
        });
    }
    
    @Test
    @DisplayName("Calcular promedio con nota negativa lanza excepción")
    public void testCalcularPromedioNotaNegativa() {
        double[] notas = {8.0, -1.0, 9.0};
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedio(notas);
        });
    }
    
    // ========== PRUEBAS DE PROMEDIO PONDERADO ==========
    
    @Test
    @DisplayName("Calcular promedio ponderado con pesos normalizados")
    public void testPromedioPonderadoNormalizado() {
        double[] notas = {8.0, 9.0, 7.0};
        double[] pesos = {0.3, 0.3, 0.4}; // suman 1.0
        
        double esperado = 8.0 * 0.3 + 9.0 * 0.3 + 7.0 * 0.4;
        assertEquals(esperado, Calculadora.calcularPromedioPonderado(notas, pesos), 0.001);
    }
    
    @Test
    @DisplayName("Calcular promedio ponderado con pesos en porcentaje")
    public void testPromedioPonderadoPorcentaje() {
        double[] notas = {8.0, 9.0, 7.0};
        double[] pesos = {30, 30, 40}; // suman 100
        
        double esperado = 8.0 * 0.3 + 9.0 * 0.3 + 7.0 * 0.4;
        assertEquals(esperado, Calculadora.calcularPromedioPonderado(notas, pesos), 0.001);
    }
    
    @Test
    @DisplayName("Promedio ponderado con arreglos nulos lanza excepción")
    public void testPromedioPonderadoArreglosNulos() {
        double[] notas = {8.0, 9.0};
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedioPonderado(null, notas);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedioPonderado(notas, null);
        });
    }
    
    @Test
    @DisplayName("Promedio ponderado con arreglos de distinto tamaño lanza excepción")
    public void testPromedioPonderadoTamañosDiferentes() {
        double[] notas = {8.0, 9.0, 7.0};
        double[] pesos = {0.5, 0.5};
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedioPonderado(notas, pesos);
        });
        assertTrue(exception.getMessage().contains("misma longitud"));
    }
    
    @Test
    @DisplayName("Promedio ponderado con nota inválida lanza excepción")
    public void testPromedioPonderadoNotaInvalida() {
        double[] notas = {8.0, 15.0, 7.0};
        double[] pesos = {0.3, 0.3, 0.4};
        
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPromedioPonderado(notas, pesos);
        });
    }
    
    // ========== PRUEBAS DE MÁXIMO Y MÍNIMO ==========
    
    @Test
    @DisplayName("Encontrar nota máxima")
    public void testEncontrarMaximo() {
        double[] notas = {7.5, 9.0, 8.0, 6.5};
        assertEquals(9.0, Calculadora.encontrarMaximo(notas));
    }
    
    @Test
    @DisplayName("Encontrar máximo con todas las notas iguales")
    public void testEncontrarMaximoNotasIguales() {
        double[] notas = {8.0, 8.0, 8.0};
        assertEquals(8.0, Calculadora.encontrarMaximo(notas));
    }
    
    @Test
    @DisplayName("Encontrar máximo con una sola nota")
    public void testEncontrarMaximoUnaNota() {
        double[] notas = {7.5};
        assertEquals(7.5, Calculadora.encontrarMaximo(notas));
    }
    
    @Test
    @DisplayName("Encontrar máximo con arreglo nulo lanza excepción")
    public void testEncontrarMaximoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.encontrarMaximo(null);
        });
    }
    
    @Test
    @DisplayName("Encontrar nota mínima")
    public void testEncontrarMinimo() {
        double[] notas = {7.5, 9.0, 8.0, 6.5};
        assertEquals(6.5, Calculadora.encontrarMinimo(notas));
    }
    
    @Test
    @DisplayName("Encontrar mínimo con todas las notas iguales")
    public void testEncontrarMinimoNotasIguales() {
        double[] notas = {8.0, 8.0, 8.0};
        assertEquals(8.0, Calculadora.encontrarMinimo(notas));
    }
    
    @Test
    @DisplayName("Encontrar mínimo con arreglo vacío lanza excepción")
    public void testEncontrarMinimoVacio() {
        double[] notas = {};
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.encontrarMinimo(notas);
        });
    }
    
    // ========== PRUEBAS DE REDONDEO ==========
    
    @Test
    @DisplayName("Redondear número con decimales")
    public void testRedondear() {
        assertEquals(7.55, Calculadora.redondear(7.5499));
        assertEquals(7.56, Calculadora.redondear(7.5567));
        assertEquals(8.00, Calculadora.redondear(7.999));
    }
    
    @Test
    @DisplayName("Redondear número entero")
    public void testRedondearEntero() {
        assertEquals(8.00, Calculadora.redondear(8.0));
    }
    
    // ========== PRUEBAS DE APROBACIÓN ==========
    
    @Test
    @DisplayName("Estudiante está aprobado")
    public void testEstaAprobado() {
        assertTrue(Calculadora.estaAprobado(7.0));
        assertTrue(Calculadora.estaAprobado(8.5));
        assertTrue(Calculadora.estaAprobado(10.0));
    }
    
    @Test
    @DisplayName("Estudiante está reprobado")
    public void testEstaReprobado() {
        assertFalse(Calculadora.estaAprobado(6.9));
        assertFalse(Calculadora.estaAprobado(5.0));
        assertFalse(Calculadora.estaAprobado(0.0));
    }
    
    @Test
    @DisplayName("Valor límite de aprobación")
    public void testValorLimiteAprobacion() {
        assertTrue(Calculadora.estaAprobado(7.0));
        assertFalse(Calculadora.estaAprobado(6.99));
    }
    
    // ========== PRUEBAS DE PORCENTAJE ==========
    
    @Test
    @DisplayName("Calcular porcentaje de nota")
    public void testCalcularPorcentaje() {
        assertEquals(80.0, Calculadora.calcularPorcentaje(8.0));
        assertEquals(100.0, Calculadora.calcularPorcentaje(10.0));
        assertEquals(0.0, Calculadora.calcularPorcentaje(0.0));
        assertEquals(75.0, Calculadora.calcularPorcentaje(7.5));
    }
    
    @Test
    @DisplayName("Calcular porcentaje con nota inválida lanza excepción")
    public void testCalcularPorcentajeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPorcentaje(11.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcularPorcentaje(-1.0);
        });
    }
    
    // ========== PRUEBAS DE PUNTOS FALTANTES ==========
    
    @Test
    @DisplayName("Calcular puntos faltantes para aprobar")
    public void testPuntosFaltantesParaAprobar() {
        assertEquals(1.0, Calculadora.puntosFaltantesParaAprobar(6.0), 0.001);
        assertEquals(2.5, Calculadora.puntosFaltantesParaAprobar(4.5), 0.001);
        assertEquals(0.5, Calculadora.puntosFaltantesParaAprobar(6.5), 0.001);
    }
    
    @Test
    @DisplayName("Puntos faltantes cuando ya está aprobado")
    public void testPuntosFaltantesYaAprobado() {
        assertEquals(0.0, Calculadora.puntosFaltantesParaAprobar(7.0));
        assertEquals(0.0, Calculadora.puntosFaltantesParaAprobar(8.5));
        assertEquals(0.0, Calculadora.puntosFaltantesParaAprobar(10.0));
    }
    
    @Test
    @DisplayName("Puntos faltantes con promedio inválido lanza excepción")
    public void testPuntosFaltantesPromedioInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.puntosFaltantesParaAprobar(-1.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.puntosFaltantesParaAprobar(11.0);
        });
    }
}
