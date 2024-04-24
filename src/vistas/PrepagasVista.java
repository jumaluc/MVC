package vistas;

public class PrepagasVista {
	
	Validaciones validaciones = new Validaciones();
	public String setNombre(boolean a) {
		String nombre = "";
		if(a) {
		System.out.println("Ingrese el nombre de la prepaga: ");
		 nombre = validaciones.validarString();
		}
		else {
			System.out.println("El nombre no puede repetirse, ingrese nuevamente: ");
			nombre = validaciones.validarString();
		}
		return nombre;
	}
	public double ingresoTopeReintegro() {
		System.out.println("Ingrese el tope de reintregro de la prepaga: ");
		double reintegro = validaciones.validarDouble();
		return reintegro;
	}
	public String  ingresarPlan(int a, boolean b) {
		String nombre = "";
		if(b) {
		System.out.printf("Plan %d: ",a);
		nombre = validaciones.validarString();
		}
		else {
			System.out.println("Los planes no pueden repetirse, Ingresa nuevamente: ");
			nombre = validaciones.validarString();
		}
		return nombre;
	}
}
