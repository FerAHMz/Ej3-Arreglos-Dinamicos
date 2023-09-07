import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    // Atributos privados
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private Date fechaNacimiento;
    private String correoElectronico;
    private List<Examen> examenes;
    private Sede sede;

    // Constructor
    public Estudiante(String nombre, String apellido, String codigoUnico, Date fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.examenes = new ArrayList<>();
    }

    // Métodos getters y setters
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

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    // Método para registrar un examen
    public void registrarExamen(Examen examen) {
        this.examenes.add(examen);
    }
}


