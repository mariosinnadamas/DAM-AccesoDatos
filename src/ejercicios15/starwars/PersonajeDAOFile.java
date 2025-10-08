package ejercicios15.starwars;

import ejercicios15.starwars.excepciones.AccesoArchivoException;
import ejercicios15.starwars.excepciones.IntegridadCSVException;
import ejercicios15.starwars.excepciones.PersonajeDuplicadoException;
import ejercicios15.starwars.excepciones.PersonajeNoEncontradoException;

import java.io.*;
import java.util.ArrayList;

public class PersonajeDAOFile implements PersonajeDAO{
    private final File f;

    public PersonajeDAOFile(String path) {
        this.f = new File(path);
    }

    @Override
    public void aniadir(Personaje p) throws PersonajeDuplicadoException, IntegridadCSVException, AccesoArchivoException {
        ArrayList<Personaje>lista = leerPersonajes();

        //Si el personaje es el mismo lanza una excepcion
        for (Personaje temp : lista) {
            if (temp.equals(p)) {
                throw new PersonajeDuplicadoException("Personaje duplicado, no se puede añadir");
            }
        }

        //Si el if no lanza la excepción añade al personaje a la lista
        lista.add(p);

        //Vuelvo a escribir el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("name,gender,birth_year,height,mass,hair_color,skin_color,eye_color,planet,species");
            bw.newLine();
            for (Personaje temp : lista){
                bw.write(temp.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new AccesoArchivoException("Error al escribir en el archivo");
        }
    }

    @Override
    public boolean eliminar(Personaje p) throws AccesoArchivoException, PersonajeNoEncontradoException, IntegridadCSVException {
        ArrayList<Personaje>lista = leerPersonajes();
        boolean eliminado = false;
        return false;
    }

    @Override
    public ArrayList<Personaje> leerPersonajes() throws AccesoArchivoException, IntegridadCSVException {
        ArrayList <Personaje> listaPersonajes = new ArrayList<>();
        int numLinea = 0; //Permite identificar en que linea tendriamos un problema

        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;

            //Salto la primera linea (cabeceras)
            br.readLine();
            numLinea++;

            while ((linea = br.readLine()) != null){
                //Expresión regular que permite mantener la , dentro de un campo doble y separar el resto, además mantiene las ""
                String [] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                numLinea++;
                //Comprueba que la linea no tenga mas o menos columnas de las esperadas
                if (datos.length != 10){
                    throw new IllegalArgumentException("Error de formato en la linea " + numLinea + " hay mas/menos columnas");
                }

                //Montar Personaje
                try {
                    Personaje p = new Personaje(
                            datos[0], //name
                            datos[1], //gender
                            datos[2], // birth_year
                            Integer.parseInt(datos[3]), //height
                            Float.parseFloat(datos[4]), // mass
                            datos[5], //hair_colour
                            datos[6], //skin_colour
                            datos[7], //eye_colour
                            datos[8], //planet
                            datos[9]); //species
                    listaPersonajes.add(p);
                } catch (NumberFormatException e){ //Si al castear de String a otro tipo de dato ha habido un problema
                    throw new IntegridadCSVException("Error de formato en la linea " + numLinea, e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new AccesoArchivoException("No se ha encontrado el archivo: " + e);
        } catch (IOException e) {
            throw new AccesoArchivoException("Error de lectura en un archivo: " + e.getMessage(), e);
        }
        return listaPersonajes;
    }

    @Override
    public boolean actualizarPersonaje(Personaje p) throws AccesoArchivoException {
        return false;
    }
    /*
     * Todo: Hacer un metodo para que respete las " y no usar la expresión regular.
     *  El metodo usará char para contar caracter a caracter, una variante boolean por si encuentra unas " que cambie a
     *  true y asi las respete.
     */
}
