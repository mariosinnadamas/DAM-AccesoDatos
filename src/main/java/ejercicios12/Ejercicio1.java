package ejercicios12;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Da un error aritmético
       int resultado = 0;
        try {
            int n1 = 2, n2 = 0;
            resultado = n1/n2;
        } catch (ArithmeticException e) {
            System.err.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Resultado: " + resultado);
        }
    }
}
