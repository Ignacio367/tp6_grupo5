package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;
import ar.edu.unju.escmi.tp6.dominio.Alumno;
import ar.edu.unju.escmi.tp6.dominio.Bibliotecario;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();


    static {
        usuarios.add(new Bibliotecario(1, "Juan", "Perez", "perezjuan@gmail.com","apu"));
        usuarios.add(new Alumno(2, "Maria", "Soto", "sotomaria@gmail.com","2do A",12));
        usuarios.add(new Alumno(3, "Carlos", "Sanchez", "sanchezcarlos@gmail.com","3ro B",11));
}

    public static void registrarUsuario(Usuario usuario) {
        try {
         usuarios.add(usuario);
         if(usuario == null){   
         throw new UsuarioNoRegistradoException();
            }
        } catch (UsuarioNoRegistradoException e) {
             System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Usuario> mostrarUsuarios() {
        return usuarios;
    }

}