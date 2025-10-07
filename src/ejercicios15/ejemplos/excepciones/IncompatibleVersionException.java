package ejercicios15.ejemplos.excepciones;

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
