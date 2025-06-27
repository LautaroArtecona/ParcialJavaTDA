package ar.edu.ar.ort.parcial2.clases;


public interface Nomina {

	public abstract boolean hayDisponibilidad();
	
	public abstract void agregarAcreditacion(Acreditacion acreditacion);

	public abstract int getCantidadAcreditaciones();

	public abstract Acreditacion obtenerAcreditacion(int dni);
	

}