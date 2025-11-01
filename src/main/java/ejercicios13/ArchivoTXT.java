package ejercicios13;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class ArchivoTXT {
    private Path ruta;
    //Ejercicio 1: Indica desde el constructor si un archivo existe y si es un fichero
    public ArchivoTXT(String rutaArchivo) throws IllegalArgumentException{
        Path path = null;
        try {
            path = Paths.get(rutaArchivo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        this.ruta = path;

        if (!Files.exists(path)) {
            //Sería mejor una excepción personalizada para decir que no se ha encontrado el archivo o que es un directorio
            throw new IllegalArgumentException("Archivo no encontrado");
        }
        if(Files.isDirectory(path)) {
            throw new IllegalArgumentException("El archivo es un directorio");
        }
    }

    // Ejercicio 2: lee cada linea del archivo y sustituye los . por saltos de linea
    public String aVerso() throws IOException {
        String textoFinal = "";
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(ruta.toFile()))) {
            while ((linea=br.readLine()) != null){
                linea = linea.replace(".","\n");
                textoFinal += linea + "\n";
            }
        }
        return textoFinal;
    }

    //Ejercicio 3: Elimina las vocales de cada linea con la clase File
    public void codifica(String ruta){
        String rutaOg = "src/ejercicios13/Prueba.txt";

        File fEscribir = new File(ruta);
        File fLeer = new File(rutaOg);

        if (fLeer.exists()) {
            try (FileReader fr = new FileReader(fLeer);
                 FileWriter fw = new FileWriter(fEscribir)) {

                int c;
                //Read devuelve un int por lo que cuando se acabe devolverá -1
                while ((c=fr.read()) != -1) {
                    char character = (char)c;
                    if (!esVocal(character)) {
                        fw.write(character);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Archivo no encontrado o argumento inválido");
        }
    }
    //Ejercicio 3B: Elimina las vocales de cada linea con la clase Buffered
    public void codifica2(String ruta) {
        String rutaOg = "src/ejercicios13/Prueba.txt";
        File fEscribir = new File(ruta);
        File fLeer = new File(rutaOg);
        if (fLeer.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fLeer));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fEscribir))){

                int c;
                while ((c = br.read()) != -1) {
                    char character = (char)c;
                    if (!esVocal(character)) {
                        bw.write(character);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Ejercicio 3C: Elimina las vocales de cada linea usando Files
    public void codifica3(String ruta) throws IOException {
        String rutaOriginal = "src/ejercicios13/Prueba.txt";
        Path rutaEscribir = Paths.get(ruta);
        Path rutaOg = Paths.get(rutaOriginal);
        try (BufferedReader br = Files.newBufferedReader(rutaOg);
             BufferedWriter bw = Files.newBufferedWriter(rutaEscribir)) {
                int c;
                while ((c = br.read()) != -1) {
                    char character = (char)c;
                    if (!esVocal(character)) {
                        bw.write(character);
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Ejercicio 4: Mover un archivo de una capreta a otra y eliminarla si se queda vacía
    public boolean mover(String ruta){
        String destino = "MoverArchivo/Mover.txt";
        File fOrigen = new File(ruta);
        File fDestino = new File(destino);

        if (fOrigen.renameTo(fDestino)) {
            System.out.println("El archivo se ha movido");

            File carpetaPadre = new File(fOrigen.getParent());
            if (carpetaPadre.isDirectory() && carpetaPadre.listFiles().length == 0) {
                if (carpetaPadre.delete()) {
                    System.out.println("Carpeta padre eliminada");
                } else {
                    System.out.println("Carpeta padre no eliminada");
                }
            }
            return true;
        }
        return false;
    }
    //Ejercicio 5A: Contador de caracteres
    public int contar(String ruta){
        int contador = 0;
        File fLeer = new File(ruta);
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(fLeer))) {
            while ((linea=br.readLine()) != null){
                for (char c : linea.toCharArray()) {
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contador;
    }

    //Ejercicio 5B: Contador de letras
    public int contar2(String ruta){
        int contador = 0;
        File fLeer = new File(ruta);
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(fLeer))) {
            while ((linea=br.readLine()) != null){
                for (char c : linea.toCharArray()) {
                    if (c != ' '){
                        contador++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contador;
    }

    //Ejercicio 5C: Cuenta el total de signos de puntuación de un fichero
    public int contar3(String ruta){
        int contador = 0;
        String signosAcent = ",.;:¿?!¡-_";
        File fLeer = new File(ruta);
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(fLeer))) {
            while ((linea=br.readLine()) != null){
                for (char c : linea.toCharArray()) {
                    if (signosAcent.contains(String.valueOf(c))){
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return contador;
    }

    //Ejercicio 6: Contador de lineas
    public int contadorLineas(String ruta){
        int contador = 0;
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((linea=br.readLine()) != null){
                linea = linea.replace(".","\n");
                contador++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return contador;
    }

    //Ejercicio 7: Contador de palabras
    public int contadorPalabras(String ruta) throws IOException {
        int contador = 0;
        String linea;
        String [] palabras;

        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((linea=br.readLine()) != null){
                if (!linea.isEmpty()){
                    palabras = linea.split(" ");
                    contador+= palabras.length;
                }
            }

        }

        return contador;
    }

    //Ejercicio 8: Cuenta las vocales
    public void cuentaVocales(String ruta){
        String rutaEscribir = "src/ejercicios13/numVocales.txt";
        File fLeer = new File(ruta);
        File fEscribir = new File(rutaEscribir);
        String linea;
        int contador = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(fLeer));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fEscribir))){
            while ((linea=br.readLine()) != null) {
                for (char c : linea.toCharArray()) {
                    if (esVocal(c)){
                        bw.write(contador + " ");
                        contador++;
                    }
                }
            }
            /*Las excepciones funcionan de menos a mas, es decir, si aqui colocas el IOException primero te dice que no va a ser capturada
            porque FileNotFoundException hereda de IO.
             */
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo" + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(contador);
    }

    //Ejercicio 9: Contar las vocales pero con tildes incluidas
    /*CORRECCION:
    El metodo debe ser int ya que se espera que devuelva un numero
     */
    public int cuentaVocales2(String ruta){
        String rutaEscribir = "src/ejercicios13/numVocales.txt";
        File fLeer = new File(ruta);
        File fEscribir = new File(rutaEscribir);
        String linea;
        int contador = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(fLeer));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fEscribir))){
            while ((linea=br.readLine()) != null) {
                for (char c : linea.toCharArray()) {
                    if (esVocalTilde(c)){
                        bw.write(contador + " ");
                        contador++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contador;
    }

    //Ejercicio 10: Contar con que frecuencia aparecen las letras
    /*CORRECCION:
    En caso de usar variables con un numero fijo es conveniente usar final para que en el futuro la legibilidad
    del codigo será mas sencilla
     */
    public void frecuenciaLetras(String ruta){
        File archivo = new File(ruta);
        String linea;

        Map<Character, Integer> frecuencia = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();
                for (char c : linea.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
                    }
                }
            }
        } catch (AccessDeniedException e) {
            System.out.println("Acceso denegado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Mostrar resultado
        for (char c = 'a'; c <= 'z'; c++) {
            int count = frecuencia.getOrDefault(c, 0);
            System.out.println(c + ": " + count);
        }
    }

    //Metodo para comprobar si el caracter que se pasa es una vocal, de no serlo devuelve 0 o mayor (la posición en la que se encuentra en la cadena), si no, devuelve -1
    public boolean esVocal(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }

    public boolean esVocalTilde(char c){
        return "aeiouAEIOUáéíóúÁÉÍÓÚÜü".indexOf(c)!=-1;
    }

}