
/**
 * Excepción que ocurre al intentar registrar un socio ya registrado en la biblioteca
 * 
 * @author Esquenón Ignacio 
 * @version 10/11/2024
 */
public class SocioRegistradoException extends Exception
{
    public SocioRegistradoException(String mensaje){
        super(mensaje);
    }
}
