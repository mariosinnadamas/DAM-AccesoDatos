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

    private final File f;
    private final int max_size = 100;
    private int contadorPokemon;

    public PokemonDAOFile(String rutafichero) {
        this.f = new File(rutafichero);
    }


    //Metodo para comprobar que la lista está vacía
    @Override
    public boolean estaVacio() throws DataAccessException {
        try{
            if (!f.exists()) return true;
            return contadorPokemon == 0;
        } catch (Exception e){
            throw new DataAccessException("No se ha podido acceder al almacén", e);
        }
    }

    //Metodo para comprobar que la lista esta llena
    @Override
    public boolean estaLLeno() throws DataAccessException {
        try{
            return contadorPokemon == max_size;
        } catch (Exception e){
            throw new DataAccessException("No se ha podido acceder al almacén", e);
        }
    }
    //Metodo para añadir un pokemon
    @Override
    public void aniadir(Pokemon pokemon) throws DataAccessException, DataDestFullException, DuplicateKeyException, IncompatibleVersionException {
        //Leo con el metodo de lectura, este metodo ya controla DataAccesException
        List<Pokemon> lista = leerPokemons();

        if (lista.size()>= max_size){
            throw new DataDestFullException("El almacén está lleno, no se puede añadir más Pokémon.");
        }

        for (Pokemon p: lista){
            if (p.getNombre().equalsIgnoreCase(pokemon.getNombre())){
                throw new DuplicateKeyException("El pokemon ya existe"); //El pokemon ya existía en la lista
            }
        }

        lista.add(pokemon);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,true))){
            oos.writeObject(pokemon);
            contadorPokemon++; //Incremento de contador para saber cuantos objetos hay en la lista
        } catch (IOException e) { //Si no encuentra el archivo y/o no se puede escribir
            throw new DataDestFullException("No se ha encontrado el archivo o no se puede escribir");
        }
    }

    @Override
    public boolean eliminar(Pokemon pokemon) throws DataAccessException, DataIntegrityException, IncompatibleVersionException {
        //Leo el archivo y lo meto en una lista
        List<Pokemon> lista = leerPokemons();

        //Busco si existe un pokemon igual que el pasado por argumento para borrarlo
        boolean eliminado = false;

        for (int i = 0; i < lista.size(); i++) {
            Pokemon p = lista.get(i);
            if (p.getNombre().equalsIgnoreCase(pokemon.getNombre())){ //Si coincice en nombre se elimina
                lista.remove(i);
                eliminado = true;
                contadorPokemon--; //Reduzco el contador para saber cuantos pokemon hay en la coleccion
                break;
            }
        }
        //Si no se ha podido eliminar
        if (!eliminado){
            throw new DataIntegrityException("No se ha encontrado el Pokémon a eliminar");
        }
        return eliminado;
    }

    @Override
    //Metodo lectura de pokemon
    public List<Pokemon> leerPokemons() throws DataAccessException, IncompatibleVersionException {
        List<Pokemon> pokemonColeccion = new ArrayList <>();

        if (!f.exists()){
            return pokemonColeccion;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            while (true){
                try {
                    Pokemon p = (Pokemon) ois.readObject();
                    pokemonColeccion.add(p);
                } catch (EOFException e){ //Fin del archivo
                    break;
                } catch (ClassNotFoundException e) { //Si los datos leidos no corresponden
                    throw new IncompatibleVersionException("Versión incompatible del objeto", e);
                }
            }
            //Si no se ha podido acceder
        } catch (FileNotFoundException e) {
            throw new DataAccessException("Archivo no encontrado", e);
            //Si los datos leidos no corresponden
        } catch (IOException e) {
            throw new DataAccessException("Error leyendo el fichero", e);
        }
        return pokemonColeccion;
    }

    @Override
    public List<Pokemon> leerPokemons(String nombre) throws DataAccessException, IncompatibleVersionException {
        //Lista filtrada
        List<Pokemon> filtrados = new ArrayList <>();
        for (Pokemon p : leerPokemons()){ //Traigo una lista del metodo
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    @Override
    public void actualizar(Pokemon p) throws DataAccessException, IncompatibleVersionException {
        List<Pokemon> listaActualizada = leerPokemons();
        boolean actualizado = false;

        for (int i = 0; i < listaActualizada.size(); i++) {
            if (listaActualizada.get(i).equals(p)){
                listaActualizada.set(i,p);
                actualizado = true;
                break;
            }
        }

        if (!actualizado){
            throw new DataAccessException("La estructura del pokemon recibido no coincide");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            for (Pokemon poke : listaActualizada) {
                oos.writeObject(poke);
            }
        } catch (IOException e) {
            throw new DataAccessException("Error escribiendo tras actualizar", e);
        }
    }

    @Override
    public void pokemonCSV(String ruta, String name, int level, int life, int atack, int defense, int specialAttack, int specialdefense, int speed) {

        Pokemon p = new Pokemon(name,level,life,atack,defense,specialAttack,specialdefense,speed);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true))){
            bw.write(p.toCSV());
        } catch (IOException e) {
            System.err.println("Error escribiendo CSV: " + e.getMessage());
        }
    }

    @Override
    public void imprimirPokemonCSV(String ruta) throws NoSuchFileException {
        File csv = new File(ruta);
        if (!csv.exists()) {
            throw new NoSuchFileException("El archivo no existe.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";"); //Divido la linea con los ;
                if (datos.length == 8) {
                    System.out.println("Name: " + datos[0]);
                    System.out.println("Level: " + datos[1]);
                    System.out.println("HP: " + datos[2]);
                    System.out.println("Attack: " + datos[3]);
                    System.out.println("Defense: " + datos[4]);
                    System.out.println("Special Attack: " + datos[5]);
                    System.out.println("Special Defense: " + datos[6]);
                    System.out.println("Speed: " + datos[7]);
                    System.out.println("----------------------------");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    @Override
    public void imprimirPokemon(String nombre) {
        try {
            List<Pokemon> lista = leerPokemons();
            boolean encontrado = false;

            for (Pokemon p : lista) {
                if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(p);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron pokemons con ese nombre");
            }

        } catch (Exception e) {
            System.err.println("Error al imprimir pokemons: " + e.getMessage());
        }
    }

}
