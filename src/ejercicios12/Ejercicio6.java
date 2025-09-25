package ejercicios12;

public class Ejercicio6 {
    /*
        El contador mostrará 5, eso se debe a que el ultimo catch no entrará
        y no sumará 1 en el contador. Eso es porque está fuera el try.
     */
    int contador = 0;
    void excepcionesAnidadas() throws Exception {
        try {
            contador++;

            try {
                contador++;

                try {
                    contador++;
                    throw new Exception();
                } catch (Exception ex) {
                    contador++;
                    throw new Exception();
                }
            }
            catch(Exception ex) {
                contador++;
            }
        }
        catch(Exception ex) {
            contador++;
        }
    }

    void mostrar() {
        System.out.println(contador);
    }
    public static void main(String[] args) throws Exception {
        Ejercicio6 objPru = new Ejercicio6();
        objPru.excepcionesAnidadas();
        objPru.mostrar();
    }

}
