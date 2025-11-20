package ejercicios42;

import java.sql.*;

public class EjemploPreparedStatement {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        try(Connection conexion = DriverManager.getConnection(URL, USERNAME, PASS)) {
            // Consulta con un único placeholder.
            String consulta = "SELECT nombre, apellido, salario FROM empleados WHERE id_departamento = ?";
            try(PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
                // asignamos parámetros a los placeholders, coloca un 10 en el primer ? usando un tipo INT
                sentencia.setInt(1, 10);
                // La ejecutamos SIN PASAR LA CONSULTA COMO PARÁMETRO.
                try(ResultSet resultado = sentencia.executeQuery()) {
                    while (resultado.next()) {
                        String nombre = resultado.getString("nombre");
                        String apellido = resultado.getString("apellido");
                        float salario = resultado.getFloat("salario");
                        System.out.println(nombre + " " + apellido + " " + salario);
                    }
                } catch (SQLException ex) {
                    System.out.println("ERROR: no se pudo ejecutar la consulta solicitada.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: no se pudo acceder a la base de datos Empleados.");
        }
    }
}
