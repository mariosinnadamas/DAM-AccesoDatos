package ejercicios12;

public class Ejercicio3 {
    /*Producirá si o si el print del finally.
    Además, como hereda de la clase exception imprimirá el print
    del catch
     */
    public static void main(String[] args) {

        class Prueba extends Exception { }
        class Main {
            public static void main(String args[]) {
                try {
                    throw new Prueba();
                }
                catch(Prueba ex) {
                    System.out.println("Se produjo una excepción Prueba.");
                }
                finally {
                    System.out.println("Estoy dentro del bloque finally.");
                }
            }
        }
    }
}
