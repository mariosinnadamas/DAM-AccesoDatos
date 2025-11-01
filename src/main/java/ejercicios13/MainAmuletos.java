package ejercicios13;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainAmuletos {
    public static void main(String[] args) {
        ArrayList<Amuletos> amuletos = new ArrayList<Amuletos>();
        String ruta = "src/ejercicios13/amuletos.csv";

        File f = new File(ruta);

        amuletos.add(new Amuletos("Brújula caprichosa", "Tienda", 1,0.0,true));
        amuletos.add(new Amuletos("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false));
        amuletos.add(new Amuletos("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true));
        amuletos.add(new Amuletos("Corte rápido", "Nido Profundo", 1,0.0,true));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))){
            for (Amuletos am : amuletos){
                bw.write(am.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Agregar amuleto con el archivo ya creado
        Amuletos a2 = new Amuletos("Cuerpo rápido 2", "Cumbre de cristal", 1,3.0,true);
        agregarAmuletos(a2);
        mostrarAmuletos(ruta);
    }

    public static void agregarAmuletos(Amuletos am){
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
        ArrayList <Amuletos> amuletos = new ArrayList<>();
        String [] datos;
        Amuletos a;
        try (Scanner sc = new Scanner(new FileReader(f))){
            while (sc.hasNextLine()){
                datos = sc.nextLine().split(";");
                a = new Amuletos(datos[0],datos[1], Integer.parseInt(datos[2]),Double.parseDouble(datos[3]),Boolean.parseBoolean(datos[4]));
                amuletos.add(a);
            }
        } catch (FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo " + e.getMessage());
        }

        for (Amuletos am : amuletos){
            System.out.println(am.toString());
        }
    }
}
