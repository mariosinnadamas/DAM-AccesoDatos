package ejercicios14;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainAmuletos144 {
    //EJERCICIO 1.4.3
    public static void main(String[] args) {
        File listaBin = new File("Recursos/ListaBinAmuleto144.bin");
        AmuletosEj144 amuleto = new AmuletosEj144("Bendición de Joni", "Descanso de Joni",1,0.0,true, LocalDate.of(2020,1,1));

        //Repetir ejercicio 1.4.1
        File f = new File("Recursos/Amuleto143.bin");

        try {
            amuleto.escribirBinAmuletos(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Repetir ejercicio 1.4.2
        ArrayList<AmuletosEj144> amuletos = new ArrayList<>();
        amuletos.add(new AmuletosEj144("Brújula caprichosa", "Tienda", 1,0.0,true,LocalDate.of(2023,2,8)));
        amuletos.add(new AmuletosEj144("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false, LocalDate.of(2025,6,16)));
        amuletos.add(new AmuletosEj144("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true, LocalDate.of(2022,4,25)));
        amuletos.add(new AmuletosEj144("Corte rápido", "Nido Profundo", 1,0.0,true,LocalDate.of(2021,9,29)));
        try {
            escribirBinAmuletos(amuletos, listaBin);
            leerListaBinario(listaBin);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //En este caso como la clase es Externalizable, OOS lo lee y llama directamente al metodo writeExternal, pasa lo mismo al leer
    public static void escribirBinAmuletos(ArrayList <AmuletosEj144> lista, File f) throws IOException{
        if (lista.isEmpty()) return;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            for (AmuletosEj144 am : lista) {
                oos.writeObject(am);
            }
        }
    }

    public static void leerListaBinario(File f) throws IOException, ClassNotFoundException {
        ArrayList<AmuletosEj144> listaVuelta = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            while (true) {
                try {
                    AmuletosEj144 am = (AmuletosEj144) ois.readObject(); //Aqui se invoca a readExternal
                    listaVuelta.add(am);
                } catch (EOFException e) {
                    break; //Fin del archivo
                }
            }
        }
        //Mostrar lista
        for (AmuletosEj144 am : listaVuelta) {
            System.out.println(am);
        }
    }
}
