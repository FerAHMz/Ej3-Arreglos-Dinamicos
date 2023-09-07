public class Examen {

    // Atributos privados
    private String nombreMateria;  // Ejemplo: Matemática, Lenguaje, Química, etc.
    private float nota;

    // Constructor
    public Examen(String nombreMateria, float nota) {
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    // Métodos getters y setters
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
