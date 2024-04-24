package controlador;
import modelo.Sucursales;
import vistas.*;
public class SucursalesControlador {

	private SucursalesVista sucursalesVista = new SucursalesVista();
	private Sucursales sucursales[] = new Sucursales[10];
	public void CargarSucursales(){
		for(int i=0 ; i<sucursales.length ; i++) {
			sucursales[i]=new Sucursales();
			sucursales[i].setIdSucursal(i);
			String nombre = sucursalesVista.setNombre(true);
			while(true) {
				if(repeticionSucursales(sucursales, nombre)) {
					sucursales[i].setNombre(nombre);
					break;
				}
				else {
					nombre = sucursalesVista.setNombre(false);
				}
			}
			sucursales[i].setProvincia(sucursalesVista.setProvincia());
			sucursales[i].setLocalidad(sucursalesVista.setLocalidad());
		}
		
	}
	private  boolean repeticionSucursales(Sucursales [] sucursales, String nombre) {
		for(int i=0; i< sucursales.length ; i++) {
			if(sucursales[i]!=null && sucursales[i].getNombre()!=null) {
				if(sucursales[i].getNombre().equals(nombre)) {
				return false;
				}
		}
		}
		return true;
	}
}
