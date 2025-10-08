package ejercicios15.starwars.excepciones;

public class AccesoArchivoException extends Exception {
    public AccesoArchivoException(String message) {
        super(message);
    }
    public AccesoArchivoException(String message, Throwable cause) {
        super(message, cause);
    }
}
