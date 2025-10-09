package ejercicios15.starwars;

import ejercicios15.starwars.excepciones.AccesoArchivoException;
import ejercicios15.starwars.excepciones.IntegridadCSVException;
import ejercicios15.starwars.excepciones.PersonajeDuplicadoException;
import ejercicios15.starwars.excepciones.PersonajeNoEncontradoException;

import java.util.ArrayList;

public interface PersonajeDAO {

    //Metodos CRUD

    /**
     * Añade un nuevo elemento al almacén si hay sitio y no está ya
     * @param p a añadir en el almacén
     * @throws PersonajeDuplicadoException si el personaje ya existía en el almacén
     * @throws IntegridadCSVException si no se ha podido escribir
     * @throws AccesoArchivoException si no se ha podido acceder al archivo
     */
    public void aniadir(Personaje p) throws PersonajeDuplicadoException, IntegridadCSVException,
            AccesoArchivoException;

    /**
     * Elimina un elemento de la lista
     *
     * @param p Personaje con los mismos datos
     * @return true si ha podido eliminarlo
     *
     * @throws AccesoArchivoException si no ha podido acceder al archivo
     * @throws PersonajeNoEncontradoException Si no ha encontrado al personaje
     */
    public boolean eliminar (Personaje p) throws AccesoArchivoException, PersonajeNoEncontradoException, IntegridadCSVException;

    /**
     * Muestra los personajes del almacén
     *
     * @throws AccesoArchivoException si no ha podido acceder al archivo
     * @throws IntegridadCSVException si no coinciden los datos (quito este metodo)
     */
    public ArrayList<Personaje> leerPersonajes() throws AccesoArchivoException, IntegridadCSVException;

    /**
     * Buscar personajes que coincidan en nombre con la cadena pasada por parámetro
     * @param nombre texto que debe contener el nombre del personaje
     * @return lista de personajes que coincidan en nombre
     * @throws AccesoArchivoException
     * @throws IntegridadCSVException
     */
    public ArrayList<Personaje> leerPersonaje(String nombre) throws AccesoArchivoException,IntegridadCSVException;

    /**
     * Actualiza un elemento del almacén
     *
     * @param p Personaje con los mismos datos
     * @return true si se ha podido actualizar
     * @throws AccesoArchivoException Si no se ha podido acceder al archivo
     */
    public boolean actualizarPersonaje(Personaje p) throws AccesoArchivoException, IntegridadCSVException, PersonajeNoEncontradoException;

}
