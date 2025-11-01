package ejercicios15.starwars;

import ejercicios15.starwars.excepciones.AccesoArchivoException;
import ejercicios15.starwars.excepciones.IntegridadCSVException;
import ejercicios15.starwars.excepciones.PersonajeDuplicadoException;
import ejercicios15.starwars.excepciones.PersonajeNoEncontradoException;

import java.util.ArrayList;

public class PersonajeMain {
    public static void main(String[] args) {
        PersonajeDAOFile dao = new PersonajeDAOFile("Recursos/People2.csv");

        try {
            System.out.println("LECTURA DE PERSONAJES");
            ArrayList <Personaje> lista = dao.leerPersonajes();
            lista.forEach(System.out::println);

            System.out.println("--------------");
            System.out.println("AÑADIR PERSONAJE BATMAN Y BUSQUEDA EN LA LISTA");
            dao.aniadir(new Personaje("Batman","Male","1990",180,80,"Black","White","brown","Earth","Human"));
            //dao.aniadir(new Personaje("Superman","Male","1990",180,80,"Black","White","blue","Krypton","Human"));
            ArrayList<Personaje>batList = dao.leerPersonaje("man");
            batList.forEach(System.out::println);

            System.out.println("--------------");
            System.out.println("ELIMINAR PERSONAJE BATMAN");
            dao.eliminar(new Personaje("Batman","Male","1990",180,80,"Black","White","brown","Earth","Human"));

            System.out.println("--------------");
            System.out.println("ACTUALIZAR PERSONAJE SUPERMAN");
            dao.actualizarPersonaje(new Personaje("Superman","Male","Unknown",180,80,"Black","White","blue","Krypton","Human"));
            for (Personaje temp : dao.leerPersonajes()){
                System.out.println(temp);
            }
            System.out.println("--------------");
            System.out.println("LEER SKYWALKER");
            for (Personaje temp : dao.leerPersonaje("skywalker")){
                System.out.println(temp);
            }


        } catch (AccesoArchivoException e) {
            System.out.println("Error de acceso al archivo: " + e.getMessage());
        } catch (IntegridadCSVException e) {
            System.err.println("Error de integridad en el CSV: " + e.getMessage());
        } catch (PersonajeDuplicadoException e) {
            System.err.println("El personaje ya se encuentra en la lista");
        } catch (PersonajeNoEncontradoException e) {
            System.err.println("No se ha encontrado el personaje");
        }
    }
}
