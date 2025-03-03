package repaso.animales;

import java.util.Comparator;
import java.util.Objects;

public abstract class Animal implements Comparator<Animal> {

   private String esperanzaDeVida;
   private String tipoPelaje;
   private String numeroDeOjos;

    public Animal(String esperanzaDeVida, String tipoPelaje, String numeroDeOjos) {
        this.esperanzaDeVida = esperanzaDeVida;
        this.tipoPelaje = tipoPelaje;
        this.numeroDeOjos = numeroDeOjos;
    }

    public abstract String emitirSonido();

    public String getEsperanzaDeVida() {
        return esperanzaDeVida;
    }

    public void setEsperanzaDeVida(String esperanzaDeVida) {
        this.esperanzaDeVida = esperanzaDeVida;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }

    public String getNumeroDeOjos() {
        return numeroDeOjos;
    }

    public void setNumeroDeOjos(String numeroDeOjos) {
        this.numeroDeOjos = numeroDeOjos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(esperanzaDeVida, animal.esperanzaDeVida) && Objects.equals(tipoPelaje, animal.tipoPelaje) && Objects.equals(numeroDeOjos, animal.numeroDeOjos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esperanzaDeVida, tipoPelaje, numeroDeOjos);
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getEsperanzaDeVida().compareTo(o2.getEsperanzaDeVida());
    }
}
