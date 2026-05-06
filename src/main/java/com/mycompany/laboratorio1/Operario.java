package com.mycompany.laboratorio1;

public class Operario extends Empleado {

    String area;
    String puesto;
    int horasTrabajadas;
    double valorHora = 120;

    public Operario(int legajo, String apellido, String nombre, String fechaNacimiento,
                    String telefono, String direccion, String mail,
                    String area, String puesto, int horasTrabajadas) {

        super(legajo, apellido, nombre, fechaNacimiento,
              telefono, direccion, mail);

        this.area = area;
        this.puesto = puesto;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldoBruto() {
        return horasTrabajadas * valorHora;
    }
}