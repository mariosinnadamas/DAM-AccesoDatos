package ejercicios41;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Ej413 {
    private static final Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) {
        String URL = dotenv.get("DB_URL");
        String USERNAME = dotenv.get("DB_USERNAME");
        String PASSWORD = dotenv.get("DB_PASS");

        Empleado empleado;
        try (Connection con = DriverManager.getConnection(URL, USERNAME,PASSWORD);
             Statement sentencia = con.createStatement();
             //Ahora mismo solo estoy sacando los directores de cada departamento
             ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados e JOIN departamentos d on d.id_director = e.id_empleado")){
                while (resultado.next()){
                    int id_empleado = resultado.getInt("id_empleado");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    String email = resultado.getString("email");
                    String telefono = resultado.getString("telefono");
                    String fecha_contratacion = resultado.getString("fecha_contratacion");
                    String id_trabajo = resultado.getString("id_trabajo");
                    double salario = resultado.getDouble("salario");
                    String comision = resultado.getString("comision");
                    empleado = new Empleado(id_empleado,nombre,apellido,email,telefono,fecha_contratacion,id_trabajo,salario,comision);
                    System.out.println(empleado);
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
