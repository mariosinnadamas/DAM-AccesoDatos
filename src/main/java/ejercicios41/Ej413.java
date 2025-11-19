package ejercicios41;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Ej413 {
    //private static final Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) {
        //String URL = dotenv.get("DB_URL");
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        //String USERNAME = dotenv.get("DB_USERNAME");
        String USERNAME = "alumno";
        //String PASS = dotenv.get("DB_PASS");
        String PASS = "alumno";

        try (Connection con = DriverManager.getConnection(URL, USERNAME,PASS);
             Statement sentencia = con.createStatement();
             //Ahora mismo solo estoy sacando los directores de cada departamento
             ResultSet resultado = sentencia.executeQuery("SELECT e.*, dep.nombre_departamento, " +
                            "d.id_empleado AS id_dir, " +
                            "d.nombre AS nombre_dir, " +
                            "d.apellido AS apellido_dir, " +
                            "d.email AS email_dir, " +
                            "d.telefono AS telefono_dir, " +
                            "d.fecha_contratacion AS fecha_dir, " +
                            "d.id_trabajo AS id_trabajo_dir, " +
                            "d.salario AS salario_dir, " +
                            "d.comision AS comision_dir " +
                            "FROM empleados e " +
                            "LEFT JOIN empleados d ON e.id_director = d.id_empleado " +
                            "LEFT JOIN departamentos dep ON e.id_departamento = dep.id_departamento")){
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
                    //Recojo los datos y creo los jefes
                    Empleado empleado = new Empleado(id_empleado,nombre,apellido,email,telefono,fecha_contratacion,
                            id_trabajo,salario,comision,nombre_departamento);

                    // Y ahora creo los empleados
                    int idDirector = resultado.getInt("id_dir"); //Esto aqui porque puede ser nulo
                    if (!resultado.wasNull()) {
                        Empleado director = new Empleado(idDirector,
                                resultado.getString("nombre_dir"),
                                resultado.getString("apellido_dir"),
                                resultado.getString("email_dir"),
                                resultado.getString("telefono_dir"),
                                resultado.getString("fecha_dir"),
                                resultado.getString("id_trabajo_dir"),
                                resultado.getDouble("salario_dir"),
                                resultado.getString("comision_dir"),
                                nombre_departamento
                        );
                        empleado.setDirector(director);
                    }

                    System.out.println(empleado);

                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
