package ar.edu.unju.escmi.tp6.exceptions;

public class LibroNoEncontradoException extends Exception {
    
    public LibroNoEncontradoException(){
        super("El libro no fue encontrado.");
    }

    public LibroNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
