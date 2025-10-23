package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(int id, LocalDate fechaPrestamo, Libro libro, Usuario usuario)
            throws LibroNoDisponibleException, UsuarioNoRegistradoException {

        if (libro == null) {
            throw new LibroNoDisponibleException();
        }

        if (!libro.getEstado()) {
            throw new LibroNoDisponibleException();
        }

        if (usuario == null) {
            throw new UsuarioNoRegistradoException();
        }

        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.libro.setEstado(false);
    }

    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.libro.setEstado(true);
    }

    public int getId() { return id; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }

    public void mostrarDatos() {
        System.out.println("ID Préstamo: " + id);
        System.out.println("Fecha Préstamo: " + fechaPrestamo);
        System.out.println("Fecha Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "Pendiente"));
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
        System.out.println("Estado libro: " + (libro.getEstado() ? "Disponible" : "Prestado"));
    }
}
