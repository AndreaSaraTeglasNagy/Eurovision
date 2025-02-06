package eurovision;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Eurovision> eurovision = Arrays.asList(
                new Eurovision("Suecia", "Marcus & Martinus", "Unforgettable"),
                new Eurovision("Ucrania", "Alyona Alyona & Jerry Heil", "Teresa & Maria"),
                new Eurovision("Alemania", "Isaak", "Always on the Run"),
                new Eurovision("Luxemburgo", "Tali", "Fighter"),
                new Eurovision("Países Bajos", "Joost Klein", "Europapa"),
                new Eurovision("Israel", "Edén Golán", "Hurricane"),
                new Eurovision("Lituania", "Silvester Belt", "Luktelk"),
                new Eurovision("España", "Nebulossa", "Zorra"),
                new Eurovision("Estonia", "5miinust & Puuluup", "(Nendest) Narkootikumidest ei tea me (küll) midagi"),
                new Eurovision("Irlanda", "Bambie Thug", "Doomsday Blue"),
                new Eurovision("Letonia", "Dons", "Hollow"),
                new Eurovision("Grecia", "Marina Satti", "Zari"),
                new Eurovision("Reino Unido", "Olly Alexander", "Dizzy"),
                new Eurovision("Noruega", "Gåte", "Ulveham"),
                new Eurovision("Italia", "Angelina Mango", "La noia"),
                new Eurovision("Serbia", "Teya Dora", "Ramonda"),
                new Eurovision("Finlandia", "Windows95man", "No Rules!"),
                new Eurovision("Portugal", "Iolanda", "Grito"),
                new Eurovision("Armenia", "Ladaniva", "Jako"),
                new Eurovision("Chipre", "Sília Kapsís", "Liar"),
                new Eurovision("Suiza", "Nemo", "The Code"),
                new Eurovision("Eslovenia", "Raiven", "Veronika"),
                new Eurovision("Croacia", "Baby Lasagna", "Rim tim tagi dim"),
                new Eurovision("Georgia", "Nutsa Buzaladze", "Firefighter"),
                new Eurovision("Francia", "Slimane", "Mon Amour"),
                new Eurovision("Austria", "Kaleen", "We Will Rave")
        );

        List<Integer> puntos = Arrays.asList(12, 10, 8, 7, 6, 5, 4, 3, 2, 1);
        Random random = new Random();

        for (Eurovision pais : eurovision) {
            List<Eurovision> posiblesVotos = new ArrayList<>(eurovision);
            posiblesVotos.remove(pais);
            Collections.shuffle(posiblesVotos);

            for (int i = 0; i < 10; i++) {
                Eurovision elegido = posiblesVotos.get(i);
                int puntosDados = puntos.get(i);
                elegido.puntuacionTotal += puntosDados;
                elegido.votosRecibidos.put(pais.nombre, puntosDados);
            }
        }


        eurovision.sort(Comparator.comparing(eurovision1 -> eurovision1.nombre));
        System.out.println("Listado de los paises por orden afabético: ");
        for (Eurovision p : eurovision) System.out.println(p.nombre );

        eurovision.sort(Comparator.comparing(p -> p.nombre));
        System.out.println("\nPaíses ordenados alfabéticamente con votaciones:");
        for (Eurovision p : eurovision) {
            System.out.println(p.nombre + " - " + p.grupo + " - " + p.cancion);
            p.votosRecibidos.entrySet().stream()
                    .sorted((paisA, paisB) -> paisB.getValue().compareTo(paisA.getValue()))
                    .forEach(pais -> System.out.println("  " + pais.getKey() + " le dio " + pais.getValue() + " puntos"));

        }

        eurovision.sort((p1, p2) -> Integer.compare(p2.puntuacionTotal, p1.puntuacionTotal));
        System.out.println("\nRanking por puntuaciones recibidas:");
        for (Eurovision p : eurovision) System.out.println(p.nombre + ": " + p.puntuacionTotal + " puntos");

        Eurovision ganador = eurovision.get(0);
        System.out.println("\nGanador: " + ganador.nombre + " con " + ganador.puntuacionTotal + " puntos");
        System.out.println("Votos recibidos:");
        for (Map.Entry<String, Integer> entry : ganador.votosRecibidos.entrySet()) {
            System.out.println(entry.getKey() + " le dio " + entry.getValue() + " puntos");
        }

        List<String> cancionesOrdenadas = new ArrayList<>();
        for (Eurovision p : eurovision) cancionesOrdenadas.add(p.cancion);
        Collections.sort(cancionesOrdenadas);
        System.out.println("\nListado de canciones ordenadas:");
        for (String c : cancionesOrdenadas) System.out.println(c);

        int max12 = 0;
        Eurovision max12Pais = null;
        for (Eurovision p : eurovision) {
            int count12 = (int) p.votosRecibidos.values().stream().filter(v -> v == 12).count();
            if (count12 > max12) {
                max12 = count12;
                max12Pais = p;
            }
        }

        if (max12Pais != null) {
            System.out.println("\nPaís con más puntuaciones de 12 puntos: " + max12Pais.nombre);
            System.out.println("Recibió 12 puntos de:");
            for (Map.Entry<String, Integer> entry : max12Pais.votosRecibidos.entrySet()) {
                if (entry.getValue() == 12) System.out.println(entry.getKey());
            }
        }






    }

}
