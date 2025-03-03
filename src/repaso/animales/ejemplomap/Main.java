package repaso.animales.ejemplomap;

import repaso.animales.Animal;
import repaso.animales.Duenyo;
import repaso.animales.Gato;
import repaso.animales.Paloma;

import java.util.*;

public class Main {

    /**
     * El map es una estructura de datos parecido que funciona parecido a como están representadas las filas en una base de datos, donde tienes una clave primaria que es la Key del mapa y el valor que es la Value del mapa.
     * si tu has definido un metodo equals para los objertos que hay en la CLAVE del mapa y intentas meter 2 veces el mismo objeto, el mapa se va a quedar con el ultimo que metas ya que reemplazara el anterior.
     * Además, el HashMap NO mantiene el orden de los datos en los que tu introduces las cosas
     * Si quieres o te interesa el orden de inserción, simplemente usa LinkedHashMap en lugar de HashMap
     * @param args
     */
    public static void main(String[] args) {
        Duenyo alex = new Duenyo("Alex",27);
        Duenyo astrid = new Duenyo("Astrid",36);
        Duenyo tundi = new Duenyo("Tundi",48);
        Duenyo sara = new Duenyo("Sara",18);

        Gato pochi = new Gato("20","Pelo","2");
        Gato umbra = new Gato("20","Pelo","2");
        Paloma bea = new Paloma("20","Pluma","2");

        // Puedes definir
        Map<Duenyo,List<Animal>> duenyosYAnimalesMap = new TreeMap<>(new Comparator<Duenyo>() {
            @Override
            public int compare(Duenyo o1, Duenyo o2) {
                return o1.getEdad().compareTo(o2.getEdad());
            }
        });

        List<Animal> animalesDeAlex = new ArrayList<>();
        animalesDeAlex.add(umbra);

        List<Animal> animalesDeTundi = new ArrayList<>();
        animalesDeTundi.add(bea);

        List<Animal> animalesDeAstrid = new ArrayList<>();
        animalesDeAstrid.add(pochi);

        duenyosYAnimalesMap.put(alex,animalesDeAlex);
        duenyosYAnimalesMap.put(sara,animalesDeTundi);
        duenyosYAnimalesMap.put(tundi,animalesDeTundi);
        duenyosYAnimalesMap.put(astrid,animalesDeAstrid);

        for (Map.Entry<Duenyo, List<Animal>> entry: duenyosYAnimalesMap.entrySet()){
            Duenyo dueño = entry.getKey();
            List<Animal> animals = entry.getValue();
            System.out.println(dueño.getNombre() + " numero de animales: " + animals.size());
        }

    }

}
