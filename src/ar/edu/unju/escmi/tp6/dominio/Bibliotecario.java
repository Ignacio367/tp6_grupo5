package ar.edu.unju.escmi.tp6.dominio;

public class Bibliotecario extends Usuario {

    private String legajo;

    public Bibliotecario(int id, String nombre, String apellido, String email, String legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("----- Datos del Bibliotecario -----");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Email: " + getEmail());
        System.out.println("Legajo: " + legajo);
    }

}
