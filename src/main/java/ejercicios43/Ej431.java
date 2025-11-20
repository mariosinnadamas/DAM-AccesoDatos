package ejercicios43;

import java.sql.*;

public class Ej431 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        String query = "SELECT * FROM empleados ORDER BY id_departamento";
        int contador = 0;
        int inicio = 0;
        int fin = 0;

        try (Connection con = DriverManager.getConnection(URL, USERNAME,PASS);
             Statement sentencencia = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet resultado = sentencencia.executeQuery(query)){
            while (resultado.next()){
                contador++;
                String nombre = resultado.getString("nombre");
                int id_departamento = resultado.getInt("id_departamento");

                if (id_departamento == 30){
                    if (inicio == 0){
                        inicio = contador;
                    }
                    System.out.println(nombre + " " + id_departamento + " posicion: " + contador);
                    fin = contador;
                }
            }
            for (int i = fin; i >= inicio ; i--) {
                resultado.absolute(i);
                String nombre = resultado.getString("nombre");
                int id_departamento = resultado.getInt("id_departamento");
                System.out.println(nombre + " " + id_departamento);
            }
            System.out.println("Los empleados del departamento 30 comienzan en " + inicio + " y finalizan en " + fin);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
