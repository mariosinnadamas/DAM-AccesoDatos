package ejercicios15.pokemon.excepciones;

public class IncompatibleVersionException extends Exception {

    public IncompatibleVersionException(){

    }

    public IncompatibleVersionException(String message, Throwable cause) {
        super(message,cause);
    }

    public IncompatibleVersionException(String message) {
        super(message);
    }
}
