package modelo;




public class Estudiante {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private double notaParcial1;
    private double notaParcial2;
    private double notaFinal;
    
    public Estudiante() {
    }
    
    public Estudiante(String cedula, String nombre, String apellido, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.notaParcial1 = 0.0;
        this.notaParcial2 = 0.0;
        this.notaFinal = 0.0;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getNotaParcial1() {
        return notaParcial1;
    }

    public void setNotaParcial1(double notaParcial1) {
        this.notaParcial1 = notaParcial1;
    }

    public double getNotaParcial2() {
        return notaParcial2;
    }

    public void setNotaParcial2(double notaParcial2) {
        this.notaParcial2 = notaParcial2;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + 
               "cedula=" + cedula + 
               ", nombre=" + getNombreCompleto() + 
               ", email=" + email + 
               ", promedio=" + calcularPromedio() + 
               '}';
    }
    
    /**
     * Calcula el promedio de las notas
     */
    public double calcularPromedio() {
        return (notaParcial1 + notaParcial2 + notaFinal) / 3.0;
    }
}
