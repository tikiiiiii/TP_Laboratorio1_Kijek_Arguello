package com.mycompany.laboratorio1;

import java.util.Scanner;
import java.util.ArrayList;

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