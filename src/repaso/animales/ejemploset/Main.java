package repaso.animales.ejemploset;

import repaso.animales.Animal;
import repaso.animales.Gato;
import repaso.animales.Paloma;
import repaso.animales.Perro;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    /**
     * El set es una estructura de datos parecido a una lista, con la diferencia de que si intentas meter un Objeto que ya existe de nuevo en el set, es decir,
     * si tu has definido un metodo equalks para los objertos que hay en una lista y intentas meter 2 veces el mismo objeto, el set NO lo va a meter y lo omitira.
     * Además, el set NO mantiene el orden de los datos en los que tu introduces las cosas
     * Si quieres o te interesa el orden de inserción, simplemente usa LinkedHashSet en lugar de HashSet
     * @param args
     */
    public static void main(String[] args) {
        Set<Animal> animales = new TreeSet<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getEsperanzaDeVida().compareTo(o2.getEsperanzaDeVida());
            }
        });
        Gato gato = new Gato("20","Pelo","2");
        Perro perro = new Perro("18","Pelo","2");
        Paloma paloma = new Paloma("1","Plumas","2");
        animales.add(gato);
        animales.add(perro);
        animales.add(paloma);

        for (Animal animal: animales){
            System.out.println(animal.emitirSonido());
        }

    }

}
