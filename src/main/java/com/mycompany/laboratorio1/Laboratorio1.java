package com.mycompany.laboratorio1;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Empleado {

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

    abstract double calcularSueldoBruto();

    public double calcularSueldoNeto() {
        double bruto = calcularSueldoBruto();
        return bruto * 0.81;
    }

    public void mostrarDatos() {
        System.out.println("Legajo: " + legajo);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Mail: " + mail);
    }
}

class Operario extends Empleado {

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
    double calcularSueldoBruto() {
        return horasTrabajadas * valorHora;
    }
}

class Marketing extends Empleado {

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
    double calcularSueldoBruto() {
        return sueldoFijo;
    }
}

class Vendedor extends Empleado {

    String medioVenta;
    double ventasMes;
    double sueldoBase = 30000;

    public Vendedor(int legajo, String apellido, String nombre, String fechaNacimiento,
                    String telefono, String direccion, String mail,
                    String medioVenta, double ventasMes) {

        super(legajo, apellido, nombre, fechaNacimiento,
                telefono, direccion, mail);

        this.medioVenta = medioVenta;
        this.ventasMes = ventasMes;
    }

    @Override
    double calcularSueldoBruto() {
        return sueldoBase + (ventasMes * 0.002);
    }
}

public class Laboratorio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Empleado> empleados = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

            System.out.println("Tipo de empleado:");
            System.out.println("1 Operario");
            System.out.println("2 Marketing");
            System.out.println("3 Vendedor");

            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("Legajo: ");
            int legajo = sc.nextInt();
            sc.nextLine();

            System.out.print("Apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Fecha nacimiento: ");
            String fecha = sc.nextLine();

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Direccion: ");
            String direccion = sc.nextLine();

            System.out.print("Mail: ");
            String mail = sc.nextLine();

            switch (tipo) {

                case 1:

                    System.out.print("Area: ");
                    String area = sc.nextLine();

                    System.out.print("Puesto: ");
                    String puesto = sc.nextLine();

                    System.out.print("Horas trabajadas: ");
                    int horas = sc.nextInt();

                    empleados.add(new Operario(
                            legajo, apellido, nombre, fecha,
                            telefono, direccion, mail,
                            area, puesto, horas));

                    break;

                case 2:

                    System.out.print("Horario (1 mañana / 2 tarde): ");
                    int horario = sc.nextInt();

                    empleados.add(new Marketing(
                            legajo, apellido, nombre, fecha,
                            telefono, direccion, mail,
                            horario));

                    break;

                case 3:

                    System.out.print("Medio de venta: ");
                    sc.nextLine();
                    String medio = sc.nextLine();

                    System.out.print("Ventas del mes: ");
                    double ventas = sc.nextDouble();

                    empleados.add(new Vendedor(
                            legajo, apellido, nombre, fecha,
                            telefono, direccion, mail,
                            medio, ventas));

                    break;

                default:
                    System.out.println("Tipo inválido");
            }
        }

        for (Empleado e : empleados) {

            System.out.println("\n--- EMPLEADO ---");

            e.mostrarDatos();

            System.out.println("Sueldo bruto: " + e.calcularSueldoBruto());

            System.out.println("Sueldo neto: " + e.calcularSueldoNeto());
        }

        sc.close();
    }
}