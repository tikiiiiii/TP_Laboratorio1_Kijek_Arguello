package com.mycompany.laboratorio1;

public class Vendedor extends Empleado {

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
    public double calcularSueldoBruto() {
        return sueldoBase + (ventasMes * 0.002);
    }
}