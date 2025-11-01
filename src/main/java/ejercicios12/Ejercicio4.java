package ejercicios12;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*
        Con la excepcion Base ya estarias capturando la derivada, de hecho
        la propia ide nos dice que eliminemos ese bloque del catch ya que
        ya está siendo capturado por la Excepcion Base
         */
        /*class Base extends Exception {}
        class Derivada extends Base {}

        public class Main {
            public static void main(String args[]) {

                try {
                    throw new Derivada();
                }
                catch(Base b) {
                    System.out.println("Capturada excepción Base.");
                }
                catch(Derivada d) {
                    System.out.println("Capturada excepción Derivada.");
                }
            }
        }*/
    }
}
