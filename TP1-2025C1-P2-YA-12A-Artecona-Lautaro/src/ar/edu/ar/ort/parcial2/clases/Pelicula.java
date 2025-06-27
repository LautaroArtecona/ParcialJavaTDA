package ar.edu.ar.ort.parcial2.clases;

import java.util.ArrayList;

public class Pelicula {

	private static final int CANT_BUTACAS = 800;
	private String tituloPelicula;
	private ArrayList<Funcion> funciones;
	private final Nomina[] nominas = { new NominaPorDNI(CANT_BUTACAS), new NominaPorDNI(CANT_BUTACAS),
			new NominaPorOrdenDeLlegada() };

	public Pelicula(String titulo) {
		this.tituloPelicula = titulo;
		this.funciones = new ArrayList<>();
	}

	public void acreditar(Registracion registracion, boolean esVip) {
		Acreditacion acreditacion = registracion.generarAcreditacion();
		if (esVip) {
			asignarAcreditacionVIP(acreditacion);
		} else {
			this.nominas[TiposDeFuncion.GENERAL.ordinal()].agregarAcreditacion(acreditacion);
		}
	}

	private void asignarAcreditacionVIP(Acreditacion acreditacion) {
		boolean asignada = false;
		int index = 0;
		while (!asignada && index < TiposDeFuncion.values().length) {
			if (nominas[index].hayDisponibilidad()) {
				nominas[index].agregarAcreditacion(acreditacion);
				asignada = true;
			} else {
				index++;
			}
		}
	}

	public boolean mismoTitulo(String tituloPelicula) {
		return this.tituloPelicula.equals(tituloPelicula);
	}

	public int[] obtenerAcreditadosPorTipoDeFuncion() {
		int[] aux = new int[TiposDeFuncion.values().length];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = nominas[i].getCantidadAcreditaciones();
		}
		return aux;
	}
	
	public int getFuncionesGeneralesNecesarias() {
		int cantAcred = nominas[TiposDeFuncion.GENERAL.ordinal()].getCantidadAcreditaciones();

		return (cantAcred / CANT_BUTACAS) + (cantAcred % CANT_BUTACAS == 0 ? 0 : 1);
	}

	public String getNombre() {
		return this.tituloPelicula;
	}
	
	public void generarFuncion() {
		generarFuncionesPremium();
		generarFuncionesGenerales();
	}
	
	private void generarFuncionesGenerales() {
		int cantFunGen = getFuncionesGeneralesNecesarias();
		NominaPorOrdenDeLlegada n = (NominaPorOrdenDeLlegada)nominas[TiposDeFuncion.GENERAL.ordinal()];
		
		for (int i = 0; i < cantFunGen; i++) {
			NominaPorDNI a = new NominaPorDNI(CANT_BUTACAS);
			while (a.hayDisponibilidad() && !n.nominaVacia()) {
				a.agregarAcreditacion(n.sacarAcreditado());
			}
			funciones.add(new Funcion(this.tituloPelicula, TiposDeFuncion.GENERAL, a));
		}
	}

	private void generarFuncionesPremium() {
		for (int i = 0; i < nominas.length-1; i++) {
			if(nominas[i].getCantidadAcreditaciones() > 0) {				
				NominaPorDNI a;
				a = (NominaPorDNI)nominas[i];
				funciones.add(new Funcion(this.tituloPelicula, TiposDeFuncion.values()[i], a));
				nominas[i] = new NominaPorDNI(CANT_BUTACAS);
			}
			
		}
	}
	
	public void mostrarFunciones() {
		for (Funcion f : funciones) {
			System.out.println(f);
		}
	}
	
}