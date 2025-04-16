import java.util.ArrayList;
import java.util.*;
/**
 * Clase que modela el concepto de un Docente, un tipo de Socio.
 * 
 * @author Garavaglia Miguel
 * @version 4.11.24
 */
public class Docente extends Socio {
    private String area;

    /**
     * Constructor sobrecargado para los objetos de la clase Docente.
     * 
     * @param p_dniSocio DNI del docente
     * @param p_nombre Nombre del docente
     * @param p_diasPrestamo Días iniciales de préstamo
     * @param p_area Área de especialización del docente
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area) {
        super(p_dniSocio, p_nombre,5 );
        this.setArea(p_area);
    }

       /**
     * Constructor sobrecargado para los objetos de la clase Docente.
     * 
     * @param p_dniSocio DNI del docente
     * @param p_nombre Nombre del docente
     * @param p_area Área de especialización del docente
     * @param p_prestamos Coleccion de prestamos del docente
     */
    public Docente(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos, String p_area) {
        super(p_dniSocio, p_nombre, 5, p_prestamos);
        this.setArea(p_area);
    }
    

    //SETTER
    /**
     * Metodo setter que modifica el estado del atributo area.
     * 
     * @param p_area área del docente
     */
    public void setArea(String p_area) {
        this.area = p_area;
    }
    
    //GETTER
    /**
     * Devuelve el área del docente.
     * 
     * @return área de especialización del docente
     */
    public String getArea() {
        return this.area;
    }

    /**
     * Verifica si el docente es responsable. Un docente es responsable si no tiene y nunca tuvo préstamos vencidos.
     * 
     * @return true si el docente es responsable; false en caso contrario
     */
    public boolean esResponsable() {
        boolean aux = true;
        
        if (!this.puedePedir()) {
            aux = false;
        }
    
        if(this.getPrestamos().isEmpty()){
            aux = false;
        }
        
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.vencido(new GregorianCalendar())){
                aux = false;
            }
        }
        
        return aux;
    }

    /**
     * Agrega dias de prestamo al docente si es responsable
     * 
     * @param p_dias número de días a añadir al período de préstamo
     */
    public void cambiarDiasDePrestamo(int p_dias) {
        if(this.esResponsable()) {
            this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
        }
    }

    /**
     * Verifica si el docente puede realizar una nueva solicitud de préstamo. Se verifica que no existan préstamos vencidos.
     * 
     * @return true si el docente puede realizar una solicitud; false en caso contrario
     */
    public boolean puedePedir() {
        return super.puedePedir();
    }

    /**
     * Devuelve el tipo de socio.
     * 
     * @return "Docente" para esta clase
     */
    public String soyDeLaClase() {
        return "Docente";
    }
}

