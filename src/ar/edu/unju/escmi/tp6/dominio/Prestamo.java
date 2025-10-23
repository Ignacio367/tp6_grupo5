package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(int id, LocalDate fechaPrestamo, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaDevolucion = null; 
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void registrarDevolucion(LocalDate fecha) {
        this.fechaDevolucion = fecha;
        if (this.libro != null) {
            this.libro.setEstado(true);
        }
    }


    public void mostrarDatos() {
        System.out.println("----- Datos del Préstamo -----");
        System.out.println("ID Préstamo: " + id);
        System.out.println("Fecha de préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "Sin registrar"));
        System.out.println("Fecha de devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto aún"));

        System.out.println("\n--- Datos del Libro ---");
        if (libro != null) {
            libro.mostrarDatos();
        } else {
            System.out.println("No hay libro asociado al préstamo.");
        }

        System.out.println("\n--- Datos del Usuario ---");
        if (usuario != null) {
            usuario.mostrarDatos();
        } else {
            System.out.println("No hay usuario asociado al préstamo.");
        }

        System.out.println("---------------------------\n");
    }
}