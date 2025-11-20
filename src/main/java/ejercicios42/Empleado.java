package ejercicios42;

import java.time.LocalDate;

public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fecha_contratacion;
    private String id_trabajo;
    private float salario;
    private float comision;
    private int id_director;
    private int id_departamento;

    //Constructor para el ejercicio 4.1.1
    public Empleado(int id_empleado, String nombre, String apellido, String email, String telefono, LocalDate fecha_contratacion, String id_trabajo, float salario, float comision, int id_director, int id_departamento) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_contratacion = fecha_contratacion;
        this.id_trabajo = id_trabajo;
        this.salario = salario;
        this.comision = comision;
        this.id_director = id_director;
        this.id_departamento = id_departamento;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(LocalDate fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(String id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
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
        return texto;
    }
}
