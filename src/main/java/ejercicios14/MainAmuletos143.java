package ejercicios14;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainAmuletos143 {
    //EJERCICIO 1.4.3
    public static void main(String[] args) {
        File listaBin = new File("Recursos/ListaBinAmuleto143.bin");
        AmuletosEj143 amuleto = new AmuletosEj143("Bendición de Joni", "Descanso de Joni",1,0.0,true, LocalDate.of(2020,1,1));

        //Repetir ejercicio 1.4.1
        File f = new File("Recursos/Amuleto143.bin");

        try {
            amuleto.escribirBinAmuletos(f);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Repetir ejercicio 1.4.2
        ArrayList<AmuletosEj143> amuletos = new ArrayList<>();
        amuletos.add(new AmuletosEj143("Brújula caprichosa", "Tienda", 1,0.0,true,LocalDate.of(2023,2,8)));
        amuletos.add(new AmuletosEj143("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false, LocalDate.of(2025,6,16)));
        amuletos.add(new AmuletosEj143("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true, LocalDate.of(2022,4,25)));
        amuletos.add(new AmuletosEj143("Corte rápido", "Nido Profundo", 1,0.0,true,LocalDate.of(2021,9,29)));
        try {
            escribirBinAmuletos(amuletos, listaBin);
            leerListaBinario(listaBin);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //Para usar la clase ObjectOutputStream hay que tener la clase como Serializable
    public static void escribirBinAmuletos(ArrayList <AmuletosEj143> lista, File f) throws IOException, ClassNotFoundException {
        if (lista.isEmpty()) {
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            for (AmuletosEj143 am : lista) {
                oos.writeObject(am);
            }
        }
    }

    public static void leerListaBinario(File f) throws IOException, ClassNotFoundException {
        ArrayList<AmuletosEj143> listaVuelta = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            while (true) {
                try {
                    AmuletosEj143 am = (AmuletosEj143) ois.readObject();
                    listaVuelta.add(am);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        //Mostrar lista
        for (AmuletosEj143 am : listaVuelta) {
            System.out.println(am);
        }
    }
}
