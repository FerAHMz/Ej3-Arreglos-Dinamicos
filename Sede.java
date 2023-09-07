import java.util.ArrayList;
import java.util.List;

public class Sede {

    // Atributos privados
    private String nombre;
    private List<Estudiante> estudiantes;

    // Constructor
    public Sede(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Método para agregar un estudiante a la sede
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
        estudiante.setSede(this);  // Asigna esta sede al estudiante
    }
}
