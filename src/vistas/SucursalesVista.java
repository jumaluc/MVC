package vistas;
import java.util.*;
import controlador.SucursalesControlador;
public class SucursalesVista {
	Validaciones validaciones = new Validaciones();
	
	public String setNombre(boolean a) {
		Scanner scanner = new Scanner(System.in);
		String nombre = "";
		if(a) {
		System.out.print("Ingresar el nombre de la sucursal (no se pueden repetir): ");
		 nombre = validaciones.validarString();
		}
		else {
			System.out.print("No se pueden repetir, ingrese nuevamente: ");
			 nombre = validaciones.validarString();
		}
		return nombre;
		
	}
	public String setProvincia(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresar la provincia de la sucursal: ");
		String provincia = validaciones.validarString();
		return provincia;
	}
	public String setLocalidad(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresar la localidad de la sucursal: ");
		String localidad = validaciones.validarString();
		return localidad;
	}
}
