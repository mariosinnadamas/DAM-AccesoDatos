package ejercicios11;

import java.io.File;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*
        El archivo antiguo desaparece al darle el nuevo nombre
        pero su contenido se mantiene intacto
         */
        String ruta = "F:/2º/Acceso a datos/Tema1/src/ejercicios11/MarioSaez.txt";

        try {
            renombrarArchivo(ruta);
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());;
        }
    }
    private static boolean renombrarArchivo(String ruta) {
        if (ruta == null || ruta.isEmpty()) {
            throw new IllegalArgumentException("La ruta no puede ser nulo o vacía");
        }

        //Archivo original
        File original = new File(ruta);
        if (!original.exists() || !original.isFile()) {
            System.out.println("El archivo no existe o no es un archivo válido");
            return false;
        }

        // Guardar nombre del archivo original y el directorio padre
        String nombre = original.getName();
        File directorio = original.getParentFile();

        //Creación del archivo con el nuevo nombre
        File archivoNuevo = new File(directorio, "DAM2" + nombre);

        //Renombre
        boolean exito = original.renameTo(archivoNuevo);
        if (exito) {
            System.out.println("El archivo se ha modificado con éxito");
        } else {
            System.out.println("El archivo no se ha modificado");
        }
        return exito;
    }
}
