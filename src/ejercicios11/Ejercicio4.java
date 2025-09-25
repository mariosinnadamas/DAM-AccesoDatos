package ejercicios11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*
        Si la ruta no existe he creado una excepción que te informa sobre ello
         */
        String ruta = "F:/2º/Acceso a datos/Tema1/src/ejercicios11";

        try {
            generarArchivo(ruta);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());;
        }
    }

    private static void generarArchivo(String ruta){
        //Comprueba que ruta no esté vacío
        if (ruta==null || ruta.isEmpty()){
            throw new RuntimeException("No se puede generar el archivo, ruta vacía o nula");
        }

        File directory = new File(ruta);

        //Control si existe el directorio o la ruta
        if (!directory.exists() || !directory.isDirectory()){
            throw new RuntimeException("La ruta especificada no existe o no es un directorio: " + ruta);
        }

        Scanner sc = new Scanner(System.in);
        String in = "";
        File fichero = new File(ruta, "MarioSaez.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            while (!(in=sc.nextLine()).equals("*")){
                bw.write(in);
                bw.newLine();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
