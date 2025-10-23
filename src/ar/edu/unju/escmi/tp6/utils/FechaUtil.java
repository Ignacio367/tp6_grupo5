package ar.edu.unju.escmi.tp6.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {

    public static LocalDate convertirStringLocalDate(String fechaStr) throws ParseException { 


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {

            return LocalDate.parse(fechaStr, formatter);

        } catch (DateTimeParseException e) {

            throw new ParseException("Fecha inválida: " + fechaStr + ". Debe ser dd/MM/yyyy", 0); 
        }

    }
}