import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Estadisticas {

    public static float promedio(List<Float> notas) {
        float suma = 0;
        for (float nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public static float mediana(List<Float> notas) {
        Collections.sort(notas);
        int size = notas.size();
        if (size % 2 != 0) {
            return notas.get(size / 2);
        }
        return (notas.get((size - 1) / 2) + notas.get(size / 2)) / 2.0f;
    }

    public static float moda(List<Float> notas) {
        HashMap<Float, Integer> frecuencia = new HashMap<>();
        for (float nota : notas) {
            frecuencia.put(nota, frecuencia.getOrDefault(nota, 0) + 1);
        }
        Map.Entry<Float, Integer> maxEntry = null;
        for (Map.Entry<Float, Integer> entry : frecuencia.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static float desviacionEstandar(List<Float> notas) {
        float promedio = promedio(notas);
        float sum = 0;
        for (float nota : notas) {
            sum += Math.pow(nota - promedio, 2);
        }
        return (float) Math.sqrt(sum / notas.size());
    }

    public static float notaMasBaja(List<Float> notas) {
        return Collections.min(notas);
    }

    public static float notaMasAlta(List<Float> notas) {
        return Collections.max(notas);
    }
}
