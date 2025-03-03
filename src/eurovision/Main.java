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
                elegido.votosRecibidos.put(pais.nombre,puntosDados);
            }

        }

        Collections.sort(eurovision, new Comparator<Eurovision>() {
            @Override
            public int compare(Eurovision e1, Eurovision e2) {
                return e1.nombre.compareTo(e2.nombre);
            }
        });

        System.out.println("Listado de los paises por orden alfabético:");
        for (Eurovision pais : eurovision) {
            System.out.println(pais.nombre);
        }

        System.out.println("\nPaíses ordenados alfabéticamente con votaciones:");
        for (Eurovision pais : eurovision) {
            System.out.println(pais + "- " + pais.grupo + " - " + pais.cancion);
            List<Map.Entry<String,Integer>> votosOrdenados = new ArrayList<>(pais.votosRecibidos.entrySet());
            votosOrdenados.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            for (Map.Entry<String, Integer> voto : votosOrdenados) {
                System.out.println(" " + voto.getKey() + " le dio " + voto.getValue() + " puntos");
            }
            System.out.println();
        }

        Collections.sort(eurovision,new Comparator<Eurovision>() {
            @Override
            public int compare(Eurovision o1, Eurovision o2) {
                return o2.puntuacionTotal - o1.puntuacionTotal;
            }
        });

        System.out.println("\nRanking por puntuaciones recibidas:");
        for (Eurovision pais : eurovision) {
            System.out.println(pais.nombre + ": " + pais.puntuacionTotal + " puntos" );
        }

        Eurovision ganador = eurovision.get(0);
        System.out.println("\nGanador: " + ganador.nombre + " con " + ganador.puntuacionTotal + " puntos");
        System.out.println("Votos recibidos:");
        for (Map.Entry<String, Integer> entry : ganador.votosRecibidos.entrySet()) {
            System.out.println(entry.getKey() + " le dio " + entry.getValue() + " puntos");
        }

        List<String> cancionesOrdenadas = new ArrayList<>();
        for (Eurovision pais : eurovision) {
            cancionesOrdenadas.add(pais.cancion);
        }

        Collections.sort(cancionesOrdenadas);
        System.out.println("\nListado de canciones ordenadas:");
        for (String cancion : cancionesOrdenadas) {
            System.out.println(cancion);
        }






    }

}
