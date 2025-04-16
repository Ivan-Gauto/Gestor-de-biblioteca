import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar; 
import java.util.*;

/**
 * Clase que representa una biblioteca en la cual se administran los libros 
 * y los socios que los retiran o devuelven.
 * 
 * @authors Ignacio, Esquenon; Sebastian, Gomez; Gauto, Ivan
 * @version 2.11.24
 */
public class Biblioteca {
    
    private String nombre;
    private ArrayList<Socio> socios;
    private ArrayList<Libro> libros;

    /**
     * Constructor para objetos de la clase Biblioteca sin socios ni libros
     * 
     * @param p_nombre nombre de la biblioteca
     */
    public Biblioteca(String p_nombre) {
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList<>());
        this.setLibros(new ArrayList<>());
    }

    /**
     * Constructor para objetos de la clase Biblioteca con socios y libros
     * 
     * @param p_nombre nombre de la biblioteca
     * @param p_socios lista de socios 
     * @param p_libros lista de libros
     */
    public Biblioteca(String p_nombre, ArrayList<Socio> p_socios, ArrayList<Libro> p_libros) {
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }

    //Setters
    
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    private void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    //Getters

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Socio> getSocios() {
        return this.socios;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    //Operaciones

    /**
     * Método que agrega un nuevo libro a la biblioteca.
     * 
     * @param p_titulo Título del libro.
     * @param p_edicion Edición del libro.
     * @param p_editorial Editorial del libro.
     * @param p_anio Año de publicación del libro.
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.getLibros().add(new Libro(p_titulo, p_edicion, p_editorial, p_anio));
    }

    /**
     * Método que agrega un nuevo socio estudiante a la biblioteca.
     * 
     * @param p_dniSocio DNI del socio estudiante.
     * @param p_nombre Nombre del socio estudiante.
     * @param p_carrera Carrera del socio estudiante.
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera)throws SocioRegistradoException{
        if(this.buscarSocio(p_dniSocio) == null){
            this.getSocios().add(new Estudiante (p_dniSocio, p_nombre, p_carrera));
        }
        else{
            throw new SocioRegistradoException(" El socio ingresado ya se encuentra registrado. ");
        }
    }

    /**
     * Método que agrega un nuevo socio docente a la biblioteca.
     * 
     * @param p_dniSocio DNI del socio docente.
     * @param p_nombre Nombre del socio docente.
     * @param p_area Área que se encarga el socio docente.
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) throws SocioRegistradoException{
        if(this.buscarSocio(p_dniSocio) == null){
            this.getSocios().add(new Docente(p_dniSocio, p_nombre, p_area));
        }
        else{
            throw new SocioRegistradoException(" El socio ingresado ya se encuentra registrado. ");
        }
    }

    /**
     * Método que crea un préstamo y registra en los datos del socio y el libro.
     *  Primero verifica si el libro no está prestado y si el socio puede pedir un préstamo, 
     *  luego registra el préstamo en los datos del libro y el socio.
     * 
     * @param p_fechaRetiro fecha de retiro del libro
     * @param p_socio Nombre del socio
     * @param p_libro Libro prestado
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) throws PrestamoRechazadoException {
        boolean aux = true;
        
        if(!(p_libro.prestado()) && p_socio.puedePedir()) {
            p_libro.agregarPrestamo(new Prestamo(p_fechaRetiro, p_socio, p_libro));
            p_socio.addPrestamo(new Prestamo(p_fechaRetiro, p_socio, p_libro)); 
            System.out.println(" Libro " + p_libro.getTitulo() + " prestado a " + p_socio.getNombre());          
        } else{
            aux = false;
            
            if(p_libro.prestado() && !(p_socio.puedePedir())){
                throw new PrestamoRechazadoException(" No se pudo realizar el préstamo: El libro se encuentra prestado, y el socio no cumple los requisitos para pedir un libro. ");
            }

            if(p_libro.prestado()){
                throw new PrestamoRechazadoException(" No se pudo realizar el préstamo: El libro se encuentra prestado. ");
            }
            
            if(! (p_socio.puedePedir())){
                throw new PrestamoRechazadoException(" No se pudo realizar el préstamo: El socio no cumple los requisitos para pedir un libro. ");
            }
        }
        
        return aux;
    } 

    /**
     * Lista los socios de la Biblioteca
     * 
     * @return Lista de socios
     */
    public String listaDeSocios() {
        String listaDeSocios = "";
        
        for(Socio soc : this.getSocios()){
            listaDeSocios += soc.toString() + "\n";
        }
        
        return listaDeSocios;
    }


    /**
     * Método que establece la fecha de devolución del préstamo en la fecha actual.
     *  Verifica que el libro esté prestado para establecer la fecha de devolución, de no estarlo 
     *  lanza una excepción de libro no prestado.
     * 
     * @param p_libro Libro en el que se registra en los datos del préstamo, la fecha de devolución.
     */
    public void devolverLibro(Libro p_libro) throws LibroNoPrestadoException{
        if(p_libro.prestado()){
            p_libro.ultimoPrestamo().registrarFechaDevolucion(new GregorianCalendar());
        } else{
            throw new LibroNoPrestadoException(" El libro " + p_libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca.");
        }
    }

    /**
     * Método que devuelve la cantidad de socios del tipo pasado como parámetro.
     * 
     * @param p_objeto Es el tipo de socio.
     * @return Valor entero correspondiente a la cantidad de socios del tipo indicado.
     */
    public int cantidadDeSociosPorTipo(String p_objeto){
        int cont = 0;
        
        for(Socio socio : this.getSocios()){
            if(socio.soyDeLaClase().equals(p_objeto)){
                cont++;
            }
        }

        return cont;
    }
    
    /**
     * Busca el socio en la lista segun su DNI
     * 
     * @param p_dni dni del socio
     * @return Socio encontrado
     */
    public Socio buscarSocio(int p_dni) {
        Socio socioEncontrado = null;
        
            for(Socio so : this.getSocios()) {
            if(so.getDniSocio() == p_dni) {
                socioEncontrado = so;
            }
        }
        
        return socioEncontrado;
    }

    /**
     * Lista los titulos que posee la biblioteca
     * 
     * @return lista de titulos de la biblioteca 
     */
    public String listaDeTitulos() {
        String listaDeTitulos = "";
        HashSet<String> titulosUnicos = new HashSet<>();
        int i = 1;
        
        for(Libro lib : this.getLibros()) {
            if(titulosUnicos.add(lib.getTitulo())){
                listaDeTitulos += i++ + ") " + lib.getTitulo() + "\n";
            }
        }
        
        return listaDeTitulos;     
    }
    
    
    /** Metodo que obtiene una lista de prestamos que están vencidos 
     * al dia de la fecha y aún no han sido devueltos.
     * 
     * @return Una lista de préstamos vencidos, que corresponde a libros prestados que aún no han sido devueltos, 
     * pero que ya están vencidos a día de la fecha.
    */ 
    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> listaVencidos = new ArrayList<>(); 

        for(Libro lib : this.getLibros()){ 
            if(lib.prestado() && lib.ultimoPrestamo().vencido(new GregorianCalendar())){ // Si el libro está prestado y al día de la fecha se encuentra vencido, se agrega a la lista
                listaVencidos.add(lib.ultimoPrestamo());
            }
        }
        
        return listaVencidos;
    } 

    /** 
     * Metodo que devuelve una lista de docentes responsables
     * 
     * Este método recorre la lista de socios de la biblioteca y
     * verifica en primer lugar si cada socio es un docente (instancia de docente), 
     * para luego verificar si cada docente nunca tuvo o tiene un libro vencido. 
     * Si es asi los agrega a la lista. 
     * 
     * @return lista de docentes responsables. 
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docResponsables = new ArrayList<>(); 

        for(Socio soc : this.getSocios()){
            if(soc instanceof Docente && ((Docente)soc).esResponsable()){
                docResponsables.add((Docente)soc); 
            }
        }
        
        return docResponsables;
    } 

    /** 
     * Metodo que verifica que socio posee el libro en cuestion 
     * 
     * Este metodo recibe por parametro un libro, recorre la lista de 
     * socios que prestaron libros, y verifica si alguno tiene el libro 
     * pasado por parametro. 
     * 
     * @param p_libro libro de la biblioteca. 
     * @return Nombre del socio quien tiene el libro actualmente.
     * 
    */
   
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException {
        String nombre = "";
    
        if(p_libro.prestado()){
            nombre = p_libro.ultimoPrestamo().getSocio().getNombre();
        }
        else{
            throw new LibroNoPrestadoException(" El libro se encuentra en la biblioteca. ");
        }
        
        return nombre;
    }
    
    /**
     * Lista los libros que posee la Biblioteca
     * 
     * @return lista de libros
     */
    public String listaDeLibros() {
        String listaDeLibros = "";
        String prestadoTexto = "";
        int i = 1;
        
        for(Libro lib : this.getLibros()){
            
            prestadoTexto = lib.prestado() ? "Sí" : "No";
            listaDeLibros += i++ + ") " + lib.toString() + " || " + "Prestado: " + "(" + prestadoTexto + ")" + "\n";
        }
        
        return listaDeLibros;
    }

    /**
     * Lista los Docentes Responsables
     * 
     * @return lista de docentes responsables
     */
    public String listaDeDocentesResponsables() {
        ArrayList<Docente> docentesResponsables = this.docentesResponsables();
        String docentes = "";
        
        for(Docente doc : docentesResponsables) {
            docentes += doc.toString() + "\n";
        }
        
        return docentes;
    }
}