import java.util.*;
import java.text.*;
/**
 * Clase Prestamo
 * 
 * @author Gomez Hertler Lisandro
 * @version 
 */
public class Prestamo {
    // variables de instancia
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    /**
     * Constructor para objetos de la clase Prestamo
     * @param p_fechaRetiro de tipo Calendar
     * @param p_socio de tipo Socio
     * @param p_libro de tipo Libro
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        // inicializacion de variables de instancia
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.setFechaDevolucion(null);
    } 
    
    /**
     * Constructor sobrecargado para objetos de la clase Prestamo
     * @param p_socio de tipo Socio
     * @param p_libro de tipo Libro
     */
    public Prestamo(Socio p_socio, Libro p_libro) {
        // inicializacion de variables de instancia
        this.setFechaRetiro(new GregorianCalendar());
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.setFechaDevolucion(null);
    } 
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I fechaRetiro
     * @param p_fechaRetiro de tipo Calendar
     */
    private void setFechaRetiro(Calendar p_fechaRetiro){ 
        this.fechaRetiro = p_fechaRetiro;
    }  
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I fechaRetiro
     * @return fecha de retiro del libro de tipo Calendar
     */
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }   
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I socio
     * @param p_socio de tipo Socio
     */
    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I socio
     * @return socio que solicito el prestamo
     */
    public Socio getSocio(){
        return this.socio;
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I libro
     * @param p_libro de tipo Libro
     */
    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I libro
     * @return libro que se solicito el prestamo, de tipo Libro
     */
    public Libro getLibro(){
        return this.libro;
    }
    
    /**
     * Metodo Setter
     * Asigna el valor pasado por parametro a la V.I fechaDevolucion
     * @param p_fechaDevolucion, de tipo Calendar
     */
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }
    
    /**
     * Asigna la fecha de devolucion del prestamo a la V.I fechaDevolucion
     * @param p_fechaDevolucion, de tipo Calendar
     */
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion){
        this.setFechaDevolucion(p_fechaDevolucion);
    }
    
    /**
     * Metodo Getter
     * Devuelve el valor de la V.I fechaDevolucion 
     * @return fecha de devolucion del libro, de tipo Calendar
     */ 
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;  
    } 
    
    /**
     * Metodo que permite saber si el prestamo esta vencido
     * @param p_fecha de tipo Calendar
     * @return true si la fecha pasada como parámetro es mayor que la fecha de vencimiento
     */
    public boolean vencido(Calendar p_fecha){   
        Calendar vencimiento = (Calendar) this.getFechaRetiro().clone(); // Clona la fecha de retiro en la V.T vencimiento
        vencimiento.add(Calendar.DAY_OF_YEAR, this.getSocio().getDiasPrestamo()); //A la V.T vencimiento se le suma los dias de prestamo a los dias de la fecha, lo que da la fecha de vencimiento del prestamo
        
        // compareTo
        // -1 si la fecha de vencimiento es antes que la fecha pasada como argumento
        // 0 si las dos fechas son iguales.
        // 1 si la fecha de vencimiento es despues de la fecha pasada como argumento.      
        if(vencimiento.compareTo(p_fecha) < 0){
            return true;
        }else{
            return false;
        }           
    }
     
    /**
     * Metodo que retorna un String con los datos del prestamo
     * @return un String con los datos del prestamo
     */ 
    public String toString(){
        // obtener un Date desde el Calendar, el metodo format recibe un objeto de tipo Date
        Date dateRetiro = this.getFechaRetiro().getTime();
        Date dateDevolucion  = this.getFechaDevolucion().getTime();
        // Crea un objeto SympleDateFormat con el formato deseado
        SimpleDateFormat retiro = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat devolucion = new SimpleDateFormat("yyyy/MM/dd");
        if(this.getFechaDevolucion() ==  null){
            return "Retiro: " + retiro.format(dateRetiro) + " - Devolucion: - " + "\nLibro: "+ this.getLibro().getTitulo()+"\nSocio: "+this.getSocio().getNombre(); 
        }else{
            return "Retiro: " + retiro.format(dateRetiro) + " - Devolucion: "+ devolucion.format(dateDevolucion) +"\nLibro: "+ this.getLibro().getTitulo()+"\nSocio: "+this.getSocio().getNombre(); 
        }
    }
}












