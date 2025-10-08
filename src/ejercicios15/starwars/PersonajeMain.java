package ejercicios15.starwars;

import ejercicios15.starwars.excepciones.AccesoArchivoException;
import ejercicios15.starwars.excepciones.IntegridadCSVException;
import ejercicios15.starwars.excepciones.PersonajeDuplicadoException;

import java.util.ArrayList;

public class PersonajeMain {
    public static void main(String[] args) {
        PersonajeDAOFile dao = new PersonajeDAOFile("Recursos/People2.csv");

        try {
            System.out.println("LECTURA DE PERSONAJES");
            ArrayList <Personaje> lista = dao.leerPersonajes();
            for (Personaje temp : lista){
                System.out.println(temp);
            }

            System.out.println("--------------");
            System.out.println("AÑADIR PERSONAJE BATMAN");
            dao.aniadir(new Personaje("Batman","Male","1990",180,80,"Black","White","brown","Earth","Human"));
            for (Personaje temp : lista){
                System.out.println(temp);
            }

        } catch (AccesoArchivoException e) {
            System.out.println("Error de acceso al archivo: " + e.getMessage());
        } catch (IntegridadCSVException e) {
            System.err.println("Error de integridad en el CSV: " + e.getMessage());
        } catch (PersonajeDuplicadoException e) {
            System.err.println("El personaje ya se encuentra en la lista");
        }
    }
}
