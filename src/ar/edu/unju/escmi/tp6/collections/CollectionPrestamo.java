package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

//import ar.edu.unju.escmi.tp6.dominio.Prestamo;

public class CollectionPrestamo {
  public static List<Prestamo> prestamos = new ArrayList<>();
  
  //Agregar un prestamo a la coleccion
  public static void registrarPrestamo(Prestamo prestamo) {
      prestamos.add(prestamo);
  }

  //Listar todos los prestamos
  public static List<Prestamo> mostrarPrestamos() {
      if (prestamos.isEmpty()) {
          System.out.println("No hay prestamos registrados.");
          return new ArrayList<>();
      } else {
          return prestamos;
      }
  }

  //Buscar prestamo por ID
  //public static Prestamo buscarPrestamoPorId(int Id) {
    //  for (Prestamo p : prestamos) {
      //    if (p.getId() == Id) {
        //      return p;
         // }
     // }
     // return null;
 // }

  //registrar devolucion de un prestamo
  public static boolean eliminarPrestamo(int Id) {
      for (Prestamo p : prestamos) {
          if (p.getId() == Id) {
              p.setFechaDevolucion(new Date());
              return true;
          }
      }
      return false;
  }
}