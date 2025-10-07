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

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonDAOFile implements PokemonDAO {
    private final File f = new File("Recursos/Pokemon.dat");
    private final int max_size = 100;
    private int contadorPokemon;

    @Override
    public boolean estaVacio() throws DataAccessException {
        try{
            return contadorPokemon == 0;
        } catch (Exception e){
            throw new DataAccessException();
        }
    }

    @Override
    public boolean estaLLeno() throws DataAccessException {
        if (f.length()>=max_size){
            return true;
        } else {
            throw new DataAccessException();
        }
    }

    @Override
    public void aniadir(Pokemon pokemon) throws DataAccessException, DataDestFullException, DuplicateKeyException {
        //TODO: Arreglar excepciones, sustituir la parte de eliminar por la llamada al metodo eliminar
        boolean borrado = false;
        if (!estaLLeno()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
                while (true){
                    Pokemon existente = new Pokemon();
                    existente.readExternal(ois);
                    if (existente.getNombre().equals(pokemon.getNombre())){
                        throw new DuplicateKeyException();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new DataAccessException();
            } catch (IOException e) {
                throw new DataAccessException();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,true))){
            oos.writeObject(pokemon);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminar(Pokemon pokemon) throws DataAccessException, DataIntegrityException, IncompatibleVersionException {
        //Leo el archivo y lo meto en una lista

        //TODO: Escritura de nuevo al fichero con el elemento borrado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    //Metodo lectura de pokemon
    public List<Pokemon> leerPokemons() throws DataAccessException, IncompatibleVersionException {
        ArrayList pokemonColeccion = new ArrayList <Pokemon>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            while (true){
                try {
                    Pokemon p = (Pokemon) ois.readObject();
                    pokemonColeccion.add(p);
                } catch (EOFException e){
                    break;
                } catch (ClassNotFoundException e) {
                    throw new IncompatibleVersionException();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataAccessException();
        } catch (IOException e) {
            throw new IncompatibleVersionException();
        }
        return pokemonColeccion;
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
