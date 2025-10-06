/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios15.ejemplos;

import ejercicios15.ejemplos.excepciones.DataAccessException;
import ejercicios15.ejemplos.excepciones.DataDestFullException;
import ejercicios15.ejemplos.excepciones.DataIntegrityException;
import ejercicios15.ejemplos.excepciones.DuplicateKeyException;
import ejercicios15.ejemplos.excepciones.IncompatibleVersionException;

import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonDAOFile implements PokemonDAO {
    @Override
    public boolean estaVacio() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean estaLLeno() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void aniadir(Pokemon pokemon) throws DataAccessException, DataDestFullException, DuplicateKeyException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminar(Pokemon pokemon) throws DataAccessException, DataIntegrityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> leerPokemons() throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> leerPokemons(String nombre) throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Pokemon p) throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pokemonCSV(String ruta, String name, int level, int life, int atack, int defense, int specialAttack, int specialdefense, int speed) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirPokemonCSV(String ruta) throws NoSuchFileException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirPokemon(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
