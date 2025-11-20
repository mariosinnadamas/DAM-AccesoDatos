package ejercicios42;

import ejercicios41.Empleado;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Ej421 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        String nombre_dept = "Ventas";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASS)){
            String consulta = "SELECT e.nombre, e.apellido, d.nombre_departamento FROM empleados e JOIN departamentos d ON d.id_departamento=e.id_departamento WHERE d.nombre_departamento = ?";
            try (PreparedStatement sentencia = con.prepareStatement(consulta)){
                sentencia.setString(1,nombre_dept);
                try (ResultSet resultado = sentencia.executeQuery()){
                    while (resultado.next()){
                        String nombre = resultado.getString("nombre");
                        String apellido = resultado.getString("apellido");
                        String nombre_departamento = resultado.getString("nombre_departamento");
                        System.out.println(nombre + " " + apellido + " " + nombre_departamento);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
