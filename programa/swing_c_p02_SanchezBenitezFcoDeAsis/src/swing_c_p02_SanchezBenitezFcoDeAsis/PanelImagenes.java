package swing_c_p02_SanchezBenitezFcoDeAsis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Francisco de Asis Sanchez Benitez
 * Clase PanelImagenes que extiende de JPanel
 *
 */
public class PanelImagenes extends JPanel{
	
	/**
	 * Atributos de la clase
	 */
	public static JLabel habitacion1= new JLabel();
	public static JLabel habitacion2= new JLabel();
	public static JLabel habitacion3= new JLabel();
	
	private ImageIcon foto1;
	private ImageIcon foto2;
	private ImageIcon foto3;
	
	/**
	 * Constructor
	 */
	public PanelImagenes() {
		
		/**
		 * Le damos un flowLayout al panel
		 */
		setLayout(new FlowLayout(1,10,50));
		
		/**
		 * Le cambiamos el color de fondo al panel
		 */
		setBackground(new Color(237,207,179));
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos a un JLabel
		 */
		foto1=new ImageIcon(getClass().getResource("/recursos/habitacion1.jpg"));
		Image imagen=foto1.getImage();
		ImageIcon imagen2= new ImageIcon(imagen.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
		habitacion1.setIcon(imagen2);
		
		/**
		 * Le damos un borde al JLabel
		 */
		habitacion1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)), "SIMPLE",TitledBorder.CENTER ,TitledBorder.TOP ));
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos a un JLabel
		 */
		foto2=new ImageIcon(getClass().getResource("/recursos/habitacion2.jpg"));
		Image imagen3=foto2.getImage();
		ImageIcon imagen4= new ImageIcon(imagen3.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
		habitacion2.setIcon(imagen4);
		
		/**
		 * Le damos un borde al JLabel
		 */
		habitacion2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)), "DOUBLE",TitledBorder.CENTER ,TitledBorder.TOP ));
		
		/**
		 * Creamos un ImageIcon y se lo aniadimos a un JLabel
		 */
		foto3=new ImageIcon(getClass().getResource("/recursos/habitacion3.png"));
		Image imagen5=foto3.getImage();
		ImageIcon imagen6= new ImageIcon(imagen5.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
		habitacion3.setIcon(imagen6); 
		
		/**
		 * Le damos un borde al JLabel
		 */
		habitacion3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26,128,130)), "SUIT",TitledBorder.CENTER ,TitledBorder.TOP ));
		
		/**
		 * Hacemos visible el primer JLabel ya que es el que aparecera por defecto mientras el resto no seran visibles
		 */
		habitacion1.setVisible(true);
		habitacion2.setVisible(false);
		habitacion3.setVisible(false);
		
		/**
		 * Aniadimos los JLabel al panel
		 */
		add(habitacion1);
		add(habitacion2);
		add(habitacion3);
	}
}
