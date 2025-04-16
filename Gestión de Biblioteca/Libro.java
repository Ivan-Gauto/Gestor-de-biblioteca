import java.util.*;
/**
 * Clase libro que moldea un libro.
 * 
 * @author Romero Maurin Ivan
 * @version 1.21.1 Optifine
 */
public class Libro
{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;
    
    /**
     * Constructor que inicializa un libro.
     * 
     * @param p_titulo    El título del libro.
     * @param p_edicion   La edición del libro.
     * @param p_editorial La editorial del libro.
     * @param p_anio      El año de publicación del libro.
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    /**
     * Constructor que inicializa un libro.
     * 
     * @param p_titulo    El título del libro.
     * @param p_edicion   La edición del libro.
     * @param p_editorial La editorial del libro.
     * @param p_anio      El año de publicación del libro.
     * @param p_prestamos La lista de préstamos del libro.
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList<Prestamo> p_prestamos) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }
    
    /**
     * Asigna el titulo del libro.
     * 
     * @param p_titulo El título del libro.
     */
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }
    
    /**
     * Devuelve el titulo del libro.
     * 
     * @return El titulo del libro.
     */
    public String getTitulo(){
        return this.titulo;
    }
    
    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;
    }
    
    public int getEdicion(){
        return this.edicion;
    }
    
    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }
    
    public String getEditorial(){
        return this.editorial;
    }
    
    private void setAnio(int p_anio){
        this.anio = p_anio;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }

    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    
    /**
     * Agrega un nuevo prestamo a la lista de préstamos del libro.
     * 
     * @param p_prestamo El préstamo a agregar.
     * @return true si el préstamo se agrego, false en caso contrario.
     */
    public boolean agregarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * Elimina un prestamo de la lista de prestamos del libro.
     * 
     * @param p_prestamo El préstamo a eliminar.
     * @return true si el préstamo se eliminó, false en caso contrario.
     */
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Verifica si el libro está actualmente prestado.
     * 
     * @return true si esta prestado, false en caso contrario.
     */
    public boolean prestado(){
        if(this.ultimoPrestamo() != null){
            return this.ultimoPrestamo().getFechaDevolucion() == null;
        }else{
            return false;
        }
    }
    
    /**
     * Devuelve el ultimo prestamo del libro.
     * 
     * @return El último prestamo del libro, o null si no hay prestamos.
     */
    public Prestamo ultimoPrestamo(){
        Prestamo ultPrestamo = null;
        
        for(Prestamo prestamo : this.getPrestamos()){
            ultPrestamo = prestamo;
        }
        
        return ultPrestamo;
    }
    
    /**
     * Devuelve una cadena con el titulo del libro.
     * 
     * @return Una cadena que representa el título del libro.
     */
    public String toString(){
        return "Titulo: " + this.getTitulo();
    }
}
