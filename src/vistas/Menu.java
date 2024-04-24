package vistas;
import controlador.*;
import java.util.*;

public class Menu {
	
	
	public void mostrarMenu() {
	Scanner scanner = new Scanner(System.in);
	Validaciones validaciones = new Validaciones();
	ClientesControlador clientesControlador = new ClientesControlador();
	SucursalesControlador sucursalesControlador = new SucursalesControlador();
	PrepagasControlador prepagasControlador = new PrepagasControlador();
	TratamientosControlador tratamientosControlador = new TratamientosControlador();
	
	do {
		System.out.println("1-Para cargar las sucursales");
		System.out.println("2-Para cargar las Prepagas");
		System.out.println("3-Para cargar los Tratamientos");
		System.out.print(": ");
		int opcion = validaciones.validarInt();
		switch(opcion) {
		case 1: sucursalesControlador.CargarSucursales(); break;
		case 2: prepagasControlador.CargarPrepagas();break;
		case 3: tratamientosControlador.cargarTratamientos();break;
		}
	}
	while(true);

	}
}

