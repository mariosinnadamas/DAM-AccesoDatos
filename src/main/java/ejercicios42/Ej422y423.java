package ejercicios42;

import java.sql.*;
import java.time.LocalDate;

public class Ej422y423 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        Empleado e = new Empleado(1,"Prueba", "Pruebez", "prueba@correo.com","123456789", LocalDate.now(), "IT_PROG", 1400F, 2,100,10);
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASS)){
            /*
            if (agregarEmpleado(con, e)){
                System.out.println("Empleado agregado con éxito");
            } else {
                System.err.println("Error agregando empleado");
            }
             */
            if (borrarEmpleado(con,e)){
                System.out.println("Empleado borrado con éxito");
            } else{
                System.err.println("Error eliminando al empleado");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Ejercicio 4.2.2
    public static boolean agregarEmpleado(Connection con, Empleado e){
        String sql = "INSERT INTO empleados(id_empleado,nombre,apellido,email,telefono,fecha_contratacion,id_trabajo,salario, comision,id_director,id_departamento) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, e.getId_empleado());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getTelefono());
            ps.setDate(6, Date.valueOf(e.getFecha_contratacion()));
            ps.setString(7, e.getId_trabajo());
            ps.setFloat(8, e.getSalario());
            ps.setFloat(9, e.getComision());
            ps.setInt(10, e.getId_director());
            ps.setInt(11, e.getId_departamento());

            int ejecuciones = ps.executeUpdate();
            return ejecuciones > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //Ejercicio 4.2.3
    public static boolean borrarEmpleado(Connection con, Empleado e){
        String sql = "DELETE FROM empleados WHERE nombre='Prueba'";
        try (PreparedStatement sentencia = con.prepareStatement(sql)){
            sentencia.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
