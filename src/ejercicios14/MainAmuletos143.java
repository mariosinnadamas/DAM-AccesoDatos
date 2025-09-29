package ejercicios14;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainAmuletos143 {
    public static void main(String[] args) {
        File f = new File("Recursos/Amuleto143.bin");
        File listaBin = new File("Recursos/ListaBinAmuleto143.bin");
        File listaBin2 = new File("Recursos/Lista2BinAmuleto143.bin");
        AmuletosEj143 amuleto = new AmuletosEj143("Bendición de Joni", "Descanso de Joni",1,0.0,true, LocalDate.of(2020,1,1));
        try {
            amuleto.escribirBinAmuletos(f);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<AmuletosEj143> amuletos = new ArrayList<>();
        amuletos.add(new AmuletosEj143("Brújula caprichosa", "Tienda", 1,0.0,true,LocalDate.of(2023,2,8)));
        amuletos.add(new AmuletosEj143("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false, LocalDate.of(2025,6,16)));
        amuletos.add(new AmuletosEj143("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true, LocalDate.of(2022,4,25)));
        amuletos.add(new AmuletosEj143("Corte rápido", "Nido Profundo", 1,0.0,true,LocalDate.of(2021,9,29)));
        escribirBinAmuletos(amuletos, listaBin2);
        leerListaBinario(listaBin2);

    }
    //Ambos metodos sirven para serializable como para externalizable
    public static void escribirBinAmuletos(ArrayList <AmuletosEj143> lista, File f){
        if (lista.isEmpty()) {
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            for (AmuletosEj143 am : lista) {
                oos.writeObject(am);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerListaBinario(File f){
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
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Mostrar lista
        for (AmuletosEj143 am : listaVuelta) {
            System.out.println(am);
        }
    }
}
