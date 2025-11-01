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
    private Empleado director; //Para llamar al toString del director y modificar el inicio de la cadena

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

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    @Override
    public String toString() {
        String texto = "id_empleado=" + id_empleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_contratacion='" + fecha_contratacion + '\'' +
                ", id_trabajo='" + id_trabajo + '\'' +
                ", salario=" + salario +
                ", comision=" + comision;

        if (nombre_departamento != null) {
            texto += ", nombre_departamento='" + nombre_departamento + '\'';
        }

        if (director != null) {
            texto += "\n——Datos director——\n" +
                    director.toString() +
                    "\n——Fin DD——";
        }
        return texto;
    }
}
