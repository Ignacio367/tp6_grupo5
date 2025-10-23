package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import java.time.LocalDate;


public class CollectionPrestamo {
  public static List<Prestamo> prestamos = new ArrayList<>();
  

  public static void registrarPrestamo(Prestamo prestamo) {
      prestamos.add(prestamo);
  }


  public static List<Prestamo> mostrarPrestamos() {
      if (prestamos.isEmpty()) {
          System.out.println("No hay prestamos registrados.");
          return new ArrayList<>();
      } else {
          return prestamos;
      }
  }

  public static boolean eliminarPrestamo(int Id) {
      for (Prestamo p : prestamos) {
          if (p.getId() == Id) {
              p.setFechaDevolucion(LocalDate.now());
              return true;
          }
      }
      return false;
  }
}