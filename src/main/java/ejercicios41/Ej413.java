package ejercicios41;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Ej413 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASS);
             //Esto permite que pueda volver al inicio, ya que de manera predeterminada está configurado para solo poder ir hacia delante
             Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

             ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados")) {

            //Mapa donde guardo mis empleados por ID
            Map<Integer, Empleado> empleadosMap = new HashMap<>();

            while (resultado.next()) {
                //Creamos todos los empleados sin jefe
                int id = resultado.getInt("id_empleado");

                Empleado e = new Empleado(id,
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("email"),
                        resultado.getString("telefono"),
                        resultado.getDate("fecha_contratacion").toLocalDate(),
                        resultado.getString("id_trabajo"),
                        resultado.getFloat("salario"),
                        resultado.getFloat("comision"));
                empleadosMap.put(id, e);
            }

            //Vuelves al inicio del resultSet para hacer una segunda pasada
            resultado.beforeFirst();

            while (resultado.next()){
                int idEmpleado = resultado.getInt("id_empleado");
                int idDirector = resultado.getInt("id_director");

                if (!resultado.wasNull()) {   // si el director NO ES NULL
                    Empleado empleado = empleadosMap.get(idEmpleado);
                    Empleado jefe = empleadosMap.get(idDirector);

                    empleado.setJefe(jefe);
                }
            }

            for (Empleado e : empleadosMap.values()){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


