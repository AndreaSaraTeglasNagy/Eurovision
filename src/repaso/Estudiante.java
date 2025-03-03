package repaso;

public class Estudiante extends Persona implements Comparable<Estudiante>{

    private int NIA;

    public Estudiante(String nombre, String apellido, int NIA) {
        super(nombre, apellido);
        this.NIA = NIA;
    }

    public int getNIA(){
        return NIA;
    }

    @Override
    public String toString() {
        return "Estudiante: " + super.getNombre() + ", " + super.getApellido() + " con NIA: " + NIA;
    }

    @Override
    public int compareTo(Estudiante o) {
        if (getApellido().compareTo(o.getApellido()) == 0) {
            return this.getNombre().compareTo(o.getNombre());
        }
        return getApellido().compareTo(o.getApellido());
    }


}
