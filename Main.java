import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Sede> sedes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Registrar nueva sede");
            System.out.println("3. Introducir notas de exámenes");
            System.out.println("4. Ver estadísticas de los exámenes");
            System.out.println("5. Ver información de estudiantes y exámenes");
            System.out.println("6. Asignar estudiante a sede");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    registrarSede();
                    break;
                case 3:
                    introducirNotas();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    mostrarInfoEstudiantes();
                    break;
                case 6:
                    asignarEstudianteASede();
                    break;
                case 0:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Código único: ");
        String codigoUnico = scanner.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();

        // Usar SimpleDateFormat para convertir la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;  
        }

        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellido, codigoUnico, fechaNacimiento, correoElectronico);
        estudiantes.add(estudiante);
        System.out.println("Estudiante registrado con éxito.");
    }

    private static void registrarSede() {
        System.out.print("Nombre de la sede: ");
        String nombre = scanner.nextLine();

        Sede sede = new Sede(nombre);
        sedes.add(sede);
        System.out.println("Sede registrada con éxito.");
    }

    private static void introducirNotas() {
        System.out.print("Ingrese el código único del estudiante: ");
        String codigo = scanner.nextLine();

        Estudiante estudiante = buscarEstudiantePorCodigo(codigo);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Nombre de la materia (Matemática, Lenguaje, etc.): ");
        String materia = scanner.nextLine();

        System.out.print("Nota: ");
        float nota = scanner.nextFloat();
        scanner.nextLine();  

        Examen examen = new Examen(materia, nota);
        estudiante.registrarExamen(examen);
        System.out.println("Nota registrada con éxito.");
    }

    private static void mostrarEstadisticas() {
        
    }

    private static void mostrarInfoEstudiantes() {
        System.out.println("Número de estudiantes registrados: " + estudiantes.size());
        
    }

    private static void asignarEstudianteASede() {
        System.out.print("Ingrese el código único del estudiante: ");
        String codigo = scanner.nextLine();

        Estudiante estudiante = buscarEstudiantePorCodigo(codigo);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Sedes disponibles:");
        for (int i = 0; i < sedes.size(); i++) {
            System.out.println((i + 1) + ". " + sedes.get(i).getNombre());
        }

        System.out.print("Elija el número de la sede: ");
        int numSede = scanner.nextInt();
        scanner.nextLine();  

        if (numSede > 0 && numSede <= sedes.size()) {
            Sede sede = sedes.get(numSede - 1);
            sede.agregarEstudiante(estudiante);
            System.out.println("Estudiante asignado a la sede con éxito.");
        } else {
            System.out.println("Número de sede no válido.");
        }
    }

    private static Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigoUnico().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }
    
    
}
