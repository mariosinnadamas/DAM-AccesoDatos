package ejercicios11;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*
        ¿Qué devolvería en caso de que la ruta que nos proporcionan
        no se correspondiera con un directorio?

        En este caso que he controlado la excepción te avisa de ello,
        de lo contrario habría un error.

        --COMENTARIO SERGIO:
        No se deben dejar sout en los metodos, no deben sacar datos, ya
        que tienen otro propósito. Se detallará más en el tema excepciones.
         */

        // Ruta relativa
        try {
            String [] archivos = listarDirectorio(".");
            for (String nombre : archivos) {
                System.out.println(nombre);
            }

            System.out.println("---------");

            //Ruta absoluta
            String [] archivos2 = listarDirectorio("/Volumes/Mario/2º/AccesoDatos/src");
            for (String nombre : archivos2) {
                System.out.println(nombre);
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());;
        }
    }

    private static String[] listarDirectorio(String directorio) {
        File f1 = new File(directorio);
        if (!f1.exists()) {
            throw new RuntimeException("El directorio no existe o no has introducido una ruta");
        }
        if (!f1.isDirectory()) {
            throw new RuntimeException("No es un directorio");
        }

        String[] contenido = f1.list();
        if (contenido == null) {
            throw new RuntimeException("El directorio está vacío");
        }
        return contenido;
    }
}
