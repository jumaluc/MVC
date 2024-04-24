package controlador;
import modelo.Tratamientos;
import vistas.TratamientosVista;

public class TratamientosControlador {
	
	private Tratamientos tratamientos [] = new Tratamientos[10];
	private TratamientosVista tratV = new TratamientosVista();
	
	public void cargarTratamientos() {
		for(int i = 0 ; i < tratamientos.length ; i++) {
			
			tratamientos[i].setIdTratamientos(i);
			
			String nombre = tratV.setNombre(true);
			while(true) {
				if(repeticionTratamientos(tratamientos, nombre)) {
					tratamientos[i].setNombre(nombre);
					break;
				}
				else {
					nombre = tratV.setNombre(false);
				}
			}
			tratamientos[i].setMaximoSesiones(tratV.setMaximoSesiones());
			tratamientos[i].setPrecio(tratV.setPrecio());
			tratamientos[i].setInyectable(tratV.setInyectable());
			tratamientos[i].setTipoTratamiento(tratV.setTipoTratamiento());
		}
	}
	private  boolean repeticionTratamientos(Tratamientos [] tratamientos, String aNombre) {
		for(int i=0; i< tratamientos.length ; i++) {
			if(tratamientos[i]!=null && tratamientos[i].getNombre()!=null) {
			if(tratamientos[i].getNombre().equals(aNombre)) {
				return false;
			}
		}
		}
		return true;
	}
}
