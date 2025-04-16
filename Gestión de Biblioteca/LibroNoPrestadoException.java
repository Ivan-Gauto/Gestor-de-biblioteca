/**
 * Clase que representa una excepcion a un libro no prestado 
 */
public class LibroNoPrestadoException extends Exception {
    public LibroNoPrestadoException(String mensaje) {
       super(mensaje);
    }
 }
