package ejercicios15;
/*
Completa la clase Pokemon para que sea un Java Bean que permita almacenar
los siguientes atributos.
Debes controlar los valores de los parámetros, gestionar posibles errores, etc.
La clase Pokemon debe implementar Externalizable.
 */
import java.io.*;

/*CONDICIONES PARA QUE UNA CLASE SEA JAVA BEAN:
- Tener un constructor sin argumentos.
- Sus atributos de clase deben ser privados y ser accesibles mediante métodos get y set.
- Ser serializable.
 */
public class Ej152 implements Externalizable {
    private String nombre;
    private int nivel;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEsp;
    private int defensaEsp;
    private int velocidad;

    //Constructor con argumentos
    public Ej152(String nombre, int nivel, int vida, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad) {
        setNombre(nombre);
        setNivel(nivel);
        setAtaque(ataque);
        setDefensa(defensa);
        setAtaqueEsp(ataqueEsp);
        setDefensaEsp(defensaEsp);
        setVelocidad(velocidad);
    }

    //Constructor sin argumentos
    public Ej152() {
        this.nombre = "Desconocido";
        this.nivel = 1;
        this.vida = 10;
        this.ataque = 5;
        this.defensa = 5;
        this.ataqueEsp = 5;
        this.defensaEsp = 5;
        this.velocidad = 5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel <1 || nivel>100){
            throw new IllegalArgumentException("El nivel no puede ser inferior a 1 y superior a 100");
        }
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida <0){
            throw new IllegalArgumentException("La vida no puede ser inferior a 0");
        }
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque <0){
            throw new IllegalArgumentException("El ataque no puede ser inferior a 0");
        }
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa <0){
            throw new IllegalArgumentException("La defensa no puede ser inferior a 0");
        }
        this.defensa = defensa;
    }

    public int getAtaqueEsp() {
        return ataqueEsp;
    }

    public void setAtaqueEsp(int ataqueEsp) {
        if (ataqueEsp <0){
            throw new IllegalArgumentException("El ataque especial no puede ser inferior a 0");
        }
        this.ataqueEsp = ataqueEsp;
    }

    public int getDefensaEsp() {
        return defensaEsp;
    }

    public void setDefensaEsp(int defensaEsp) {
        if (defensaEsp <0){
            throw new IllegalArgumentException("La defensa especial no puede ser inferior a 0");
        }
        this.defensaEsp = defensaEsp;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad <0){
            throw new IllegalArgumentException("La velocidad no puede ser inferior a 0");
        }
        this.velocidad = velocidad;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(nombre);
        out.writeInt(nivel);
        out.writeInt(vida);
        out.writeInt(ataque);
        out.writeInt(defensa);
        out.writeInt(ataqueEsp);
        out.writeInt(defensaEsp);
        out.writeInt(velocidad);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setNombre(in.readUTF());
        setNivel(in.readInt());
        setVida(in.readInt());
        setAtaque(in.readInt());
        setDefensa(in.readInt());
        setAtaqueEsp(in.readInt());
        setDefensaEsp(in.readInt());
        setVelocidad(in.readInt());
    }
}
