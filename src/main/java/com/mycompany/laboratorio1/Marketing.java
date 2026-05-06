package com.mycompany.laboratorio1;

public class Marketing extends Empleado {

    int horario;
    double sueldoFijo = 50000;

    public Marketing(int legajo, String apellido, String nombre, String fechaNacimiento,
                     String telefono, String direccion, String mail,
                     int horario) {

        super(legajo, apellido, nombre, fechaNacimiento,
              telefono, direccion, mail);

        this.horario = horario;
    }

    @Override
    public double calcularSueldoBruto() {
        return sueldoFijo;
    }
}