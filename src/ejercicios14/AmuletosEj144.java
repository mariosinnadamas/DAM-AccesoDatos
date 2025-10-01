package ejercicios14;

import java.io.*;
import java.time.LocalDate;

public class AmuletosEj144 implements Externalizable {
    private String nombre;
    private String zona;
    private int cantidad;
    private double dano;
    private boolean activo;
    private LocalDate fecha;

    public AmuletosEj144(String nombre, String zona, int cantidad, double dano, boolean activo, LocalDate fecha) {
        this.nombre = nombre;
        this.zona = zona;
        this.cantidad = cantidad;
        this.dano = dano;
        this.activo = activo;
        this.fecha=fecha;
    }
    //Constructor vacío para Externalizable
    public AmuletosEj144() {
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
    public void escribirBinAmuletos(File f) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    //Aqui debe hacerse con writeObject/readobject o con writeUTF y readUTF
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(nombre);
        out.writeUTF(zona);
        out.writeInt(cantidad);
        out.writeDouble(dano);
        out.writeBoolean(activo);
        out.writeUTF(fecha.toString());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        nombre = in.readUTF();
        zona = in.readUTF();
        cantidad = in.readInt();
        dano = in.readDouble();
        activo = in.readBoolean();
        //Con el campo fecha parseo de String al objecto LocalDate
        fecha=LocalDate.parse(in.readUTF());
    }
}
