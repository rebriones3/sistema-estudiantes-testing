
package modelo;

public class Calculadora {
    
    
    public static double calcularPromedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("El arreglo de notas no puede estar vacío");
        }
        
        double suma = 0.0;
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Las notas deben estar entre 0 y 10");
            }
            suma += nota;
        }
        return suma / notas.length;
    }
    
    public static double calcularPromedioPonderado(double[] notas, double[] pesos) {
        if (notas == null || pesos == null) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos");
        }
        
        if (notas.length != pesos.length) {
            throw new IllegalArgumentException("Los arreglos deben tener la misma longitud");
        }
        
        double sumaPesos = 0.0;
        for (double peso : pesos) {
            sumaPesos += peso;
        }
        
        // Normalizar si los pesos suman 100 en lugar de 1
        boolean normalizar = sumaPesos > 1.5;
        
        double resultado = 0.0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 0 || notas[i] > 10) {
                throw new IllegalArgumentException("Las notas deben estar entre 0 y 10");
            }
            double peso = normalizar ? pesos[i] / 100.0 : pesos[i];
            resultado += notas[i] * peso;
        }
        
        return resultado;
    }
    
    /**
     * Encuentra la nota máxima
     */
    public static double encontrarMaximo(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        
        double max = notas[0];
        for (double nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }
    
    /**
     * Encuentra la nota mínima
     */
    public static double encontrarMinimo(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        
        double min = notas[0];
        for (double nota : notas) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }
    
    /**
     * Redondea una nota a 2 decimales
     */
    public static double redondear(double numero) {
        return Math.round(numero * 100.0) / 100.0;
    }
    
    /**
     * Determina si un estudiante está aprobado
     */
    public static boolean estaAprobado(double promedio) {
        return promedio >= 7.0;
    }
    
    /**
     * Calcula el porcentaje de una nota sobre 10
     */
    public static double calcularPorcentaje(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
        return (nota / 10.0) * 100.0;
    }
    
    /**
     * Calcula cuántos puntos faltan para aprobar
     */
    public static double puntosFaltantesParaAprobar(double promedio) {
        if (promedio < 0 || promedio > 10) {
            throw new IllegalArgumentException("El promedio debe estar entre 0 y 10");
        }
        
        if (promedio >= 7.0) {
            return 0.0;
        }
        return 7.0 - promedio;
    }
}