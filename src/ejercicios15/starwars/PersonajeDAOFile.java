package ejercicios15.starwars;

import ejercicios15.starwars.excepciones.AccesoArchivoException;
import ejercicios15.starwars.excepciones.IntegridadCSVException;
import ejercicios15.starwars.excepciones.PersonajeDuplicadoException;
import ejercicios15.starwars.excepciones.PersonajeNoEncontradoException;

public class PersonajeDAOFile implements PersonajeDAO{
    @Override
    public void aniadir(Personaje p) throws PersonajeDuplicadoException, IntegridadCSVException, AccesoArchivoException {

    }

    @Override
    public boolean eliminar(Personaje p) throws AccesoArchivoException, PersonajeNoEncontradoException {
        return false;
    }

    @Override
    public void leerPersonajes() throws AccesoArchivoException, IntegridadCSVException {

    }

    @Override
    public boolean actualizarPersonaje(Personaje p) throws AccesoArchivoException {
        return false;
    }
}
