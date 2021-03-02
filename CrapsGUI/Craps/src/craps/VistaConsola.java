/*
 * Programación Interactiva
 * Autor: David Andres Moreno - 1942750-2711
 * Caso 1: Juego Craps
 */
package craps;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola. 
 * Clase encargada de realizar las operaciones I/O por línea de comando usando objeto Scanner.
 */
public class VistaConsola {

	private ControlCraps controlCraps;
	
	private String pregunta;
	
	private Scanner lecturaDatos;
	
	/**
	 * Instantiates a new vista consola. Constructor de la clase, inicia los objetos auxiliares.
	 */
	public VistaConsola() {
		controlCraps = new ControlCraps();
		lecturaDatos = new Scanner(System.in);
	}
	
	/**
	 * Iniciar juego. Inicia la ronda de juego.
	 */
	public void iniciarJuego() {
		System.out.println("¿Desea lanzar los dados? escribe y/n");
		pregunta = lecturaDatos.nextLine();
		
		if(pregunta.equals("y")) {
			//inicia juego
			controlCraps.calcularTiro();
			System.out.printf("Dado 1 = %d Dado2 = %d Tiro = %d \n", controlCraps.GetCaraDado1()
																   , controlCraps.GetCaraDado2()
																   , controlCraps.getTiro());
			controlCraps.determinarJuego();
			switch(controlCraps.getEstado()) {
				case 1: System.out.println("Has Ganado!!"); 
					break;
				case 2: System.out.println("Has Perdido"); 
					break;
				case 3: System.out.printf("Has establecido punto = %d, debes lanzar nuevamente!! \n", controlCraps.getPunto());
						while(controlCraps.getEstado() == 3) {
							System.out.println("¿Deseas Lanzar? escribe y/n");
							pregunta = lecturaDatos.nextLine();
						
							if(pregunta.equals("y")) {
								controlCraps.calcularTiro();
								System.out.printf("Dado 1 = %d Dado2 = %d Tiro = %d \n", controlCraps.GetCaraDado1()
										   											   , controlCraps.GetCaraDado2()
										   											   , controlCraps.getTiro());
								controlCraps.determinarJuego();
							}
							else {
								System.out.println("Perdiste por abandonar el juego");
								controlCraps.setAbandono();
							}
						}
						if (controlCraps.getEstado() == 1) {
							System.out.println("Lograste el punto y ganaste!!");
						}
						else { 
							System.out.println("Perdiste!!");
						}
					break;
			}
			seguirJuego();
		}
		else {
			System.out.println("Bye!!");
		}
	}
	
	/**
	 * Seguir juego. Inicia una nueva ronda de juega
	 */
	private void seguirJuego() {
		System.out.println("¿Quieres volver a jugar otra ronda? escribe y/n");
		pregunta = lecturaDatos.nextLine();
		if(pregunta.equals("y")) {
			iniciarJuego();
		}
		else {
			System.out.println("Bye!!");
		}
	}
}
