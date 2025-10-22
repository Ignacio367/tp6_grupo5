package ar.edu.unju.escmi.tp6.principal;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;
import ar.edu.unju.escmi.tp6.exceptions.*;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1 - Registrar libro");
            System.out.println("2 - Registrar usuario");
            System.out.println("3 - Préstamo de libro");
            System.out.println("4 - Devolución de libro");
            System.out.println("5 - Listar libros");
            System.out.println("6 - Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        registrarLibro(sc);
                        break;
                    case 2:
                        registrarUsuario(sc);
                        break;
                    case 3:
                        registrarPrestamo(sc);
                        break;
                    case 4:
                        registrarDevolucion(sc);
                        break;
                    case 5:
                        listarLibros();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 6);

        sc.close();
    }

    private static void registrarLibro(Scanner sc) {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("ISBN: ");
            String isbn = sc.nextLine();

            Libro libro = new Libro(id, titulo, autor, isbn, true);
            CollectionLibro.registarLibro(libro);
            System.out.println("Libro registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el libro: " + e.getMessage());
        }
    }

    private static void registrarUsuario(Scanner sc) {
        try {
            System.out.println("¿Qué tipo de usuario desea registrar?");
            System.out.println("1 - Alumno");
            System.out.println("2 - Bibliotecario");
            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            if (tipo == 1) {
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                System.out.print("Número de libreta: ");
                int libreta = Integer.parseInt(sc.nextLine());
                Alumno a = new Alumno(id, nombre, apellido, email, curso, libreta);
                CollectionUsuario.registrarUsuario(a);
            } else if (tipo == 2) {
                System.out.print("Legajo: ");
                String legajo = sc.nextLine();
                Bibliotecario b = new Bibliotecario(id, nombre, apellido, email, legajo);
                CollectionUsuario.registrarUsuario(b);
            } else {
                System.out.println("Tipo de usuario inválido.");
                return;
            }

            System.out.println("Usuario registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    private static void registrarPrestamo(Scanner sc) {
        try {
            System.out.print("ID del préstamo: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("ID del libro: ");
            int idLibro = Integer.parseInt(sc.nextLine());
            Libro libro = CollectionLibro.buscarLibroPorId(idLibro);
            if (libro == null) return;

            System.out.print("ID del usuario: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            Usuario usuario = CollectionUsuario.usuarios.stream()
                    .filter(u -> u.getId() == idUsuario)
                    .findFirst()
                    .orElseThrow(() -> new UsuarioNoRegistradoException());

            System.out.print("Fecha de préstamo (dd/MM/yyyy): ");
            String fechaStr = sc.nextLine();
            LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaStr);

            Prestamo p = new Prestamo(id, fechaPrestamo, libro, usuario);
            CollectionPrestamo.registrarPrestamo(p);
            System.out.println("Préstamo registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }
    }

    private static void registrarDevolucion(Scanner sc) {
        try {
            System.out.print("Ingrese ID del préstamo: ");
            int id = Integer.parseInt(sc.nextLine());

            Prestamo prestamo = CollectionPrestamo.prestamos.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (prestamo == null) {
                System.out.println("No se encontró el préstamo con ese ID.");
                return;
            }

            System.out.print("Fecha de devolución (dd/MM/yyyy): ");
            String fechaStr = sc.nextLine();
            LocalDate fechaDev = FechaUtil.convertirStringLocalDate(fechaStr);

            prestamo.registrarDevolucion(fechaDev);
            System.out.println("Devolución registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar devolución: " + e.getMessage());
        }
    }

    private static void listarLibros() {
        for (Libro l : CollectionLibro.mostrarLibros()) {
            l.mostrarDatos();
            System.out.println("-------------------------");
        }
    }
}