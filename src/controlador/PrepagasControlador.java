package controlador;
import modelo.Prepagas;
import vistas.PrepagasVista;
public class PrepagasControlador {
	
	private Prepagas prepagas [] = new Prepagas[15];
	private PrepagasVista prepagasVista = new PrepagasVista();
	
	public void CargarPrepagas() {
		for(int i=0 ; i<prepagas.length ; i++) {
			prepagas[i]=new Prepagas();
			prepagas[i].setIdPrepaga(i);
			String nombre = prepagasVista.setNombre(true);
			while(true) {
				if(repeticionPrepagas(prepagas, nombre)) {
					prepagas[i].setNombre(nombre);
					break;
				}
				else {
					nombre = prepagasVista.setNombre(false);
				}
			}
			prepagas[i].setTopeReintegro(prepagasVista.ingresoTopeReintegro());
			
			String planes [] = new String[prepagas[i].getPlan().length];
			for(int j=0 ; j<planes.length; j++) {
				
				String aNombre=prepagasVista.ingresarPlan(i, true);
				while(true) {
					if(repeticionPlanes(planes, aNombre)) {
						planes[i]=aNombre;
						break;
					}
					else {
						System.out.print("Los planes no pueden repetirse. Ingrese nuevamente: ");
						aNombre= prepagasVista.ingresarPlan(i, false);
					}
				}
			}
			prepagas[i].setPlan(planes);
			
		}
	}
	public static boolean repeticionPrepagas(Prepagas [] prepagas, String p) {
		for(int i=0; i< prepagas.length ; i++) {
			if(prepagas[i]!=null && prepagas[i].getNombre()!=null) {
			if(prepagas[i].getNombre().equals(p)) {
				return false;
			}
			}
		}
		return true;
	}
	private  boolean repeticionPlanes(String [] planes, String aNombre) {
		for(int i=0; i< planes.length ; i++) {
			if(planes[i]!=null) {
			if(planes[i].equals(aNombre)) {
				return false;
			}
			}
		}
		return true;
	}
}
