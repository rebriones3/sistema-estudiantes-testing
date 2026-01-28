
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;


public class GestorEstudiantes {
    
    private List<Estudiante> estudiantes;
    
    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }
    
    /**
     * Agrega un estudiante al sistema
     * @param estudiante
     * @return true si se agregó exitosamente
     */
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        
        if (estudiante.getCedula() == null || estudiante.getCedula().isEmpty()) {
            throw new IllegalArgumentException("La cédula es obligatoria");
        }
        
        if (buscarPorCedula(estudiante.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe un estudiante con esa cédula");
        }
        
        return estudiantes.add(estudiante);
    }
    
    /**
     * Elimina un estudiante por cédula
     */
    public boolean eliminarEstudiante(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            return false;
        }
        
        Estudiante estudiante = buscarPorCedula(cedula);
        if (estudiante != null) {
            return estudiantes.remove(estudiante);
        }
        return false;
    }
    
    /**
     * Busca un estudiante por cédula
     */
    public Estudiante buscarPorCedula(String cedula) {
        if (cedula == null) {
            return null;
        }
        
        for (Estudiante est : estudiantes) {
            if (est.getCedula().equals(cedula)) {
                return est;
            }
        }
        return null;
    }
    
    /**
     * Actualiza las notas de un estudiante
     */
    public boolean actualizarNotas(String cedula, double parcial1, double parcial2, double notaFinal) {
        if (!validarNota(parcial1) || !validarNota(parcial2) || !validarNota(notaFinal)) {
            throw new IllegalArgumentException("Las notas deben estar entre 0 y 10");
        }
        
        Estudiante estudiante = buscarPorCedula(cedula);
        if (estudiante != null) {
            estudiante.setNotaParcial1(parcial1);
            estudiante.setNotaParcial2(parcial2);
            estudiante.setNotaFinal(notaFinal);
            return true;
        }
        return false;
    }
    
    /**
     * Valida que una nota esté en el rango correcto
     */
    public boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }
    
    /**
     * Obtiene la lista de todos los estudiantes
     */
    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(estudiantes);
    }
    
    /**
     * Obtiene el número total de estudiantes
     */
    public int contarEstudiantes() {
        return estudiantes.size();
    }
    
    /**
     * Calcula el promedio general de todos los estudiantes
     */
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) {
            return 0.0;
        }
        
        double suma = 0.0;
        for (Estudiante est : estudiantes) {
            suma += est.calcularPromedio();
        }
        return suma / estudiantes.size();
    }
    
    /**
     * Obtiene estudiantes aprobados (promedio >= 7.0)
     */
    public List<Estudiante> obtenerAprobados() {
        List<Estudiante> aprobados = new ArrayList<>();
        for (Estudiante est : estudiantes) {
            if (est.calcularPromedio() >= 7.0) {
                aprobados.add(est);
            }
        }
        return aprobados;
    }
    
    /**
     * Obtiene estudiantes reprobados (promedio < 7.0)
     */
    public List<Estudiante> obtenerReprobados() {
        List<Estudiante> reprobados = new ArrayList<>();
        for (Estudiante est : estudiantes) {
            if (est.calcularPromedio() < 7.0) {
                reprobados.add(est);
            }
        }
        return reprobados;
    }
    
    /**
     * Busca estudiantes por nombre (búsqueda parcial)
     */
    public List<Estudiante> buscarPorNombre(String nombre) {
        List<Estudiante> resultados = new ArrayList<>();
        if (nombre == null || nombre.isEmpty()) {
            return resultados;
        }
        
        String nombreBuscar = nombre.toLowerCase();
        for (Estudiante est : estudiantes) {
            if (est.getNombre().toLowerCase().contains(nombreBuscar) ||
                est.getApellido().toLowerCase().contains(nombreBuscar)) {
                resultados.add(est);
            }
        }
        return resultados;
    }
    
    /**
     * Limpia todos los estudiantes
     */
    public void limpiar() {
        estudiantes.clear();
    }
    
    /**
     * Valida el formato de email
     */
    public boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
    
    /**
     * Valida el formato de cédula ecuatoriana (10 dígitos)
     */
    public boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }
        
        try {
            Long.parseLong(cedula);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}