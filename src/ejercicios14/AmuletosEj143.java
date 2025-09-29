package ejercicios14;

import java.io.*;
import java.time.LocalDate;

public class AmuletosEj143 implements Externalizable{
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

    public AmuletosEj143() {
        //Constructor vacio obligatorio para externalizable
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

    @Override
    //Aqui debe hacerse to-do con writeObject/readobject o con writeUTF y readUTF
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.nombre);
        out.writeObject(this.zona);
        out.writeObject(this.cantidad);
        out.writeObject(this.dano);
        out.writeObject(this.activo);
        out.writeObject(this.fecha);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        nombre = (String) in.readObject();
        zona = (String) in.readObject();
        cantidad = (int) in.readObject();
        dano = (double) in.readObject();
        activo = (boolean) in.readObject();
        //Con el campo fecha al haber usado LocalDate puedo usar un in.readObject y no tener problema de nada
        fecha = (LocalDate) in.readObject();
    }
}
