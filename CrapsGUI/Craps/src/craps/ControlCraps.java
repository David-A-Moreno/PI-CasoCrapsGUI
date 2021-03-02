/*
 * Programación Interactiva
 * Autor: David Andres Moreno - 1942750-2711
 * Caso 1: Juego Craps
 */
package craps;
 
// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps. Clase que maneja la lógica del juego. Determina el valor del tiro, el estado del juego, el valor del punto, etc.
 */
public class ControlCraps {
	
	private Dado dado1, dado2;
	
	private int tiro, punto, estado;
	
	private boolean lanzamiento;
	
	private int[] carasDados;
	
	/**
	 * Instantiates a new control craps. Constructor de la clase que se encarga de crear los objetos a usar.
	 */
	public ControlCraps() {
		dado1 = new Dado();
		dado2 = new Dado();
		lanzamiento = true;
		carasDados = new int[2];
	}
	
	/**
	 * Calcular tiro. Simula el lanzamiento de los dados y establece el valor del tiro.
	 */
	public void calcularTiro() {
		carasDados[0]=dado1.getCaraVisible();
		carasDados[1]=dado2.getCaraVisible();
		tiro = carasDados[0] + carasDados[1];
	}
	
	/**
	 * Determinar juego. Determina el valor del juego: estado = 1 = ganar, estado = 2 = perder, estado = 3 = punto.
	 */
	public void determinarJuego() {
		if(lanzamiento) {
			if(tiro == 7 || tiro == 11) {
				estado = 1; // ganar
			}
			else {
				if (tiro == 2 || tiro == 3 || tiro == 12) {
					estado = 2; // perder
				}
				else {
					estado = 3; // entra a ronda de punto
					punto = tiro;
					lanzamiento = false;
				}
			}
		}
		else {
			rondaPunto();
		}
	}
	
	/**
	 * Ronda punto. Establece el estado del juego cuando está en la ronda punto.
	 */
	private void rondaPunto() {
		if (tiro == punto) {
			estado = 1; //ganar
			lanzamiento = true;
		}
		if (tiro == 7) {
			estado = 2; //perder
			lanzamiento = true;
		}
	}
	
	/**
	 * Sets the abandono. Establece el estado del juego si el usuario abandona en la ronda de punto
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true;
	}

	/**
	 * Gets the tiro.
	 *
	 * @return the tiro
	 */
	public int getTiro() {
		return tiro;
	}

	/**
	 * Gets the punto.
	 *
	 * @return the punto
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Gets the caras dados.
	 *
	 * @return the caras dados
	 */
	public int[] getCarasDados() {
		return carasDados;
	}
	
	/**
	 * Gets the cara dado 1.
	 *
	 * @return the int
	 */
	public int GetCaraDado1() {
		return carasDados[0];
	}
	
	/**
	 * Gets the cara dado 2.
	 *
	 * @return the int
	 */
	public int GetCaraDado2() {
		return carasDados[1];
	}
}
