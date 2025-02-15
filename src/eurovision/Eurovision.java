package eurovision;

import java.util.HashMap;
import java.util.Map;

public class Eurovision {
        String nombre;
        String grupo;
        String cancion;
        int puntuacionTotal = 0;
        Map<String, Integer> votosRecibidos = new HashMap<>();

        Eurovision(String nombre, String grupo, String cancion) {
            this.nombre = nombre;
            this.grupo = grupo;
            this.cancion = cancion;
        }

    @Override
    public String toString() {
        return nombre ;
    }

}
