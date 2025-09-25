package ejercicios11;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        /*
        Sin modificar los permisos del archivo este puede
        ser borrado sin problema.
        Una vez modificados los permisos el archivo sigue siendo eliminado sin problema.
         */
        String ruta = "F:/2º/Acceso a datos/Tema1/src/ejercicios11/DAM2MarioSaez.txt";
        try {
            borrarArchivo(ruta);
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }
    private static void borrarArchivo(String ruta) {
        File f = new File(ruta);
        if (!f.exists() || f.isDirectory()) {
            throw new RuntimeException("No se puede borrar el archivo");
        }

        if (f.setReadOnly()){
            System.out.println("Archivo solo lectura");
        } else {
            System.out.println("No se ha podido modificar el permiso del archivo");
        }

        if (f.delete()) {
            System.out.println("Archivo eliminado");
        } else {
            throw new RuntimeException("No se puede eliminar el archivo");
        }
    }
}
