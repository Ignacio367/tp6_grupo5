package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

//import ar.edu.unju.escmi.tp6.dominio.Libro;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    // Precarga de libros
    static {
        libros.add(new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", 1605));
        libros.add(new Libro("978-0-14-044913-6", "La Odisea", "Homero", -800));
        libros.add(new Libro("978-0-7432-7356-5", "Cien Años de Soledad", "Gabriel García Márquez", 1967));
        libros.add(new Libro("978-0-452-28423-4", "1984", "George Orwell", 1949));
    }

    public static void registarLibro(Libro libro) {
        libros.add(libro);
    }

   // public static Libro buscarLibroPorId(int Id) {
   //     for (Libro l : libros) {
   //         if (l.getId().equals(Id)) {
   //             return l;
   //         }
   //     }
   //     return null;
   // }

    public static List<Libro> mostrarLibros() {
        return libros;
    }

   // public static void eliminarLibro(int Id) {
   //     libros.removeIf(l -> l.getId().equals(Id));
   // }
}