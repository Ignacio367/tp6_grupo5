package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

//import ar.edu.unju.escmi.tp6.dominio.Usuario;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    // Precarga de usuarios
    static {
        usuarios.add(new Usuario("juanperez", "Juan", "Perez", "perezjuan@gmail.com"));
        usuarios.add(new Usuario("mariasoto", "Maria", "Soto", "sotomaria@gmail.com"));
        usuarios.add(new Usuario("carlossanchez", "Carlos", "Sanchez", "sanchezcarlos@gmail.com"));
}

    public static void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    //public static Usuario buscarUsuarioPorNombre(String nombreUsuario) {
    //    for (Usuario u : usuarios) {
    //        if (u.getNombreUsuario().equals(nombreUsuario)) {
    //            return u;
    //        }
    //    }
    //    return null;
    //}

    public static List<Usuario> mostrarUsuarios() {
        return usuarios;
    }


    //public static void eliminarUsuario(String nombreUsuario) {
    //    usuarios.removeIf(u -> u.getNombreUsuario().equals(nombreUsuario));
    //}

}