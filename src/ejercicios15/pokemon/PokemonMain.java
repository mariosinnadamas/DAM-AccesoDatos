/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ejercicios15.pokemon;

import ejercicios15.pokemon.excepciones.*;

import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonMain {
    //Funciona si el archivo no existe, corregir para que funcione incluso cuando exista
    public static void main(String[] args) {
        // Ruta donde se guardarán los datos binarios y CSV
        String rutaBinario = "Recursos/pokemons.dat";
        String rutaCSV = "Recursos/pokemons.csv";

        //DAO
        PokemonDAOFile dao = new PokemonDAOFile(rutaBinario);

        try{
            System.out.println("AÑADIENDO 10 POKEMONS");
            dao.aniadir(new Pokemon("Bulbasaur", 5, 45, 49, 49, 65, 65, 45));
            dao.aniadir(new Pokemon("Ivysaur", 16, 60, 62, 63, 80, 80, 60));
            dao.aniadir(new Pokemon("Venusaur", 32, 80, 82, 83, 100, 100, 80));
            dao.aniadir(new Pokemon("Charmander", 5, 39, 52, 43, 60, 50, 65));
            dao.aniadir(new Pokemon("Charmeleon", 16, 58, 64, 58, 80, 65, 80));
            dao.aniadir(new Pokemon("Charizard", 36, 78, 84, 78, 109, 85, 100));
            dao.aniadir(new Pokemon("Squirtle", 5, 44, 48, 65, 50, 64, 43));
            dao.aniadir(new Pokemon("Wartortle", 16, 59, 63, 80, 65, 80, 58));
            dao.aniadir(new Pokemon("Blastoise", 36, 79, 83, 100, 85, 105, 78));
            dao.aniadir(new Pokemon("Pikachu", 10, 35, 55, 40, 50, 50, 90));

            System.out.println("Pokémons añadidos correctamente");
        } catch (DuplicateKeyException e) {
            System.err.println("Ya existe un Pokémon con ese nombre");
        } catch (DataAccessException | DataDestFullException | IncompatibleVersionException e) {
            System.err.println("Error al añadir: " + e.getMessage());
        }

        try {
            System.out.println("LISTA DE POKEMONS LEÍDOS");
            List<Pokemon> lista = dao.leerPokemons();
            lista.forEach(System.out::println);

            System.out.println("BUSCANDO POKEMONS QUE CONTIENEN 'saur'");
            List<Pokemon> saurList = dao.leerPokemons("saur");
            saurList.forEach(System.out::println);

            System.out.println("ELIMINANDO A PIKACHU ");
            boolean eliminado = dao.eliminar(new Pokemon("Pikachu", 10, 35, 55, 40, 50, 50, 90));
            System.out.println("Resultado: " + eliminado);

            System.out.println("ACTUALIZANDO A CHARMANDER");
            Pokemon nuevoCharmander = new Pokemon("Charmander", 10, 50, 60, 45, 65, 55, 70);
            dao.actualizar(nuevoCharmander);
            System.out.println("Charmander actualizado correctamente");

            System.out.println("CREANDO CSV DE POKEMONS");
            dao.pokemonCSV(rutaCSV, "Snorlax", 40, 160, 110, 65, 65, 110, 30);
            dao.pokemonCSV(rutaCSV, "Mew", 50, 100, 100, 100, 100, 100, 100);
            System.out.println("CSV generado correctamente");

            System.out.println("IMPRIMIENDO CONTENIDO DEL CSV");
            dao.imprimirPokemonCSV(rutaCSV);

            System.out.println("IMPRIMIENDO POKEMONS QUE CONTIENEN 'char'");
            dao.imprimirPokemon("char");

        } catch (NoSuchFileException e) {
            System.err.println("No existe el archivo CSV: " + e.getMessage());
        } catch (DataAccessException | IncompatibleVersionException | DataIntegrityException e) {
            System.err.println("Error durante las pruebas: " + e.getMessage());
        }
    }
}