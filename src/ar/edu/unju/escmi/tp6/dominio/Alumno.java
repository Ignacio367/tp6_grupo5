package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {

    private String curso;
    private int numeroLibreta;

    public Alumno(int id, String nombre, String apellido, String email, String curso, int numeroLibreta) {
        super(id, nombre, apellido, email);
        this.curso = curso;
        this.numeroLibreta = numeroLibreta;

    } 

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNumeroLibreta() {
        return numeroLibreta;
    }

    public void setNumeroLibreta(int numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }


    @Override
    public void mostrarDatos() {
        System.out.println("----- Datos del Alumno -----");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Email: " + getEmail());
        System.out.println("Curso: " + curso);
        System.out.println("Número de Libreta: " + numeroLibreta);
    }


}
