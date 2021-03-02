package misComponentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Titulos extends JLabel {
	//atributos
	
	
	//metodos
	public Titulos (String texto, int tamano, Color colorFonto) {
		this.setText(texto);
		Font font = new Font (Font.SERIF,Font.BOLD + Font.ITALIC, tamano);
		this.setFont(font);
		this.setBackground(colorFonto);
		this.setForeground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
	}
}
