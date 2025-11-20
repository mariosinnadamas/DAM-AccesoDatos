package ejercicios43;

import java.sql.*;

public class Ej432 {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=empleados";
        final String USERNAME = "alumno";
        final String PASS = "alumno";

        String sql = "SELECT * FROM empleados e JOIN trabajos t on t.id_trabajo=e.id_trabajo";
        String sql2 = "";
        try (Connection con = DriverManager.getConnection(URL,USERNAME,PASS);
             Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = sentencia.executeQuery(sql)) {

                while (rs.next()){
                    double salario = rs.getFloat("salario");
                    if (salario%2==0){
                        salario *=2;
                    } else {
                        salario/=2;
                    }
                    rs.updateDouble("salario", salario);
                    rs.updateRow();
                }

                rs.beforeFirst();

                while (rs.next()){
                    float salario = rs.getFloat("salario");
                    String id_trabajo = rs.getString("id_trabajo");
                    System.out.println(salario + " " + id_trabajo);
                    switch (id_trabajo) {
                        case "AD_PRES": // Presidente
                            if (salario < 20000.0) {
                                rs.updateDouble("salario", 20000.0);
                                rs.updateRow();
                            } else if (salario > 40000.0) {
                                rs.updateDouble("salario", 40000.0);
                                rs.updateRow();
                            }
                            break;

                        case "AD_VP": // Vicepresidente
                            if (salario < 20000.0) {
                                rs.updateDouble("salario", 20000.0);
                                rs.updateRow();
                            } else if (salario > 40000.0) {
                                rs.updateDouble("salario", 40000.0);
                                rs.updateRow();
                            }
                            break;

                        case "AD_ASST": // Asistente de administración
                            if (salario < 3000.0) {
                                rs.updateDouble("salario", 3000.0);
                                rs.updateRow();
                            } else if (salario > 6000.0) {
                                rs.updateDouble("salario", 6000.0);
                                rs.updateRow();
                            }
                            break;

                        case "AC_MGR": // Director de contabilidad
                            if (salario < 8200.0) {
                                rs.updateDouble("salario", 8200.0);
                                rs.updateRow();
                            } else if (salario > 16000.0) {
                                rs.updateDouble("salario", 16000.0);
                                rs.updateRow();
                            }
                            break;

                        case "AC_ACCOUNT": // Contable
                            if (salario < 4200.0) {
                                rs.updateDouble("salario", 4200.0);
                                rs.updateRow();
                            } else if (salario > 9000.0) {
                                rs.updateDouble("salario", 9000.0);
                                rs.updateRow();
                            }
                            break;

                        case "SA_MAN": // Director de ventas
                            if (salario < 10000.0) {
                                rs.updateDouble("salario", 10000.0);
                                rs.updateRow();
                            } else if (salario > 20000.0) {
                                rs.updateDouble("salario", 20000.0);
                                rs.updateRow();
                            }
                            break;

                        case "SA_REP": // Representante de ventas
                            if (salario < 6000.0) {
                                rs.updateDouble("salario", 6000.0);
                                rs.updateRow();
                            } else if (salario > 12000.0) {
                                rs.updateDouble("salario", 12000.0);
                                rs.updateRow();
                            }
                            break;

                        case "ST_MAN": // Director de almacén
                            if (salario < 5500.0) {
                                rs.updateDouble("salario", 5500.0);
                                rs.updateRow();
                            } else if (salario > 8500.0) {
                                rs.updateDouble("salario", 8500.0);
                                rs.updateRow();
                            }
                            break;

                        case "ST_CLERK": // Empleado de almacén
                            if (salario < 2000.0) {
                                rs.updateDouble("salario", 2000.0);
                                rs.updateRow();
                            } else if (salario > 5000.0) {
                                rs.updateDouble("salario", 5000.0);
                                rs.updateRow();
                            }
                            break;

                        case "IT_PROG": // Programador
                            if (salario < 4000.0) {
                                rs.updateDouble("salario", 4000.0);
                                rs.updateRow();
                            } else if (salario > 10000.0) {
                                rs.updateDouble("salario", 10000.0);
                                rs.updateRow();
                            }
                            break;

                        case "MK_MAN": // Director de marketing
                            if (salario < 9000.0) {
                                rs.updateDouble("salario", 9000.0);
                                rs.updateRow();
                            } else if (salario > 15000.0) {
                                rs.updateDouble("salario", 15000.0);
                                rs.updateRow();
                            }
                            break;

                        case "MK_REP": // Representante de marketing
                            if (salario < 4000.0) {
                                rs.updateDouble("salario", 4000.0);
                                rs.updateRow();
                            } else if (salario > 9000.0) {
                                rs.updateDouble("salario", 9000.0);
                                rs.updateRow();
                            }
                            break;

                        default:
                            // Por si hay trabajos que no estén en la lista
                            break;
                    }
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
