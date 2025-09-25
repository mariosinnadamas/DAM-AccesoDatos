package ejercicios11;

import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        /*
        Con una carpeta vacía elimina sin problemas.
        Con una carpeta que contiene archivos no se puede eliminar usando la funcion File.delete.

         */
        String ruta = "F:/2º/Acceso a datos/Tema1/CarpetaEliminarConFicheros";
        try {
            eliminarDirectorio(ruta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean eliminarDirectorio(String ruta) {
        //Comprobación de la ruta
        if (ruta.isEmpty()) {
            throw new IllegalArgumentException("La ruta no puede estar vacía o ser nula");
        }

        File directory = new File(ruta);
        //Comprobación del archivo
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("No se puede eliminar el archivo, no existe o no es un directorio válido: " + ruta);
            return false;
        }

        //Comprobación para ver si contiene carpetas
        File[] contenido = directory.listFiles();
        if (contenido != null) {
            for(File f : contenido) {
                if (f.isDirectory()) {
                    System.out.println("No se puede eliminar: contiene directorios");
                    return false;
                }
                //Intentar borrar los archivos sin borrar los directorios
                if (!f.delete()) {
                    System.out.println("No se pudo eliminar el archivo: " + f.getName());
                    return false;
                }
            }
        }

        //Intentar borrar la carpeta padre (en teoría vacío)
        if (directory.delete()) {
            System.out.println("El archivo se eliminado correctamente");
            return true;
        } else {
            System.out.println("No se ha podido eliminar el archivo");
            return false;
        }
    }
}
