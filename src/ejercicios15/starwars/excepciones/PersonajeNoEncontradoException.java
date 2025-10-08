package ejercicios15.starwars.excepciones;

public class PersonajeNoEncontradoException extends RuntimeException {
    public PersonajeNoEncontradoException(String message) {
        super(message);
    }
}
