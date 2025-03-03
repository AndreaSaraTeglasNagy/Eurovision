package repaso.animales;

public class Perro extends Animal{

    public Perro(String esperanzaDeVida, String tipoPelaje, String numeroDeOjos) {
        super(esperanzaDeVida, tipoPelaje, numeroDeOjos);
    }

    @Override
    public String emitirSonido() {
        return "guau";
    }
}
