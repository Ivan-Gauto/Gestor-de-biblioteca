
/**
 * Excepción que ocurre cuando el préstamo no puede ser realizado.
 * 
 * @author Esquenón Ignacio Agustín
 * @version 9/11/2024
 */
public class PrestamoRechazadoException extends Exception
{
    public PrestamoRechazadoException(String mensaje){
        super(mensaje);
    }
}
