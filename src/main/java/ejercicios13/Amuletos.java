package ejercicios13;

import java.io.*;

public class Amuletos {
    private String nombre;
    private String zona;
    private int cantidad;
    private double dano;
    private boolean activo;

    public Amuletos(String nombre, String zona, int cantidad, double dano, boolean activo) {
        this.nombre = nombre;
        this.zona = zona;
        this.cantidad = cantidad;
        this.dano = dano;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDano() {
        return dano;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String toCSV() {
        return this.nombre + ";" + this.zona + ";" + this.cantidad + ";" + this.dano + ";" + this.activo;
    }
    //1.4.1: Escribir en binario
    public void escribirBinAmuletos(File f) throws FileNotFoundException {
        try {
           FileOutputStream fos = new FileOutputStream(f);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(this);
           oos.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
