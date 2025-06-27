package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Festival {

	private static final int CANT_PELICULAS = 10;

	private Pelicula[] peliculas;
	private VIPsPorDNI dniVips;
	private Cola<Registracion> registraciones;

	public Festival(String[] titulos ) {
		dniVips = new VIPsPorDNI();
		registraciones = new ColaNodos<Registracion>();
		// haciendo esto se puede probar con menos películas
		peliculas = new Pelicula[Math.min(CANT_PELICULAS, titulos.length)];
		completarArrayPeliculas(titulos);
	}

	private Pelicula buscarPelicula(String tituloPelicula) {
		Pelicula pel = null;
		int index = 0;
		while (pel == null && index < peliculas.length) {
			if (this.peliculas[index].mismoTitulo(tituloPelicula)) {
				pel = this.peliculas[index];
			} else {
				index++;
			}
		}
		return pel;
	}
	
	public int[][] obtenerAcreditadosPorTipoDeFuncionYPelicula() {
		int[][] datos = new int[this.peliculas.length][TiposDeFuncion.values().length];
		for (int pel = 0; pel < datos.length; pel++) {
			datos[pel] = this.peliculas[pel].obtenerAcreditadosPorTipoDeFuncion();
		}
		return datos;
	}

	private boolean esVip(int dni) {
		return this.dniVips.exists(dni);
	}

	public void procesarRegistraciones() {
		while (!registraciones.isEmpty()) {
			Registracion registracion = this.registraciones.remove();
			Pelicula pelicula = buscarPelicula(registracion.getTituloPelicula());
			pelicula.acreditar(registracion, esVip(registracion.getDni()));
		}

	}

	// Metodos agregados para complementar la implementacion.
	public void agregarVIP(int dni) {
		dniVips.add(dni);
	}

	private void completarArrayPeliculas(String [] titulos) {
		for (int p = 0; p < titulos.length; p++) {
			peliculas[p] = new Pelicula(titulos[p]);
		}
	}

	public void registrar(String tituloPelicula, int dni, String nombreCompleto) {
		registraciones.add(new Registracion(dni, nombreCompleto, tituloPelicula));

	}

	public void mostrarDatosDeAcreditaciones() {
		int[][] acredXTipoFunYPeli = obtenerAcreditadosPorTipoDeFuncionYPelicula();
		
		informarAcreditadosXPeli(acredXTipoFunYPeli);
		informarAcreditadorTotales(acredXTipoFunYPeli);

	}

	private void informarAcreditadorTotales(int[][] acredXTipoFunYPeli) {
		System.out.println("Acreditados TOTAL");
		int contTotal = 0;
		for (int i = 0; i < acredXTipoFunYPeli[i].length; i++) {
			int cont = 0;
			for (int j = 0; j < acredXTipoFunYPeli.length; j++) {
				cont += acredXTipoFunYPeli[j][i];
			}
			contTotal += cont;
			System.out.print(TiposDeFuncion.values()[i] + ": " + cont + " - ");
			
		}
		System.out.print("TOTAL: " + contTotal + "\n");
		System.out.println();
	}

	private void informarAcreditadosXPeli(int[][] acredXTipoFunYPeli) {
		for (int i = 0; i < acredXTipoFunYPeli.length; i++) {
			int cont = 0;
			System.out.println("Acreditados '" + peliculas[i].getNombre() + "'");
			for (int j = 0; j < acredXTipoFunYPeli[i].length; j++) {
				System.out.print(TiposDeFuncion.values()[j] + ": " + acredXTipoFunYPeli[i][j] + " - ");
				cont += acredXTipoFunYPeli[i][j];
			}
			System.out.print("TOTAL: " + cont + "\n");
			System.out.println("Funciones " + TiposDeFuncion.GENERAL + ": " + peliculas[i].getFuncionesGeneralesNecesarias());
			System.out.println();
		}
		
	}
	

	public void crearFunciones() {
		for (Pelicula p : peliculas) {
			p.generarFuncion();
		}
		
	}

	public void listarFunciones() {
		for (Pelicula p : peliculas) {
			p.mostrarFunciones();
		}
		
	}

}