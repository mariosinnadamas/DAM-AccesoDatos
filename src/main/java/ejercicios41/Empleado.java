package ejercicios41;

public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fecha_contratacion;
    private String id_trabajo;
    private double salario;
    private String comision;
    //Ejercicio 4.1.2
    private String nombre_departamento;
    //Ejercicio 4.1.3
    private String id_director;

    public Empleado() {

    }
    //Constructor para el ejercicio 4.1.1
    public Empleado(int id_empleado, String nombre, String apellido, String email, String telefono, String fecha_contratacion, String id_trabajo, double salario, String comision) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_contratacion = fecha_contratacion;
        this.id_trabajo = id_trabajo;
        this.salario = salario;
        this.comision = comision;
    }

    //Constructor ejercicio 4.1.2
    public Empleado(int id_empleado, String nombre, String apellido, String email, String telefono, String fecha_contratacion, String id_trabajo, double salario, String comision, String nombre_departamento) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_contratacion = fecha_contratacion;
        this.id_trabajo = id_trabajo;
        this.salario = salario;
        this.comision = comision;
        this.nombre_departamento = nombre_departamento;
    }

    //Constructor para el ejercicio 4.1.3
    public Empleado(int id_empleado, String nombre, String apellido, String email, String telefono, String fecha_contratacion, String id_trabajo, double salario, String comision, String nombre_departamento, String id_director) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_contratacion = fecha_contratacion;
        this.id_trabajo = id_trabajo;
        this.salario = salario;
        this.comision = comision;
        this.nombre_departamento = nombre_departamento;
        this.id_director = id_director;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id_empleado=").append(id_empleado)
                .append(", nombre=").append(nombre).append('\'')
                .append(",apellido=").append(apellido).append('\'')
                .append(", email=").append(email).append('\'')
                .append(", telefono=").append(telefono).append('\'')
                .append(", fecha_contratacion=").append(fecha_contratacion).append('\'')
                .append(", id_trabajo=").append(id_trabajo).append('\'')
                .append(", salario=").append(salario).append('\'')
                .append(", comision=").append(comision).append('\'');
        if (nombre_departamento != null){
            sb.append(", nombre_departamento=").append(nombre_departamento).append('\'');
        }
        return sb.toString();
    }
}
