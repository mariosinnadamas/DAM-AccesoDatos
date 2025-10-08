package ejercicios15.starwars.excepciones;

public class PersonajeDuplicadoException extends RuntimeException {
    public PersonajeDuplicadoException(String message) {
        super(message);
    }
}
