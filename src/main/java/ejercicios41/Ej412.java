package ejercicios41;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ej412 {
    private static final Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) {
        String URL = dotenv.get("DB_URL");
        String USERNAME = dotenv.get("DB_USERNAME");
        String PASS = dotenv.get("DB_PASS");

        List<Empleado> listaEmpleados = new ArrayList<>();
        Empleado empleado;
        try(Connection con = DriverManager.getConnection(URL,USERNAME,PASS);
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT *,nombre_departamento FROM empleados e JOIN departamentos d ON d.id_departamento = e.id_departamento WHERE d.nombre_departamento = 'Marketing' OR d.nombre_departamento='Ejecutivo'")){
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
                String nombre_departamento = resultado.getString("nombre_departamento");
                empleado = new Empleado(id_empleado,nombre,apellido,email,telefono,fecha_contratacion,id_trabajo,salario,comision,nombre_departamento);
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Empleado temp: listaEmpleados){
            System.out.println(temp);
        }
    }
}
