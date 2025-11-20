package ejercicios41;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ej411 {
    //private static final Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) {
        //String URL = dotenv.get("DB_URL");
        //Conexion para postgresql
        String URL = "jdbc:postgresql://localhost:5432/aprendizaje";
        //Conexion para sqlite
        //String URL2 = "jdbc:sqlite:database.db";
        //String USERNAME = dotenv.get("DB_USERNAME");
        String USERNAME = "alumno";
        //String PASS = dotenv.get("DB_PASS");
        String PASS = "alumno";

        List<Empleado>listaEmpleados = new ArrayList<>();
        Empleado e;
        try(Connection con = DriverManager.getConnection(URL,USERNAME,PASS)){
            try (Statement sentencia = con.createStatement()){
                String consulta = "SELECT * FROM empleados.empleados e " +
                        "JOIN empleados.departamentos d " +
                        "ON e.id_departamento = d.id_departamento " +
                        "WHERE d.nombre_departamento = 'Ventas'";
                try (ResultSet resultado = sentencia.executeQuery(consulta)){
                    while (resultado.next()){
                        int id_empleado = resultado.getInt("id_empleado");
                        String nombre = resultado.getString("nombre");
                        String apellido = resultado.getString("apellido");
                        String email = resultado.getString("email");
                        String telefono = resultado.getString("telefono");
                        LocalDate fecha_contratacion = resultado.getDate("fecha_contratacion").toLocalDate();
                        String id_trabajo = resultado.getString("id_trabajo");
                        float salario = resultado.getFloat("salario");
                        float comision = resultado.getFloat("comision");
                        e = new Empleado(id_empleado,nombre,apellido,email,telefono,fecha_contratacion,id_trabajo,salario,comision);
                        System.out.println(e);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
