import java.util.ArrayList;

/**
 * Clase que modela el concepto de un Estudiante, un tipo de Socio.
 * @author Garavaglia Miguel
 * @version 4.11.24 Optifine
 */
public class Estudiante extends Socio {
    private String carrera;

    /**
     * Constructor para crear un objeto Estudiante con sus datos y carrera específica.
     * 
     * @param p_dniSocio DNI del estudiante
     * @param p_nombre Nombre del estudiante
     * @param p_carrera Carrera del estudiante
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        super(p_dniSocio, p_nombre, 20);
        this.setCarrera(p_carrera);
    }

    /**
     * Constructor para crear un objeto Estudiante con sus datos y carrera específica.
     * 
     * @param p_dniSocio DNI del estudiante
     * @param p_nombre Nombre del estudiante
     * @param p_carrera Carrera del estudiante
     * @param p_prestamos Prestamos del docent
     */
    public Estudiante(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos, String p_carrera) {
        super(p_dniSocio, p_nombre, 20, p_prestamos);
        this.setCarrera(p_carrera);
    }

    //Setter

     /**
     * Establece la carrera del estudiante.
     * 
     * @param p_carrera carrera del estudiante
     */
    public void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
    }

    //Getter
    /**
     * Obtiene la carrera del estudiante.
     * 
     * @return carrera del estudiante
     */
    public String getCarrera() {
        return this.carrera;
    }

   

    /**
     * Verifica si el estudiante puede pedir un nuevo libro. 
     * Un estudiante puede pedir un nuevo libro si tiene menos de 3 libros prestados y no tiene préstamos vencidos.
     * 
     * @return true si el estudiante puede pedir; false en caso contrario
     */
    public boolean puedePedir() {
        return super.puedePedir() && super.cantLibrosPrestados() < 3;
    }
    
    /**
     * Devuelve el tipo de socio como cadena.
     * 
     * @return "Estudiante" para esta clase
     */
    public String soyDeLaClase() {
        return "Estudiante";
    }
}
