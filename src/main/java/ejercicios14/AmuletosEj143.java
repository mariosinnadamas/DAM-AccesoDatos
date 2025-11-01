package ejercicios14;

import java.io.*;
import java.time.LocalDate;

public class AmuletosEj143 implements Serializable{

    @Serial
    private static final long serialVersionUID = 2;

    private String nombre;
    private String zona;
    private int cantidad;
    private double dano;
    private boolean activo;
    private LocalDate fecha;

    public AmuletosEj143(String nombre, String zona, int cantidad, double dano, boolean activo, LocalDate fecha) {
        this.nombre = nombre;
        this.zona = zona;
        this.cantidad = cantidad;
        this.dano = dano;
        this.activo = activo;
        this.fecha=fecha;
    }

    @Override
    public String toString() {
        return "Amuletos{" +
                "nombre='" + nombre + '\'' +
                ", zona='" + zona + '\'' +
                ", cantidad=" + cantidad +
                ", daño=" + dano +
                ", activo=" + activo +
                '}';
    }

    //1.4.3: Escribir en binario
    public void escribirBinAmuletos(File f) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
