package com.mycompany.laboratorio1;

public abstract class Empleado {
    int legajo;
    String apellido;
    String nombre;
    String fechaNacimiento;
    String telefono;
    String direccion;
    String mail;

    public Empleado(int legajo, String apellido, String nombre, String fechaNacimiento,
                    String telefono, String direccion, String mail) {

        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mail = mail;
    }

    public abstract double calcularSueldoBruto();

    public double calcularSueldoNeto() {
        return calcularSueldoBruto() * 0.81;
    }

    public void mostrarDatos() {
        System.out.println("Legajo: " + legajo);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Mail: " + mail);
    }
}