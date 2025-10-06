package ejercicios11;

import java.io.File;

public class Ejercicio1 {
    /*
        Crea un metodo listarDirectorio()que devuelva una array con el listado del
        contenido (archivos y carpetas) del directorio actual.
        ¿Este metodo debería ser dinámico o estático? ¿por qué?

        Estático, para que así no sea necesario instanciarlo y
        así solo pertenece a la clase y no a cada objeto.
        -- EXPLICACIÓN DE SERGIO: --
        Se usa static porque el main es static tambien
        y así podemos usarlo.
         */

    public static void main(String[] args) {

        try {
            String[] archivos = listarDirectorio();

            System.out.println("Contenido:");
            for (String nombre : archivos) {
                System.out.println(nombre);
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());
        }

    }

    private static String [] listarDirectorio() {
        File f1 = new File(".");
        if (!f1.exists()) {
            throw new RuntimeException("No se encontró el archivo");
        }
        if (!f1.isDirectory()) {
            throw new RuntimeException("No es un directorio");
        }

        String [] contenido = f1.list();
        if (contenido == null) {
            throw new RuntimeException("El directorio está vacío");
        }
        return contenido;
    }
}
