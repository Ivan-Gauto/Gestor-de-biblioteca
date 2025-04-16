import java.util.*;
public abstract class Socio {
    // variables de instancia
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor para objetos de la clase Socio, crea el array
     * @param int p_dniSocio
     * @param String p_nombre 
     * @param int p_diasPrestamo 
     */

    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        // inicializacion de variables de instancia
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    /**
     * Constructor sobrecargado para objetos de la clase Socio
     * @param int p_dniSocio
     * @param String p_nombre 
     * @param int p_diasPrestamo 
     * @param ArrayList prestamos
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos) {
        // inicializacion de variables de instancia
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I dniSocio
     * @param p_dniSocio de tipo int
     */
    private void setDniSocio(int p_dniSocio){
        this.dniSocio = p_dniSocio;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I dniSocio
     * @return dni del socio de tipo int
     */
    public int getDniSocio(){
        return this.dniSocio;
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I nombre
     * @param p_nombre de tipo String
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I nombre
     * @return nombre del socio de tipo String
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I diasPrestamo
     * @param p_diasPrestamo de tipo int
     */
    public void setDiasPrestamo(int p_diasPrestamo){
        this.diasPrestamo = p_diasPrestamo;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I diasPrestamos
     * @return dias de prestamo del socio de tipo int
     */
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I prestamos
     * @param p_prestamos de tipo Arraylist
     */
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I prestamos
     * @return prestamos del socio de tipo ArrayList
     */
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    
    /**
     * Permite añadir un nuevo prestamo al socio
     * @param p_prestamo de tipo Prestamo
     * @return Devuelve true si el préstamo se agregó correctamente, y false si el préstamo no se pudo agregar
     */
    public boolean addPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * Permite remover un prestamo al socio
     * @param p_prestamo de tipo Prestamo
     * @return Devuelve true si el préstamo se quito correctamente, y false si el préstamo no se pudo quitar
     */
    public boolean removePrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Devuelve la cantidad de libros en poder del Socio
     * @return Cantidad de libros que tiene, de tipo int
     */
    public int cantLibrosPrestados(){
        int cant = 0;
        
        for(Prestamo pres : this.getPrestamos()){
            if(pres.getLibro().prestado()){
                cant++;
            }
        }
        
        return cant;
    }
    
    /**
     * Devuelve un String con los datos del Socio
     * @return un String de datos del Socio
     */
    public String toString(){
        return "DNI: " + this.getDniSocio() + " || " + this.getNombre() + " ("+ this.soyDeLaClase() +")" + " || " + " Libros Prestados: " + this.cantLibrosPrestados();
    }
    
    public abstract String soyDeLaClase();
    
    public boolean puedePedir() {
        Calendar fechaHoy = Calendar.getInstance();
        boolean aux = true;
        
        for(Prestamo prestamo : this.getPrestamos()){
           if(this.cantLibrosPrestados() > 0 && prestamo.vencido(fechaHoy)){
               aux = false;
           }
        }
        
        return aux;
    }
    
    
}   