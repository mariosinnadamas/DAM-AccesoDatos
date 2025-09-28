package ejercicios14;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainAmuletos14 {
    public static void main(String[] args) {
        ArrayList<AmuletosEj14> listaAmuletos = new ArrayList<>();

        File fBin = new File("Recursos/AmuletoBinario.bin");
        File fBin2 = new File("Recursos/listaAmuletos.bin");

        //Escritura objeto en binario
        AmuletosEj14 a = new AmuletosEj14("Cuerpo rápido 2", "Cumbre de cristal", 1,3.0,true);

        //Ejercicio 1.4.1
        try {
            a.escribirBinAmuletos(fBin);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //1.4.2
        listaAmuletos.add(new AmuletosEj14("Brújula caprichosa", "Tienda", 1,0.0,true));
        listaAmuletos.add(new AmuletosEj14("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false));
        listaAmuletos.add(new AmuletosEj14("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true));
        listaAmuletos.add(new AmuletosEj14("Corte rápido", "Nido Profundo", 1,0.0,true));
        escribirListaBinario(listaAmuletos, fBin2);
        ArrayList<AmuletosEj14> amuletosVuelta = leerListaBinario(fBin2);
        for (AmuletosEj14 am : amuletosVuelta) {
            System.out.println(am);
        }

    }

    public static void agregarAmuletos(AmuletosEj14 am){
        String ruta = "src/ejercicios13/amuletos.csv";
        File f = new File(ruta);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))){
            bw.write(am.toCSV() + "\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarAmuletos(String ruta){
        File f = new File (ruta);
        ArrayList <AmuletosEj14> amuletos = new ArrayList<>();
        String [] datos;
        AmuletosEj14 a;
        try (Scanner sc = new Scanner(new FileReader(f))){
            while (sc.hasNextLine()){
                datos = sc.nextLine().split(";");
                a = new AmuletosEj14(datos[0],datos[1], Integer.parseInt(datos[2]),Double.parseDouble(datos[3]),Boolean.parseBoolean(datos[4]));
                amuletos.add(a);
            }
        } catch (FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo " + e.getMessage());
        }

        for (AmuletosEj14 am : amuletos){
            System.out.println(am.toString());
        }
    }

    //1.4.2
    public static void escribirListaBinario(ArrayList<AmuletosEj14> amuletos, File f){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            if (amuletos.isEmpty()){
                return;
            }
            for (AmuletosEj14 am : amuletos){
                oos.writeObject(am);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }

    public static ArrayList<AmuletosEj14> leerListaBinario(File f) {
        ArrayList<AmuletosEj14> lista = new ArrayList<>();
        if (!f.exists()){
            System.err.println("No se ha encontrado el archivo");
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            while (true) {
                try {
                    AmuletosEj14 am = (AmuletosEj14) ois.readObject();
                    lista.add(am);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }
}
