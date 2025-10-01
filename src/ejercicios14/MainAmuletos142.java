package ejercicios14;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainAmuletos142 {
    public static void main(String[] args) {
        ArrayList<AmuletosEj141> listaAmuletos = new ArrayList<>();

        File fBin = new File("Recursos/Amuleto141.bin");
        File fBin2 = new File("Recursos/ListAmuletos142.bin");
        //Prueba para ver que pasa si intentas leer un archivo que no sea binario
        //File fBin2 = new File("src/ejercicios13/Lorem Ipsum.txt");

        //Escritura objeto en binario
        AmuletosEj141 a = new AmuletosEj141("Cuerpo rápido 2", "Cumbre de cristal", 1,3.0,true);

        //1.4.1
        try {
            a.escribirBinAmuletos(fBin);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //1.4.2: Escribir y leer una lista de objetos
        // Si intentas leer un archivo .txt te da un error de cabecera, "invalid stream header"
        listaAmuletos.add(new AmuletosEj141("Brújula caprichosa", "Tienda", 1,0.0,true));
        listaAmuletos.add(new AmuletosEj141("Enjambre recolector", "Parámos Fúngicos", 1,3.5,false));
        listaAmuletos.add(new AmuletosEj141("Coraza robusta", "Ciudad de lágrimas", 1,1.0,true));
        listaAmuletos.add(new AmuletosEj141("Corte rápido", "Nido Profundo", 1,0.0,true));

        escribirListaBinario(listaAmuletos, fBin2);
        ArrayList<AmuletosEj141> amuletosVuelta = leerListaBinario(fBin2);
        for (AmuletosEj141 am : amuletosVuelta) {
            System.out.println(am);
        }
    }

    //1.4.2
    public static void escribirListaBinario(ArrayList<AmuletosEj141> amuletos, File f){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))){
            if (amuletos.isEmpty()){
                return;
            }
            for (AmuletosEj141 am : amuletos){
                dos.writeUTF(am.getNombre());
                dos.writeUTF(am.getZona());
                dos.writeInt(am.getCantidad());
                dos.writeDouble(am.getDano());
                dos.writeBoolean(am.isActivo());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<AmuletosEj141> leerListaBinario(File f) {
        ArrayList<AmuletosEj141> lista = new ArrayList<>();
        if (!f.exists()){
            System.err.println("No se ha encontrado el archivo");
            return lista;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(f))){
            while (true) {
                String nombre = dis.readUTF();
                try {
                    String zona = dis.readUTF();
                    int cantidad = dis.readInt();
                    double dano = dis.readDouble();
                    boolean activo = dis.readBoolean();

                    AmuletosEj141 a = new AmuletosEj141(nombre, zona, cantidad, dano, activo);
                    lista.add(a);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }
}
