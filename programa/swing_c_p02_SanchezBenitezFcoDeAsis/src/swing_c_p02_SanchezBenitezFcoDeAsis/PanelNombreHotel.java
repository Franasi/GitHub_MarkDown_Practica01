package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * Clase PanelNombreHotel que extiende de JPanel
 *
 */
public class PanelNombreHotel extends JPanel{

	/**
	 * Atributos de la clase
	 */
	private JLabel nombre=new JLabel("Hotel Francisco de Asís");
	private ImageIcon foto;
	
	/**
	 * Constructors
	 */
	public PanelNombreHotel() {
		
		/**
		 * Le damos un color al fondo
		 */
		setBackground(new Color(222,175,149));
		
		/**
		 * Le damos un borde al panel
		 */
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)));
		
		/**
		 * Cambiamos la fuente
		 */
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 100));
		
		/**
		 * Cambiamos el color del texto
		 */
		nombre.setForeground(new Color(82,73,64));
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos al JLabel
		 */
	    foto=new ImageIcon(getClass().getResource("/recursos/LogoHotel.png"));
		Image imagen=foto.getImage();
		ImageIcon imagen2= new ImageIcon(imagen.getScaledInstance(200, 90, Image.SCALE_SMOOTH));
		nombre.setIcon(imagen2);
		
		/**
		 * Aniadimos el JLabel al panel
		 */
		add(nombre);
	}
}
