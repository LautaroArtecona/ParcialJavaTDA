package ar.edu.ar.ort.parcial2.clases;

public class Funcion {
	private TiposDeFuncion tipoFuncion;
	private String peli;
	private Nomina nomina;
	
	public Funcion(String p, TiposDeFuncion tp, Nomina nomina) {
		this.peli = p;
		this.tipoFuncion = tp;
		this.nomina = nomina;
	}

	@Override
	public String toString() {
		return "Funcion [titulo=" + peli + ", tipoDeFuncion="+ tipoFuncion + ", acreditaciones=" + nomina.getCantidadAcreditaciones() + "]";
	}
	
	
}
