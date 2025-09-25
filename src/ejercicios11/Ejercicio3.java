package ejercicios11;

import java.io.File;

public class Ejercicio3 {
    public static void main(String[] args) {
        String ruta = "src/ejercicios11";
        String fichero = "prueba.txt";
        boolean respuesta = existeFichero(ruta,fichero);
        System.out.println(respuesta);
    }

    private static boolean existeFichero(String directorio, String fichero){
        boolean existe = false;
        if (directorio == null || fichero == null){
            System.out.println("Los parámetros están vacíos");
        }

        File rutaDirectorio = new File(directorio);
        File rutaFichero = new File(directorio + "/" + fichero);

        if (rutaDirectorio.exists() && rutaDirectorio.isDirectory()){ //El directorio no existe o no es un directorio
            System.out.println("El directorio existe");
            if (rutaFichero.exists()){
                System.out.println("El fichero existe");
                existe = true;
            } else {
                System.out.println("El fichero no existe");
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio");
        }
        return existe;
    }
}
