package ejercicios12;

public class Ejercicio5 {
    /*
    Imprime a, imprime la excepción de que no se puede divir entre 0
    y por último muestra el bloque finally
     */
    public static void main(String[] args) {
        try {
            int a = 0;
            System.out.println("a = " + a);
            int b = 20 / a;
            System.out.println("b = " + b);
        }
        catch(ArithmeticException e) {
            System.out.println ("Error al dividir entre cero.");
        }
        finally {
            System.out.println ("Estoy dentro del bloque finally.");
        }
    }
}
