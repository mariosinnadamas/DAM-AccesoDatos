package ejercicios43;

import com.sun.source.tree.Tree;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ej433 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";
        try (Connection con = DriverManager.getConnection(URL,USERNAME,PASS)){
            Set<Integer>listaLocalizaciones= new HashSet<>();
            try (Statement st = con.createStatement();
            ResultSet rsLoc = st.executeQuery("SELECT * FROM localizaciones")){
                while (rsLoc.next()){
                    listaLocalizaciones.add(rsLoc.getInt("id_localizacion"));
                }
            }
            Set<Integer>listaDepartamentos= new HashSet<>();
            try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM departamentos")){
                while (rs.next()){
                    listaDepartamentos.add(rs.getInt("id_departamento"));
                }
            }

            System.out.println("Lista de ID de localizaciones");
            listaLocalizaciones.forEach(System.out::println);
            System.out.println("Lista de ID de departamentos");
            listaDepartamentos.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
