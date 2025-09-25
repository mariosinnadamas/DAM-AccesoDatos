package ejercicios13;

import java.io.IOException;

public class MainArchivoTexto {
    public static void main(String[] args) {
        String path = "src/ejercicios13/Lorem ipsum.txt";

        System.out.println("------ EJERCICIO1 ------");
        ArchivoTXT archivo = new ArchivoTXT(path);

        System.out.println("------ EJERCICIO2 ------");
        try {
            System.out.println(archivo.aVerso());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("------ EJERCICIO3 ------");
        String path3 = "src/ejercicios13/Prueba2.txt";
        archivo.codifica(path3);
        String path3b = "src/ejercicios13/Prueba3.txt";
        archivo.codifica2(path3b);
        String path3c = "src/ejercicios13/Prueba4.txt";
        try {
            archivo.codifica3(path3c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("------ EJERCICIO4 ------");
        String path4 = "MoverArchivoEliminar/Mover.txt";
        System.out.println(archivo.mover(path4));

        System.out.println("------ EJERCICIO5 ------");
        String path5 = "src/ejercicios13/Prueba.txt";
        System.out.println("Contador de caracteres: " + archivo.contar(path5));
        System.out.println("Contador de letras: " + archivo.contar2(path5));
        System.out.println("Contador de signos de puntuacion: " + archivo.contar3(path5));

        System.out.println("------ EJERCICIO6 ------");
        String path6 = "src/ejercicios13/Prueba.txt";
        System.out.println("Contador de lineas: " + archivo.contadorLineas(path6));

        System.out.println("------ EJERCICIO7 ------");
        String path7 = "src/ejercicios13/Prueba.txt";
        System.out.println("Contador de palabras: " +  archivo.contar3(path7));

        System.out.println("------ EJERCICIO8 ------");
        String path8 = "src/ejercicios13/Prueba.txt";
        archivo.cuentaVocales(path8);

        System.out.println("------ EJERCICIO9 ------");
        String path9 = "src/ejercicios13/Prueba.txt";
        archivo.cuentaVocales2(path9);

        System.out.println("------ EJERCICIO10 ------");
        String path10 = "src/ejercicios13/Prueba.txt";
        archivo.frecuenciaLetras(path10);
    }
}
