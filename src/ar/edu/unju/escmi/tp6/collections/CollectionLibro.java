package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    static {
        libros.add(new Libro(1,"La Odisea","Homero","978-0-14-044913-6",true));
        libros.add(new Libro(2,"Mi vida","Figueroa","922-0-14-044913-6",true));
        libros.add(new Libro(3,"Como hacer todo mal","Espino","908-0-10-011913-6",true));
    }

    public static void registarLibro(Libro libro) {
        libros.add(libro);
    }

    public static Libro buscarLibroPorId(int id) {
        Libro aux = null;
        try {
            for (Libro l : libros) {
            if (id == l.getId()) {
                aux = l;
            }
        }
        if(aux == null){
            throw new LibroNoEncontradoException();
        }
        if(aux.getEstado() == false){
            throw new LibroNoDisponibleException();
        }
        } catch (LibroNoEncontradoException | LibroNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return aux;
    }

    public static List<Libro> mostrarLibros() {
        return libros;
    }
}