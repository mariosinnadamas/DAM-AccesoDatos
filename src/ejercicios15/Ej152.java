package ejercicios15;
/*
Completa la clase Pokemon para que sea un Java Bean que permita almacenar
los siguientes atributos.
Debes controlar los valores de los parámetros, gestionar posibles errores, etc.
La clase Pokemon debe implementar Externalizable.
 */
import java.io.Serializable;
/*CONDICIONES PARA QUE UNA CLASE SEA JAVA BEAN:
- Tener un constructor sin argumentos.
- Sus atributos de clase deben ser privados y ser accesibles mediante métodos get y set.
- Ser serializable.
 */
public class Ej152 implements Serializable {
    private String nombre;
    private int nivel;
    private int vida;
    private double ataque;
    private double defensa;
    private double ataqueEsp;
    private double defensaEsp;
    private double velocidad;

    public Ej152() {
    }
}
