package repaso.animales;

public class Gato extends Animal{

    public Gato(String esperanzaDeVida, String tipoPelaje, String numeroDeOjos) {
        super(esperanzaDeVida, tipoPelaje, numeroDeOjos);
    }

    @Override
    public String emitirSonido() {
        return "Miau";
    }



}
