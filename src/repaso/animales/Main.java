package repaso.animales;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Animal> animales = new HashSet<>();
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
