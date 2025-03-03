package repaso;

public abstract class Persona {

    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    protected String getNombre() {
        return nombre;
    }

    protected String getApellido() {
        return apellido;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }



}
