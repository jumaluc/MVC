package vistas;

public class TratamientosVista {

	Validaciones val = new Validaciones();
	
	public int setMaximoSesiones() {
		System.out.println("Ingrese la cantidad maxima de sesiones: ");
		return val.validarInt();
	}
	public String setNombre(boolean a) {
		String nombre = "";
		if(a) {
			System.out.println("Ingrese el nombre del tratamiento: ");
			nombre = val.validarString();
		}
		else {
			System.out.println("No se puede ingresar el mismo nombre, Ingrese nuevamente: ");
			nombre = val.validarString();
		}
		return nombre;
	}
	public double setPrecio() {
		System.out.println("Ingrese el precio del tratamiento: ");
		return val.validarDouble();
	}
	public boolean setInyectable() {
		while(true) {
			System.out.print("Es inyectable? (si/no): ");
			String a= val.validarString().toLowerCase();
			if(a.equals("si")) {
				return true;
				
			}
			else if(a.equals("no")) {
				return false;
				
			}
			else {
				System.out.println("si o no: ");
			}
		}
	}
	public char setTipoTratamiento() {
		System.out.print("Tipo de tratamiento. 'f' para faciales, 'c' para corporales, 's' para salud: ");
		while (true) {
			char letraTratamiento = Character.toLowerCase(val.validarChar());
			if(letraTratamiento=='f' || letraTratamiento=='c' || letraTratamiento=='s') {
				return letraTratamiento;
				
			}
			else {
				System.out.println("'f'/'c'/'s': ");
			}
		}
	}
}
