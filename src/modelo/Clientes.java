package modelo;

import java.util.*;

public  class Clientes implements ICalculable {
	protected String nombre ;
	protected int numeroDocumento ;
	protected String  objetivo ;
	protected Calendar fechaNacimiento ;
	protected Calendar fechaInicio ;
	protected Sucursales sucursales[] ;
	protected TratamientosPersonales tratamientos[] = new TratamientosPersonales[10];
	protected char formaPago;

	 public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Sucursales[] getSucursales() {
		return sucursales;
	}

	public void setSucursales(Sucursales[] sucursales) {
		this.sucursales = sucursales;
	}

	public TratamientosPersonales[] getTratamientosP() {
		return tratamientos;
	}
	public void setTratamientosPCantidadSesiones( int c, int p) {
		tratamientos[p].setCantidadSesiones(c);
	}
	public void setTratamientosP(Tratamientos t, int p) {
		tratamientos[p].setTratamientos(t);
	}
	public void createTratamientosP(Tratamientos t,boolean b, int p) {
		if(b) {
			tratamientos[p] = new Salud();
			
		}
		else {
			tratamientos[p] = new TratamientosPersonales();
		}
		tratamientos[p].setTratamientos(t);
	}
	

	public char getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(char formaPago) {
		this.formaPago = formaPago;
	}
	
	
	public class ConPrepagas{
		private Prepagas prepaga;
		private String numeroAfiliado;
		
		public Prepagas getPrepaga() {
			return prepaga;
		}

		public void setPrepaga(Prepagas prepaga) {
			this.prepaga = prepaga;
		}

		public String getNumeroAfiliado() {
			return numeroAfiliado;
		}

		public void setNumeroAfiliado(String numeroAfiliado) {
			this.numeroAfiliado = numeroAfiliado;
		}


		ConPrepagas(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
				Sucursales[] sucursales, char formaPago, Prepagas prepaga, String numeroAfiliado){
			super();
			this.prepaga=prepaga;
			this.numeroAfiliado=numeroAfiliado;
	}
		ConPrepagas(){};
		
		public double calcularCosto() {
			double total=0;
			double a=0;
			for(int i=0 ; i<tratamientos.length ; i++) {
				if(tratamientos[i] instanceof Salud) {
					a=a+((Salud)tratamientos[i]).calcularCostoTratamiento();
				}
				else {
					a+=tratamientos[i].calcularCostoTratamiento();
				}
			}
			total=a-prepaga.getTopeReintegro();
			
			return total;
		}


		public void supereTopeReintegro() {
			if(calcularCosto()+prepaga.getTopeReintegro() > prepaga.getTopeReintegro()) {
				System.out.println("Nombre: "+nombre);
				System.out.println("Numero de Documento: "+numeroDocumento);
				System.out.println("Fecha de Nacimiento: "+fechaNacimiento.get(Calendar.DATE)+"/"+(fechaNacimiento.get(Calendar.MONTH))+1+"/"+fechaNacimiento.get(Calendar.YEAR));
				System.out.println("Forma de pago: "+formaPago);
				System.out.println("Nombre de la prepaga: "+prepaga.getNombre());
				System.out.println("Costo total del tratamiento: "+calcularCosto()+prepaga.getTopeReintegro());
				System.out.println("Tope de reintegro: "+prepaga.getTopeReintegro());
				System.out.println("Valor realmente abonado: "+calcularCosto());
			}		
		}
	}
	
	public class Particulares {
		private double descuento;
		private static int cantidadClientesParticulares;
		
		
		public static int  getCantidadClientesParticulares() {
			return cantidadClientesParticulares;
		}

		public static void setCantidadClientesParticulares(int cantidadClientesParticulares) {
			Particulares.cantidadClientesParticulares = cantidadClientesParticulares;
		}

		public double getDescuento() {
			return descuento;
		}

		public void setDescuento(double descuento) {
			this.descuento = descuento;
		}

		Particulares(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
				Sucursales[] sucursales,  char formaPago, double descuento){
			super();
			this.descuento=descuento;
		}
		Particulares(){};
		
		public double calcularCosto() {
			double total=0;
			double a=0;
			for(int i=0 ; i<tratamientos.length ; i++) {
				if(tratamientos[i] instanceof Salud) {
					a=a+((Salud)tratamientos[i]).calcularCostoTratamiento();
				}
				else {
					a+=tratamientos[i].calcularCostoTratamiento();
				}
			}
			total=a-(a*descuento/100);
			if(formaPago=='e') {
				total=total-total*0.05;
			}
			return total;
		}
	}
	
	
	Clientes(){}
	
	Clientes(String nombre, int numeroDocumento, String objetivo, Calendar fechaNacimiento, Calendar fechaInicio,
			Sucursales[] sucursales, char formaPago) {
		this();
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
		this.objetivo = objetivo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInicio = fechaInicio;
		this.sucursales = sucursales;
		this.formaPago = formaPago;
	}
	@Override
	public double calcularCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
