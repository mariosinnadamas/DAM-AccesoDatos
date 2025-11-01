package ejercicios15.starwars.excepciones;

public class IntegridadCSVException extends Exception {
    public IntegridadCSVException(String message) {
        super(message);
    }

    public IntegridadCSVException(String message, Throwable cause) {
        super(message, cause);
    }
}
