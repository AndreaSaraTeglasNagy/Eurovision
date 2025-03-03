package repaso.animales;

public class Paloma extends Animal{

    public Paloma(String esperanzaDeVida, String tipoPelaje, String numeroDeOjos) {
        super(esperanzaDeVida, tipoPelaje, numeroDeOjos);
    }

    @Override
    public String emitirSonido() {
        return "Huu hu hu";
    }

}
