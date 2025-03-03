package repaso.animales.ejemplolist;

import repaso.animales.Animal;
import repaso.animales.Gato;
import repaso.animales.Paloma;

import java.util.*;

public class Main {

    /**
     * La lista es una estructura de datos ORDENADA por orden de insercion que a diferencia del Set, ADMITE DUPLICADOS, es decir, en una lista puedes meter 2 veces el mismo objeto
     * Si quieres o te interesa tener más metodos a disposicion para eliminar el primer elemento/ultimo, insertar al principio o al final etc... usa LinkedList en lugar de ArrayList.
     * @param args
     */
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        Gato gato1 = new Gato("20","Pelo","2");
        Gato gato2 = new Gato("20","Pelo","2");
        Paloma paloma = new Paloma("1","Plumas","2");
        animales.add(gato1);
        animales.add(gato2);
        animales.add(paloma);

        for (Animal animal: animales){
            System.out.println(animal.emitirSonido());
        }

    }

}
